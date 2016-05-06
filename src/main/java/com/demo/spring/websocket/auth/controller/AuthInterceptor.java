package com.demo.spring.websocket.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**<p>类描述：类</p>
 * <pre>
 * 改动说明：
 *      【修改人：叶子璀 / 2016年5月5日 上午9:38:46 / 版本：1.0】
 * 
 * </pre>
 * @author 叶子璀
 * @version 1.0
 * @since 2016年5月5日 上午9:38:46
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().equals("/demo")) {

            HttpSession session = request.getSession(false);
            if (session == null) {
                System.out.println("No session.");
                response.sendRedirect("/auth");
                return false;

            } else if (session.getAttribute("account") == null) {
                System.out.println("No session attr account.");
                response.sendRedirect("/auth");
                return false;

            } else {
                System.out.println("Authed session.");
            }
        }
        return super.preHandle(request, response, handler);
    }

}
