package com.example.authserver.web.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.example.authserver.persistence.domain.entity.User;

public class CustomTokenEnhancer extends JwtAccessTokenConverter {
	
	
	/**
	 * Enhace access token. This will send as response.
	 * @author Mindbowser | deepak.kumbhar@mindbowser.com
     * @since Apr 28, 2020
	 */
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		User user = (User) authentication.getPrincipal();
		Map<String, Object> info = new LinkedHashMap<>(accessToken.getAdditionalInformation());
		info.put("email", user.getEmail());
		DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
		customAccessToken.setAdditionalInformation(info);
		return super.enhance(customAccessToken, authentication);
	}
}