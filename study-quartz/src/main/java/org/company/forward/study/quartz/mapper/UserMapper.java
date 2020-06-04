package org.company.forward.study.quartz.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.company.forward.domain.common.shiro.domain.SysUser;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author wangjian
 * @since 2018-12-07
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 修改用户状态
     */
    int setStatus(@Param("userId") Long userId, @Param("status") String status);

    /**
     * 修改密码
     */
    int changePwd(@Param("userId") Long userId, @Param("pwd") String pwd);

    /**
     * 根据条件查询用户列表
     */
    Page<Map<String, Object>> selectUsers(@Param("page") Page page, @Param("name") String name, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("deptId") Long deptId);

    /**
     * 设置用户的角色
     */
    int setRoles(@Param("userId") Long userId, @Param("roleIds") String roleIds);

    /**
     * 通过账号获取用户
     */
    SysUser getByAccount(@Param("account") String account);

}
