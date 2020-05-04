package org.company.forward.domain.common.shiro.domain;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
public class SysNotice {
    private long noticeId;
    private String title;
    private String content;
    private Date createTime;
    private Long createUser;
    private Date updateTime;
    private Long updateUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysNotice sysNotice = (SysNotice) o;
        return noticeId == sysNotice.noticeId &&
                Objects.equals(title, sysNotice.title) &&
                Objects.equals(content, sysNotice.content) &&
                Objects.equals(createTime, sysNotice.createTime) &&
                Objects.equals(createUser, sysNotice.createUser) &&
                Objects.equals(updateTime, sysNotice.updateTime) &&
                Objects.equals(updateUser, sysNotice.updateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noticeId, title, content, createTime, createUser, updateTime, updateUser);
    }
}
