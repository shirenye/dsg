package com.dsg.common.core.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类父类
 *
 * @author cdw
 * @date 2021-03-29
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Integer id;

    /**
     * 创建人
     */
    public Integer createBy;

    /**
     * 创建时间
     */
    public Date createTime;

    /**
     * 更新人
     */
    public Integer updateBy;

    /**
     * 更新时间
     */
    public Date updateTime;

    /**
     * 备注
     */
    public String remark;
}
