package com.devsuperior.movieflix.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	private static final String[] PUBLIC = { "/oauth/token", "/h2-console/**"};//caminhos para fazer login e acessar o H2 por isso são publicos
	
	private static final String[] VISITOR_GET = {"/genres/**", "/movies/**"};
	
	private static final String[] VISITOR_MEMBER_GET = {"/genres/**", "/movies/**", "movies/genres/**", "/reviews/**"};//, "/movies?genreId=", "/movies?genreId{id}"};
	
	private static final String[] MEMBER_POST = {"/genres/**", "/movies/**", "/reviews/**"};
	
	private static final String[] ADMIN_ALL = {"/genres/**", "/movies/**"};
	
	

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//Libera o H2
		if(Arrays.asList(env.getActiveProfiles()).contains("test")){
			http.headers().frameOptions().disable();
		}
		
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		//.antMatchers(HttpMethod.GET, VISITOR_GET).hasAnyRole("VISITOR")
		.antMatchers(HttpMethod.GET, VISITOR_MEMBER_GET).hasAnyRole("MEMBER", "VISITOR")
		.antMatchers(HttpMethod.POST, ADMIN_ALL).hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.POST, MEMBER_POST).hasAnyRole("MEMBER")
		.anyRequest().hasAnyRole("ADMIN");
		
	}
	
	

}
