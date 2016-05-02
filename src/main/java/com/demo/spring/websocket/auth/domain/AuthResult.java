package com.demo.spring.websocket.auth.domain;

/**<p>类描述：类</p>
 * <pre>
 * 改动说明：
 *      【修改人：叶子璀 / 2016年5月2日 下午3:58:29 / 版本：1.0】
 * 
 * </pre>
 * @author 叶子璀
 * @version 1.0
 * @since 2016年5月2日 下午3:58:29
 */
public class AuthResult {

    private boolean isSuccess;
    private String errMsg;

    /**
     * <p>方法描述：获取isSuccess的方法</p>
     * <pre>
     * 改动说明：
     *      【修改人：叶子璀 / 2016年5月2日 下午3:59:02 / 版本：1.0】
     * </pre>
     * @return 返回isSuccess
     */
    public boolean isSuccess() {
        return this.isSuccess;
    }

    /**
     * <p>方法描述：设置isSuccess的方法</p>
     * <pre>
     * 改动说明：
     *      【修改人：叶子璀 / 2016年5月2日 下午3:59:02 / 版本：1.0】
     * </pre>
     * @param isSuccess 需要设置的isSuccess
     */
    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * <p>方法描述：获取errMsg的方法</p>
     * <pre>
     * 改动说明：
     *      【修改人：叶子璀 / 2016年5月2日 下午3:59:02 / 版本：1.0】
     * </pre>
     * @return 返回errMsg
     */
    public String getErrMsg() {
        return this.errMsg;
    }

    /**
     * <p>方法描述：设置errMsg的方法</p>
     * <pre>
     * 改动说明：
     *      【修改人：叶子璀 / 2016年5月2日 下午3:59:02 / 版本：1.0】
     * </pre>
     * @param errMsg 需要设置的errMsg
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
