package org.company.forward.domain.common.shiro.domain;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
public class SysMenu {
    private long menuId;
    private String code;
    private String pcode;
    private String pcodes;
    private String name;
    private String icon;
    private String url;
    private Integer sort;
    private Integer levels;
    private String menuFlag;
    private String description;
    private String status;
    private String newPageFlag;
    private String openFlag;
    private Date createTime;
    private Date updateTime;
    private Long createUser;
    private Long updateUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysMenu sysMenu = (SysMenu) o;
        return menuId == sysMenu.menuId &&
                Objects.equals(code, sysMenu.code) &&
                Objects.equals(pcode, sysMenu.pcode) &&
                Objects.equals(pcodes, sysMenu.pcodes) &&
                Objects.equals(name, sysMenu.name) &&
                Objects.equals(icon, sysMenu.icon) &&
                Objects.equals(url, sysMenu.url) &&
                Objects.equals(sort, sysMenu.sort) &&
                Objects.equals(levels, sysMenu.levels) &&
                Objects.equals(menuFlag, sysMenu.menuFlag) &&
                Objects.equals(description, sysMenu.description) &&
                Objects.equals(status, sysMenu.status) &&
                Objects.equals(newPageFlag, sysMenu.newPageFlag) &&
                Objects.equals(openFlag, sysMenu.openFlag) &&
                Objects.equals(createTime, sysMenu.createTime) &&
                Objects.equals(updateTime, sysMenu.updateTime) &&
                Objects.equals(createUser, sysMenu.createUser) &&
                Objects.equals(updateUser, sysMenu.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, code, pcode, pcodes, name, icon, url, sort, levels, menuFlag, description, status, newPageFlag, openFlag, createTime, updateTime, createUser, updateUser);
    }
}
