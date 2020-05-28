package org.company.forward.domain.common.shiro.domain;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class SysRole {
    private long roleId;
    private Long pid;
    private String name;
    private String description;
    private Integer sort;
    private Integer version;
    private Date createTime;
    private Date updateTime;
    private Long createUser;
    private Long updateUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysRole sysRole = (SysRole) o;
        return roleId == sysRole.roleId &&
                Objects.equals(pid, sysRole.pid) &&
                Objects.equals(name, sysRole.name) &&
                Objects.equals(description, sysRole.description) &&
                Objects.equals(sort, sysRole.sort) &&
                Objects.equals(version, sysRole.version) &&
                Objects.equals(createTime, sysRole.createTime) &&
                Objects.equals(updateTime, sysRole.updateTime) &&
                Objects.equals(createUser, sysRole.createUser) &&
                Objects.equals(updateUser, sysRole.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, pid, name, description, sort, version, createTime, updateTime, createUser, updateUser);
    }
}
