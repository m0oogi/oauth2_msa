package com.example.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@EnableResourceServer // 자원서버 설정
@Configuration
public class ResourceServerConfigurerAdapterImpl extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http.headers().frameOptions().disable();
    	http.authorizeRequests()
		.antMatchers("/members", "/members/**").access("#oauth2.hasScope('read')")
		.anyRequest().authenticated();
    }
}
