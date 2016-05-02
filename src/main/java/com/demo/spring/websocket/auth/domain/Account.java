package com.demo.spring.websocket.auth.domain;

/**<p>类描述：类</p>
 * <pre>
 * 改动说明：
 *      【修改人：叶子璀 / 2016年5月2日 下午4:42:50 / 版本：1.0】
 * 
 * </pre>
 * @author 叶子璀
 * @version 1.0
 * @since 2016年5月2日 下午4:42:50
 */
public class Account {

    private String user;
    private String password;

    /**
     * <p>方法描述：获取user的方法</p>
     * <pre>
     * 改动说明：
     *      【修改人：叶子璀 / 2016年5月2日 下午4:43:20 / 版本：1.0】
     * </pre>
     * @return 返回user
     */
    public String getUser() {
        return this.user;
    }

    /**
     * <p>方法描述：设置user的方法</p>
     * <pre>
     * 改动说明：
     *      【修改人：叶子璀 / 2016年5月2日 下午4:43:20 / 版本：1.0】
     * </pre>
     * @param user 需要设置的user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * <p>方法描述：获取password的方法</p>
     * <pre>
     * 改动说明：
     *      【修改人：叶子璀 / 2016年5月2日 下午4:43:20 / 版本：1.0】
     * </pre>
     * @return 返回password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * <p>方法描述：设置password的方法</p>
     * <pre>
     * 改动说明：
     *      【修改人：叶子璀 / 2016年5月2日 下午4:43:20 / 版本：1.0】
     * </pre>
     * @param password 需要设置的password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
