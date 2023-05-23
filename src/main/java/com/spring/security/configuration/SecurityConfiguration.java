package com.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
	//old spring security configuration code
	/*
	 * // private static final String ADMIN = "ADMIN"; // private static final
	 * String USER = "USER"; // // @Autowired // private UserDetailsService
	 * userDetailsService; // // @Override // protected void
	 * configure(AuthenticationManagerBuilder auth) throws Exception { //
	 * auth.userDetailsService(userDetailsService); // } // // @Override //
	 * protected void configure(HttpSecurity http) throws Exception { //
	 * http.authorizeRequests().antMatchers("/admin").hasRole(ADMIN) //
	 * .antMatchers("/user").hasAnyRole(ADMIN, USER) //
	 * .antMatchers("/all").permitAll() // .and().formLogin(); // } // // @Bean //
	 * public BCryptPasswordEncoder getPasswordEncoder() { // return new
	 * BCryptPasswordEncoder(); // } // //
	 */	
	
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests((authz) -> authz
				.antMatchers("/public","/swagger-ui/*", "/swagger-resources/**", "/v3/api-docs", "/webjars/**").permitAll()
				.antMatchers("/user").hasRole("USER")
				.antMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
				).formLogin();

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		return new CustomUserDetailService();
		
		//in memory authentication
		/*
		 * UserDetails user = User.withUsername("test") .password("test")
		 * .roles("USER") .build();
		 * 
		 * UserDetails admin = User.withUsername("admin") .password("admin")
		 * .roles("ADMIN") .build();
			return new InMemoryUserDetailsManager(user,admin);
		 * 
		 */
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	   DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	   authProvider.setUserDetailsService(userDetailsService());
	   authProvider.setPasswordEncoder(passwordEncoder());
	   return authProvider;
  }
}
