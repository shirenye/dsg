package com.dsg.manager.user.impl;

import com.dsg.common.core.constant.DsgConstant;
import com.dsg.common.core.constant.StringConstant;
import com.dsg.common.core.entity.system.Menu;
import com.dsg.common.core.entity.system.SystemUser;
import com.dsg.common.core.entity.system.UserDataPermission;
import com.dsg.common.core.entity.system.UserRole;
import com.dsg.manager.mapper.user.MenuMapper;
import com.dsg.manager.mapper.user.UserMapper;
import com.dsg.manager.mapper.user.UserRoleMapper;
import com.dsg.manager.user.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cdw
 * @date 2021/9/3 21:53
 */
@Service
@RequiredArgsConstructor
public class UserManagerImpl implements UserManager {

    private final UserMapper userMapper;
    private final MenuMapper menuMapper;
    private final UserRoleMapper userRoleMapper;

    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户
     */
    @Override
    public SystemUser findByName(String username) {
        SystemUser user = userMapper.findByName(username);
        return user;
    }

    /**
     * 通过用户名查询用户权限串
     *
     * @param username 用户名
     * @return 权限
     */
    @Override
    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findUserPermissions(username);
        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(StringConstant.COMMA));
    }

    /**
     * 注册用户
     *
     * @param username username
     * @param password password
     * @return SystemUser SystemUser
     */
    @Override
     @Transactional(rollbackFor = Exception.class)
    public SystemUser registUser(String username, String password) {
        SystemUser systemUser = new SystemUser();
        systemUser.setUsername(username);
        systemUser.setPassword(password);
        systemUser.setCreateTime(new Date());
        systemUser.setStatus(SystemUser.STATUS_VALID);
        systemUser.setSex(SystemUser.SEX_UNKNOW);
        systemUser.setAvatar(SystemUser.DEFAULT_AVATAR);
        systemUser.setDescription("注册用户");
        this.userMapper.insert(systemUser);

        UserRole userRole = new UserRole();
        userRole.setUserId(systemUser.getUserId());
        // 注册用户角色 ID
        userRole.setRoleId(DsgConstant.REGISTER_ROLE_ID);
        this.userRoleMapper.insert(userRole);
        return systemUser;
    }
}
