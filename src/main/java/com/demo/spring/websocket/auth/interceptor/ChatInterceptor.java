package com.demo.spring.websocket.auth.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

import com.demo.spring.websocket.auth.domain.Account;
import com.demo.spring.websocket.auth.exception.MultipleAuthException;
import com.demo.spring.websocket.auth.exception.UnAuthException;
import com.demo.spring.websocket.auth.service.AuthService;

/**<p>类描述：类</p>
 * <pre>
 * 改动说明：
 *      【修改人：叶子璀 / 2016年5月8日 下午2:49:51 / 版本：1.0】
 * 
 * </pre>
 * @author 叶子璀
 * @version 1.0
 * @since 2016年5月8日 下午2:49:51
 */
public class ChatInterceptor extends ChannelInterceptorAdapter {

    @Autowired
    private AuthService authService;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        Object account = accessor.getSessionAttributes().get("account");
        if ((account == null) || (!(account instanceof Account))) {
            throw new UnAuthException();

        } else if (!this.authService.isLogin((Account) account,
            accessor.getSessionId())) {
            throw new MultipleAuthException();
        }
        return message;
    }
}
