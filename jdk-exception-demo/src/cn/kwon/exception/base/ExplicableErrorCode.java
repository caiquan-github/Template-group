package cn.kwon.exception.base;

/**
 * 错误码
 * @author Kwon
 * @date 2024/2/22 16:56
 */
public interface ExplicableErrorCode {
    /**
     * 返回错误信息
     *
     * @return
     * @author Kwon
     * @date 2024/2/22 16:57
     */
    String getMsg();
    /**
     * 返回错误码
     *
     * @return
     * @author Kwon
     * @date 2024/2/22 16:57
     */
    String getCode();
}
