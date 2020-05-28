package org.company.forward.domain.common.shiro.domain;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class SysDept {
    private long deptId;
    private Long pid;
    private String pids;
    private String simpleName;
    private String fullName;
    private String description;
    private Integer version;
    private Integer sort;
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
        SysDept sysDept = (SysDept) o;
        return deptId == sysDept.deptId &&
                Objects.equals(pid, sysDept.pid) &&
                Objects.equals(pids, sysDept.pids) &&
                Objects.equals(simpleName, sysDept.simpleName) &&
                Objects.equals(fullName, sysDept.fullName) &&
                Objects.equals(description, sysDept.description) &&
                Objects.equals(version, sysDept.version) &&
                Objects.equals(sort, sysDept.sort) &&
                Objects.equals(createTime, sysDept.createTime) &&
                Objects.equals(updateTime, sysDept.updateTime) &&
                Objects.equals(createUser, sysDept.createUser) &&
                Objects.equals(updateUser, sysDept.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, pid, pids, simpleName, fullName, description, version, sort, createTime, updateTime, createUser, updateUser);
    }
}
