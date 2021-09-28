package com.dsg.common.core.entity.system;


import com.dsg.common.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 系统访问记录表 sys_logininfor
 *
 * @author cdw
 * @date 2021-03-29
 */
public class SysLogininfor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
     private Long infoId;

    /** 用户账号 */
     private String userName;

    /** 状态 0成功 1失败 */
     private String status;

    /** 地址 */
     private String ipaddr;

    /** 描述 */
     private String msg;

    /** 访问时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     private Date accessTime;


}
