package org.company.forward.domain.common.shiro.domain;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class SysUser {
    private long userId;
    private String avatar;
    private String account;
    private String password;
    private String salt;
    private String name;
    private Date birthday;
    private String sex;
    private String email;
    private String phone;
    private String roleId;
    private Long deptId;
    private String status;
    private Date createTime;
    private Long createUser;
    private Date updateTime;
    private Long updateUser;
    private Integer version;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysUser sysUser = (SysUser) o;
        return userId == sysUser.userId &&
                Objects.equals(avatar, sysUser.avatar) &&
                Objects.equals(account, sysUser.account) &&
                Objects.equals(password, sysUser.password) &&
                Objects.equals(salt, sysUser.salt) &&
                Objects.equals(name, sysUser.name) &&
                Objects.equals(birthday, sysUser.birthday) &&
                Objects.equals(sex, sysUser.sex) &&
                Objects.equals(email, sysUser.email) &&
                Objects.equals(phone, sysUser.phone) &&
                Objects.equals(roleId, sysUser.roleId) &&
                Objects.equals(deptId, sysUser.deptId) &&
                Objects.equals(status, sysUser.status) &&
                Objects.equals(createTime, sysUser.createTime) &&
                Objects.equals(createUser, sysUser.createUser) &&
                Objects.equals(updateTime, sysUser.updateTime) &&
                Objects.equals(updateUser, sysUser.updateUser) &&
                Objects.equals(version, sysUser.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, avatar, account, password, salt, name, birthday, sex, email, phone, roleId, deptId, status, createTime, createUser, updateTime, updateUser, version);
    }
}
