package com.dsg.manager.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dsg.common.core.entity.system.Menu;

import java.util.List;

/**
 * @author MrBird
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 获取用户权限集
     *
     * @param username 用户名
     * @return 权限集合
     */
    List<Menu> findUserPermissions(String username);
}
