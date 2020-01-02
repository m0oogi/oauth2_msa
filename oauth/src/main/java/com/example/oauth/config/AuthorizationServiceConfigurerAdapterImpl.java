package com.example.oauth.config;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.OAuth2AuthorizationServerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;



@EnableAuthorizationServer
@Configuration
class OAuth2Configuration {

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        return new JwtAccessTokenConverter();
    }

}
@Configuration
public class AuthorizationServiceConfigurerAdapterImpl extends OAuth2AuthorizationServerConfiguration{
	
	@Autowired
	JwtAccessTokenConverter jwtAccessTokenConverter;
	
	public AuthorizationServiceConfigurerAdapterImpl(BaseClientDetails details,
			AuthenticationManager authenticationManager, ObjectProvider<TokenStore> tokenStore,
			ObjectProvider<AccessTokenConverter> tokenConverter, AuthorizationServerProperties properties) {
		super(details, authenticationManager, tokenStore, tokenConverter, properties);
	}
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        super.configure(endpoints);
        endpoints.accessTokenConverter(jwtAccessTokenConverter);
    }
    
}




