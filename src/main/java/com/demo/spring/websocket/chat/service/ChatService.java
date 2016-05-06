package com.demo.spring.websocket.chat.service;

import java.util.Date;

import org.springframework.stereotype.Service;

/**<p>类描述：类</p>
 * <pre>
 * 改动说明：
 *      【修改人：叶子璀 / 2016年5月5日 上午9:04:10 / 版本：1.0】
 * 
 * </pre>
 * @author 叶子璀
 * @version 1.0
 * @since 2016年5月5日 上午9:04:10
 */
@Service
public class ChatService {

    public String doChat(String content) {
        String date = new Date().toString();
        return String.format("[%s]%s", date, content);
    }
}
