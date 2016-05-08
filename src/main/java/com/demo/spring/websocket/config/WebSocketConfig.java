package com.demo.spring.websocket.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@SpringBootApplication
@EnableWebSocketMessageBroker
@ComponentScan("com.demo.spring.websocket")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WebSocketConfig.class, args);
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry conf) {
        conf.setApplicationDestinationPrefixes("/chat");
        conf.enableSimpleBroker("/channel", "/errors");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /*HttpSessionHandshakeInterceptor interceptor = new StompInterceptors();
        interceptor.setCopyAllAttributes(true);
        interceptor.setCopyHttpSessionId(true);
        interceptor.setCreateSession(false);*/
        registry.addEndpoint("/demo").setAllowedOrigins(
            "*").withSockJS().setTransportHandlers(handlers);
    }
}
