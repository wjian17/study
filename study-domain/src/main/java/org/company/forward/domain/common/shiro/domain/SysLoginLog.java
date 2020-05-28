package org.company.forward.domain.common.shiro.domain;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class SysLoginLog {
    private long loginLogId;
    private String logName;
    private Long userId;
    private Date createTime;
    private String succeed;
    private String message;
    private String ipAddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysLoginLog that = (SysLoginLog) o;
        return loginLogId == that.loginLogId &&
                Objects.equals(logName, that.logName) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(succeed, that.succeed) &&
                Objects.equals(message, that.message) &&
                Objects.equals(ipAddress, that.ipAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginLogId, logName, userId, createTime, succeed, message, ipAddress);
    }
}
