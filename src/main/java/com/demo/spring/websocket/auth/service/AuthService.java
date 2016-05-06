package com.demo.spring.websocket.auth.service;

import org.springframework.stereotype.Service;

import com.demo.spring.websocket.auth.domain.Account;
import com.demo.spring.websocket.auth.domain.AuthResult;

/**<p>类描述：类</p>
 * <pre>
 * 改动说明：
 *      【修改人：叶子璀 / 2016年5月2日 下午4:32:38 / 版本：1.0】
 * 
 * </pre>
 * @author 叶子璀
 * @version 1.0
 * @since 2016年5月2日 下午4:32:38
 */
@Service
public class AuthService {

    public void doAuth(Account account, AuthResult result) {
        if (account == null) {
            result.setSuccess(false);
            result.setErrMsg("No valid account data.");
        } else {
            if (account.getUser().equals("test")
                    && account.getPassword().equals("111")) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
                result.setErrMsg("Error user with password.");
            }
        }
    }
}
