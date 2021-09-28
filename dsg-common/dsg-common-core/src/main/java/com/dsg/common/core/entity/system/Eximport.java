package com.dsg.common.core.entity.system;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 导入导出测试，Eximport = export + import
 *
 * @author MrBird
 */
@Data
@TableName("t_eximport")
public class Eximport {

    /**
     * 字段1
     */
    private String field1;

    /**
     * 字段2
     */
    private Integer field2;

    /**
     * 字段3
     */
    private String field3;

    /**
     * 创建时间
     */
    private Date createTime;

}
