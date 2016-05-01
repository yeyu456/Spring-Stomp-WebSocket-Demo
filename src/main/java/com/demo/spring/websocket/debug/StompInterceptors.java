package com.demo.spring.websocket.debug;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**<p>类描述：类</p>
 * <pre>
 * 改动说明：
 *      【修改人：叶子璀 / 2016年5月1日 下午3:26:16 / 版本：1.0】
 * 
 * </pre>
 * @author 叶子璀
 * @version 1.0
 * @since 2016年5月1日 下午3:26:16
 */
public class StompInterceptors extends HttpSessionHandshakeInterceptor {

    @Override
    public void afterHandshake(ServerHttpRequest request,
            ServerHttpResponse response, WebSocketHandler wsHandler,
            Exception ex) {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
            HttpSession session = serverRequest.getServletRequest().getSession(
                false);
            if (session != null) {
                System.out.println("Handshake complete. ID:" + session.getId());
            }
        }
        super.afterHandshake(request, response, wsHandler, ex);
    }

}
