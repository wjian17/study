package org.company.forward.domain.common.shiro.domain;

import lombok.Data;

import java.util.Objects;

@Data
public class SysRelation {
    private long relationId;
    private Long menuId;
    private Long roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRelation that = (SysRelation) o;
        return relationId == that.relationId &&
                Objects.equals(menuId, that.menuId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationId, menuId, roleId);
    }
}
