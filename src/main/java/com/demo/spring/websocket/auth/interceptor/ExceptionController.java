package com.demo.spring.websocket.auth.interceptor;

import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.demo.spring.websocket.auth.domain.AuthResult;
import com.demo.spring.websocket.auth.enums.ErrorType;
import com.demo.spring.websocket.auth.exception.MultipleAuthException;
import com.demo.spring.websocket.auth.exception.UnAuthException;

/**<p>类描述：类</p>
 * <pre>
 * 改动说明：
 *      【修改人：叶子璀 / 2016年5月8日 下午3:24:02 / 版本：1.0】
 * 
 * </pre>
 * @author 叶子璀
 * @version 1.0
 * @since 2016年5月8日 下午3:24:02
 */
@ControllerAdvice
public class ExceptionController {

    @MessageExceptionHandler(value = UnAuthException.class)
    @SendToUser(destinations="/errors", broadcast=false)
    public AuthResult onUnAuthError() {
        AuthResult result = new AuthResult();
        result.setSuccess(false);
        result.setErrMsg("Not login.");
        result.setErrorType(ErrorType.UnAuth.ordinal());
        return result;
    }

    @MessageExceptionHandler(value = MultipleAuthException.class)
    @SendToUser(destinations = "/errors", broadcast = false)
    public AuthResult onMultipleAuthError() {
        AuthResult result = new AuthResult();
        result.setSuccess(false);
        result.setErrMsg("Another login.");
        result.setErrorType(ErrorType.MultiAuth.ordinal());
        return result;
    }
}
