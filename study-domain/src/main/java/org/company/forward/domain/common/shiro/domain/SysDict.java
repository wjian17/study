package org.company.forward.domain.common.shiro.domain;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
public class SysDict {
    private long dictId;
    private Long pid;
    private String name;
    private String code;
    private String description;
    private Integer sort;
    private Date createTime;
    private Date updateTime;
    private Long createUser;
    private Long updateUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysDict sysDict = (SysDict) o;
        return dictId == sysDict.dictId &&
                Objects.equals(pid, sysDict.pid) &&
                Objects.equals(name, sysDict.name) &&
                Objects.equals(code, sysDict.code) &&
                Objects.equals(description, sysDict.description) &&
                Objects.equals(sort, sysDict.sort) &&
                Objects.equals(createTime, sysDict.createTime) &&
                Objects.equals(updateTime, sysDict.updateTime) &&
                Objects.equals(createUser, sysDict.createUser) &&
                Objects.equals(updateUser, sysDict.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dictId, pid, name, code, description, sort, createTime, updateTime, createUser, updateUser);
    }
}
