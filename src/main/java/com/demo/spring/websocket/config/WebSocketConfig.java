package com.demo.spring.websocket.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@SpringBootApplication
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WebSocketConfig.class, args);
    }

    @Bean
    public WebMvcAutoConfigurationAdapter getWebMvcConfig() {
        return new WebMvcConfig();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry conf) {
        conf.setApplicationDestinationPrefixes("/chat");
        conf.enableSimpleBroker("/channel");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/demo").withSockJS();
    }
}
