package com.demo.spring.websocket.auth.service;

import org.springframework.stereotype.Service;

import com.demo.spring.websocket.auth.domain.Account;

/**<p>类描述：类</p>
 * <pre>
 * 改动说明：
 *      【修改人：叶子璀 / 2016年5月9日 下午6:36:43 / 版本：1.0】
 * 
 * </pre>
 * @author 叶子璀
 * @version 1.0
 * @since 2016年5月9日 下午6:36:43
 */
@Service
public class LockService {

    public void lock(Account account) {
        System.out.println("锁定账号：" + account.getUser());
    }
}
