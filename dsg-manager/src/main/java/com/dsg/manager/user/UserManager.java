package com.dsg.manager.user;

import com.dsg.common.core.dto.dto.system.SysUserDto;
import com.dsg.common.core.entity.system.SystemUser;

/**
 * @author cdw
 * @date 2021/9/3 21:52
 */
public interface UserManager {
    /**
     * 通过用户名获取用户
     *
     * @param userName 用户名
     * @return
     */
    SystemUser findByName(String userName);

    /**
     * 通过用户名获取权限
     *
     * @param userName 用户名
     * @return
     */
    String findUserPermissions(String userName);

    SystemUser registUser(String username, String password);
}
