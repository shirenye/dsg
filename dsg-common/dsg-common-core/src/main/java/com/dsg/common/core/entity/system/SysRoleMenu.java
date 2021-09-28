package com.dsg.common.core.entity.system;

import lombok.Data;

/**
 * 角色和菜单关联 sys_role_menu
 *
 * @author cdw
 * @date 2021-03-29
 */
@Data
public class SysRoleMenu
{
    /** 角色ID */
    private Long roleId;

    /** 菜单ID */
    private Long menuId;

}
