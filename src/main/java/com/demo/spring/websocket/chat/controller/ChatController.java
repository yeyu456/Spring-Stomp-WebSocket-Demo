package com.demo.spring.websocket.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.demo.spring.websocket.chat.service.ChatService;

/**<p>类描述：类</p>
 * <pre>
 * 改动说明：
 *      【修改人：叶子璀 / 2016年4月21日 上午9:37:26 / 版本：1.0】
 * 
 * </pre>
 * @author 叶子璀
 * @version 1.0
 * @since 2016年4月21日 上午9:37:26
 */
@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/country")
    @SendTo("/channel/country")
    public String countryChat(String content) {
        return this.chatService.doChat(content);
    }
}
