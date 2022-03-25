package com.efacture.dev.config;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private CustomJwtAuthenticationFilter customJwtAuthenticationFilter;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
		
	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	
	  @Override 
	  public void configure(AuthenticationManagerBuilder auth) throws
	  Exception {
	  auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); 
	  }
	 
		
		  
		  @Override 
		  @Bean
		  public AuthenticationManager authenticationManagerBean() throws
		  Exception { return super.authenticationManagerBean(); }
		 
	
	@Override
	public void configure(HttpSecurity http) throws Exception {	
		
		
		http.csrf().disable().cors() .and().authorizeRequests().antMatchers(
	               "hellouser","/helloadmin"
	               ,"/efacture/erreurs/**"
	               ,"/efacture/comptes/**"
	               ,"/efacture/facturier/**" )
	               .hasAnyRole("SUPER_ADMIN","ADMIN","USER_PERSO","USER_COM","AUDIT",
	               "COMPTABILITE","HELPDESK","MONETIQUE","COMPTABILITE","SUPPORT","SUPERVISEUR","PRESTATAIRE")
	               .antMatchers("/efacture/consultation/**")
	               .hasAnyRole("SUPER_ADMIN","ADMIN","USER_PERSO","USER_COM","AUDIT",
	                            "COMPTABILITE","HELPDESK","MONETIQUE","COMPTABILITE","SUPPORT","SUPERVISEUR","PRESTATAIRE")
	               .antMatchers("hellouser","/efacture/audit/*").
	               hasAnyRole("SUPER_ADMIN","ADMIN","AUDIT")
	               .antMatchers("hellouser"
	               ,"/efacture/cm/**","/efacture/plafond/**","/efacture/user/**"
	               ).hasAnyRole("SUPER_ADMIN","USER_COM","USER_PERSO","ADMIN","HELPDESK",
	               "COMPTABILITE","SUPPORT","SUPERVISEUR")
	               .antMatchers("hellouser","/efacture/commission/**"
	               ).hasAnyRole("SUPER_ADMIN","USER_COM","USER_PERSO","ADMIN","HELPDESK",
	               "COMPTABILITE","SUPERVISEUR")
	               .antMatchers("/efacture/paie/**","/efacture/em/**","/efacture/rg/**","/Api/pay","/Api/facture/**").hasAnyRole("USER_COM","USER_PERSO","PRESTATAIRE")
	               .antMatchers("/template/signalitique/**").hasAnyRole("SUPER_ADMIN","ADMIN","HELPDESK","SUPERVISEUR")
	               .antMatchers("/efacture/reclamation/**").hasAnyRole("SUPER_ADMIN","ADMIN","USER_COM","USER_PERSO")	                                
	               .antMatchers("/authenticate",
	               "/register","/efacture/detailUser/*","/efacture/connexion",
	               "/efacture/firstLogin",
	               "/efacture/tentativeConnect/*","/efacture/bloqueUser/*",
	               "/efacture/deconnexion/*","/efacture/mails/*","/efacture/login","/efacture/pwdParam/*").permitAll(
	               ).anyRequest().authenticated()
	               .and().exceptionHandling().authenticationEntryPoint(
	               jwtAuthenticationEntryPoint).
	               and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
	               STATELESS). and().addFilterBefore(customJwtAuthenticationFilter,
	               UsernamePasswordAuthenticationFilter.class);

		
		
		
		/*
		  http.csrf().disable().cors() .and().authorizeRequests().antMatchers(
		  "hellouser","/helloadmin","/efacture/reclamation/**"
		  ,"/efacture/consultation/**","/efacture/erreurs/**"
		  ,"/efacture/comptes/**"
		  ,"/efacture/facturier/**" )
		  .hasAnyRole("SUPER_ADMIN","ADMIN","USER_PERSO","USER_COM","AUDIT",
		  "COMPTABILITE","HELPDESK","MONETIQUE","COMPTABILITE","SUPPORT","SUPERVISEUR")
		  .antMatchers("hellouser","/efacture/audit/*").
		  hasAnyRole("SUPER_ADMIN","ADMIN","AUDIT")
		  .antMatchers("hellouser"
		  ,"/efacture/cm/**","/efacture/plafond/**","/efacture/user/**"
		  ).hasAnyRole("SUPER_ADMIN","USER_COM","USER_PERSO","ADMIN","HELPDESK",
		  "COMPTABILITE","SUPPORT","SUPERVISEUR")
		  .antMatchers("hellouser","/efacture/commission/**"
		  ).hasAnyRole("SUPER_ADMIN","USER_COM","USER_PERSO","ADMIN","HELPDESK",
		  "COMPTABILITE","SUPERVISEUR")
		  .antMatchers("/efacture/paie/**").hasAnyRole("USER_COM","USER_PERSO")
		  .antMatchers("/authenticate",
		  "/register","/efacture/detailUser/*","/efacture/connexion",
		  "/efacture/firstLogin","/template/signalitique/*","/Api/pay",
		  "/Api/facture/*", "/efacture/tentativeConnect/*","/efacture/bloqueUser/*",
		  "/efacture/deconnexion/*","/efacture/mails/*","/efacture/login","/efacture/pwdParam/*").permitAll(
		  ).anyRequest().authenticated()
		  .and().exceptionHandling().authenticationEntryPoint(
		  jwtAuthenticationEntryPoint).
		  and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
		  STATELESS). and().addFilterBefore(customJwtAuthenticationFilter,
		  UsernamePasswordAuthenticationFilter.class);
		 
		 */
	}



}
