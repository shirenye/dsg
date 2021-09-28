package com.dsg.common.core.dto.dto.system;

import com.dsg.common.core.entity.system.SysMenu;
import com.dsg.common.core.entity.system.SysUser;
import lombok.Data;

import java.util.List;

/**
 * 用户表dto
 *
 * @author cdw
 * @date 2021-03-29
 */
@Data
public class SysUserDto extends SysUser {

    /**
     * 用户权限
     */
    private List<SysMenu> menus;


}
