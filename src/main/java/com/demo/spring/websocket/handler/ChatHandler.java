package com.demo.spring.websocket.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatHandler extends TextWebSocketHandler{

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
                    throws Exception {
        super.afterConnectionClosed(session, status);
        System.out.println("websocket closed." + session.getId());
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println("websocket opened." + session.getId());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
                    throws Exception {
        String content = message.getPayload();
        System.out.println("websocket content:" +content);
        session.sendMessage(message);
    }

}
