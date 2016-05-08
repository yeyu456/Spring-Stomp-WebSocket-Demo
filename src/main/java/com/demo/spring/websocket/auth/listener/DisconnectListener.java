package com.demo.spring.websocket.auth.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.demo.spring.websocket.auth.domain.Account;
import com.demo.spring.websocket.auth.service.AuthService;

/**<p>类描述：类</p>
 * <pre>
 * 改动说明：
 *      【修改人：叶子璀 / 2016年5月8日 下午4:44:33 / 版本：1.0】
 * 
 * </pre>
 * @author 叶子璀
 * @version 1.0
 * @since 2016年5月8日 下午4:44:33
 */
@Component
public class DisconnectListener implements
    ApplicationListener<SessionDisconnectEvent> {

    @Autowired
    private AuthService authService;

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        StompHeaderAccessor headers = StompHeaderAccessor.wrap(
            event.getMessage());
        Object account = headers.getSessionAttributes().get("account");
        if ((account != null) && (account instanceof Account)) {
            this.authService.clearLogin((Account) account);
            System.out.println("销毁账号：" + ((Account) account).getUser());
        }
    }

}
