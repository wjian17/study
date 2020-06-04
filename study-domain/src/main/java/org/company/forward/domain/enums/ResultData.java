package org.company.forward.domain.enums;

/**
 * @author wangjian
 * @date 2020/6/3 0003 14:21
 */
public enum ResultData {

    SUCCESS(BasicErrorCode.SERVICE_SUCCESS_CODE,BasicErrorMsg.SERVICE_SUCCESS_MSG),
    TIMEOUT(BasicErrorCode.SERVICE_ERROR_TIMEOUT_CODE,BasicErrorMsg.SERVICE_ERROR_TIMEOUT_MSG);

    private String errorCode;

    private String errorMsg;

    ResultData(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
