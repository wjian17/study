package org.company.forward.domain.common.shiro.domain;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
public class SysOperationLog {
    private long operationLogId;
    private String logType;
    private String logName;
    private Long userId;
    private String className;
    private String method;
    private Date createTime;
    private String succeed;
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysOperationLog that = (SysOperationLog) o;
        return operationLogId == that.operationLogId &&
                Objects.equals(logType, that.logType) &&
                Objects.equals(logName, that.logName) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(className, that.className) &&
                Objects.equals(method, that.method) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(succeed, that.succeed) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationLogId, logType, logName, userId, className, method, createTime, succeed, message);
    }
}
