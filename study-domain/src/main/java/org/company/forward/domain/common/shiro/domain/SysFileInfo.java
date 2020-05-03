package org.company.forward.domain.common.shiro.domain;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
public class SysFileInfo {
    private String fileId;
    private String fileData;
    private Date createTime;
    private Date updateTime;
    private Long createUser;
    private Long updateUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysFileInfo that = (SysFileInfo) o;
        return Objects.equals(fileId, that.fileId) &&
                Objects.equals(fileData, that.fileData) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(createUser, that.createUser) &&
                Objects.equals(updateUser, that.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileId, fileData, createTime, updateTime, createUser, updateUser);
    }
}
