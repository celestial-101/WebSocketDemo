package com.implementwebsocket.git.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class Configurer implements WebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		
		registry.addEndpoint("/stomp-endpoint").withSockJS();
		WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
		// Just adding a comment
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {

		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");
		WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
	}
	
	

}
