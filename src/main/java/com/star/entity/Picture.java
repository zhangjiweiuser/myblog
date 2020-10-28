package com.star.entity;

import lombok.Data;

/**
 * 照片墙实体类
 */
@Data
public class Picture {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 图片名称
     */
    private String picturename;
    /**
     * 拍摄时间
     */
    private String picturetime;
    /**
     * 图片地址
     */
    private String pictureaddress;
    /**
     * 图片描述
     */
    private String picturedescription;

}