package com.ohgiraffers.testlivechat;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    // connection을 맺을때 CORS 허용
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/").setAllowedOrigins("*").withSockJS();
    }

}