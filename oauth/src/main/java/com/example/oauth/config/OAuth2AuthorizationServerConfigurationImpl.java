package com.example.oauth.config;

import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.OAuth2AuthorizationServerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfigurationImpl extends OAuth2AuthorizationServerConfiguration{
    
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private NoOpPasswordEncoder passwordEncoder;
    @Autowired
    private DataSource dataSource;
    
    public OAuth2AuthorizationServerConfigurationImpl(BaseClientDetails details,
    		AuthenticationManager authenticationManager, ObjectProvider<TokenStore> tokenStore,
    		ObjectProvider<AccessTokenConverter> tokenConverter, AuthorizationServerProperties properties) {
    	super(details, authenticationManager, tokenStore, tokenConverter, properties);
    }
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)throws Exception {
    	super.configure(endpoints);
    	endpoints
        	.accessTokenConverter(jwtAccessTokenConverter)
        	.tokenStore(tokenStore);
    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
    	clients.jdbc(dataSource);
    }

}




