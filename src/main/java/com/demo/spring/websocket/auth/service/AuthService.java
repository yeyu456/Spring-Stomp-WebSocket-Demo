package com.demo.spring.websocket.auth.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.demo.spring.websocket.auth.domain.Account;
import com.demo.spring.websocket.auth.domain.AuthResult;
import com.demo.spring.websocket.auth.enums.ErrorType;

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

    private static Map<String, String> LOGIN_SESSIONS = new HashMap<String, String>();
    private static int count = 0;
    private static int MAX_COUNT = 3;

    @Autowired
    private LockService lockService;

    public void doAuth(Account account, AuthResult result, String sessionId) {
        if (account == null) {
            result.setSuccess(false);
            result.setErrMsg("No valid account data.");
        } else {
            if (account.getUser().equals("test")
                    && account.getPassword().equals("111")) {
                result.setSuccess(true);
                String oldSessionId = LOGIN_SESSIONS.get(account.getUser());
                if ((oldSessionId != null) && !oldSessionId.equals(sessionId)) {
                    count++;
                }
                if (count > MAX_COUNT) {
                    this.lockService.lock(account);
                }
                LOGIN_SESSIONS.put(account.getUser(), sessionId);

            } else {
                result.setSuccess(false);
                result.setErrMsg("Error user with password.");
                result.setErrorType(ErrorType.InvalidAuth.ordinal());
            }
        }
    }

    public boolean isLogin(Account account, String sessionId) {
        if ((account == null) || StringUtils.isEmpty(sessionId)) {
            return false;
        }
        if (!LOGIN_SESSIONS.containsKey(account.getUser())) {
            LOGIN_SESSIONS.put(account.getUser(), sessionId);
            return true;

        } else {
            if (LOGIN_SESSIONS.get(account.getUser()).equals(sessionId)) {
                return true;

            } else {
                System.out.println("账号异地登陆.");
                return false;
            }
        }
    }

    public void clearLogin(Account account) {
        LOGIN_SESSIONS.remove(account.getUser());
    }
}
