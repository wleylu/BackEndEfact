package com.efacture.dev.conttroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.config.ConfigTokenService;
import com.efacture.dev.config.CustomUserDetailsService;
import com.efacture.dev.config.JwtUtil;
import com.efacture.dev.model.AuthenticationRequest;
import com.efacture.dev.model.AuthenticationResponse;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.ConfigurationToken;
import com.efacture.dev.model.UserAudite;
import com.efacture.dev.model.Utilisateur;
import com.efacture.dev.model.UtilisateurDTO;
import com.efacture.dev.repository.UserRepository;
import com.efacture.dev.serviceImpl.CmImpl;
import com.efacture.dev.serviceImpl.UserAuditeImpl;

//import com.javainuse.springbootsecurity.config.CustomUserDetailsService;
//import com.javainuse.springbootsecurity.config.JwtUtil;
//import com.javainuse.springbootsecurity.model.AuthenticationRequest;
//import com.javainuse.springbootsecurity.model.AuthenticationResponse;
//import com.javainuse.springbootsecurity.model.UserDTO;

//authentification de connexion

@CrossOrigin("*")
@RestController
public class AuthenticationController {
	//modification de la valeur

	private int jwtExpirationInMs;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private ConfigTokenService configTokenService;
	@Autowired
    private CmImpl cmImpl;
	@Autowired
	private UserAuditeImpl aut;
	
	@Value("${jwt.expirationDateInMs}")
	public void setJwtExpirationInMs(int jwtExpirationInMs) {
		this.jwtExpirationInMs = jwtExpirationInMs;
	}
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getLogin(), authenticationRequest.getPassword1()));
			
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		UserDetails userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getLogin());
		Utilisateur userInfo = userRepository.findByLogin(authenticationRequest.getLogin());
		String token = jwtUtil.generateToken(userdetails);
		userInfo.setToken(token);
		//return ResponseEntity.ok(new AuthenticationResponse(token));
		ConfigurationToken ctoken = configTokenService.getLoginToken(token);
		UserAudite at= aut.ajoutAuditUser(new UserAudite(null, userInfo.getLogin(),
				userInfo.getNom(),userInfo.getPrenom(),userInfo.getHabilitation(),"CONNECTE"));
		if (ctoken==null) {
			ConfigurationToken confToken = configTokenService.saveConfigToken(new ConfigurationToken(authenticationRequest.getLogin(),token,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+jwtExpirationInMs)));
			//System.out.println(confToken.getLogin()+"****"+confToken.getToken() + "****"+confToken.getEntreToken() +
			//		"****"+ confToken.getExpirationToken());
		} else {
			ConfigurationToken confToken = configTokenService.updateConfigToken(ctoken);
			//System.out.println(confToken.getLogin()+"+++++"+confToken.getToken() + "++++"+confToken.getEntreToken() +
			//		"+++++"+ confToken.getExpirationToken());
		}
		
		return ResponseEntity.ok(userInfo);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UtilisateurDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
}
