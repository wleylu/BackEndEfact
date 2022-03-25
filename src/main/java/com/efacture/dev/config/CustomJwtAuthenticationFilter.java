package com.efacture.dev.config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.efacture.dev.model.ConfigurationToken;
import com.efacture.dev.repository.ConfigTokenRepository;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class CustomJwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private ConfigTokenService configTokenService;
	
	@Autowired
	private ConfigTokenRepository configTokenRepository;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		 try{
			// JWT Token is in the form "Bearer token". Remove Bearer word and
			// get  only the Token
			String jwtToken = extractJwtFromRequest(request);
			Date dt = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");

			if (StringUtils.hasText(jwtToken) && jwtTokenUtil.validateToken(jwtToken)) {
				
				
				UserDetails userDetails = new User(jwtTokenUtil.getUsernameFromToken(jwtToken), "",
						jwtTokenUtil.getRolesFromToken(jwtToken));
			

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				
				ConfigurationToken conft = getToken(userDetails.getUsername());
				
				if(dt.getTime() < conft.getExpirationToken().getTime()) {
				
					if(conft != null) {
						//long addtime = conft.getExpirationToken().getTime() + 30000;
						//System.out.println(addtime);
						conft.setExpirationToken(new Date(System.currentTimeMillis() + 360000));
						configTokenRepository.save(conft);
					}
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					//System.out.println(SecurityContextHolder.getContext().getAuthentication());
				}else {
						System.out.println("Cannot set the Security Context");
				}
				//SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			} else {
				System.out.println("Cannot set the Security Context");
			}
		 }catch(ExpiredJwtException ex)
		 {
			 request.setAttribute("exception", ex);
		 }
		 catch(BadCredentialsException ex)
		 {
			 request.setAttribute("exception", ex);
		 }
		chain.doFilter(request, response);
	}

	private String extractJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {			
			//System.out.println("User connecté "+ request.getUserPrincipal());			
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}
	private ConfigurationToken getToken(String confToken) {
		return configTokenService.getLoginToken(confToken);
	}
}