package com.demo.spring.websocket.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.spring.websocket.auth.domain.Account;
import com.demo.spring.websocket.auth.domain.AuthResult;
import com.demo.spring.websocket.auth.service.AuthService;

/**<p>类描述：类</p>
 * <pre>
 * 改动说明：
 *      【修改人：叶子璀 / 2016年5月2日 下午3:57:51 / 版本：1.0】
 * 
 * </pre>
 * @author 叶子璀
 * @version 1.0
 * @since 2016年5月2日 下午3:57:51
 */
@Controller
@SessionAttributes(value = "account")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @MessageMapping("/auth")
    @SendToUser(value = "/errors", broadcast = false)
    public AuthResult doAuth(@Payload Account account,
            StompHeaderAccessor accessor) {
        AuthResult result = new AuthResult();
        this.authService.doAuth(account, result, accessor.getSessionId());
        if (result.isSuccess()) {
            accessor.getSessionAttributes().put("account", account);
        }
        return result;
    }
}
