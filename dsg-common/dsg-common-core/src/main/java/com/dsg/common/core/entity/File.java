package com.dsg.common.core.entity;

import lombok.Data;

/**
 * 文件实体类
 *
 * @author cdw
 * @date 2021/11/7 16:05
 */
@Data
public class File {

    /** 文件名 */
    private String fileName;

    /** 文件原名 */
    private String fileOldName;

    /** 文件路径 */
    private String fileUrl;

    /** 文件大小 */
    private Integer fileSize;


}
