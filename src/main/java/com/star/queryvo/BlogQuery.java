package com.star.queryvo;

import com.star.entity.Type;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 显示数据实体类
 */
@Data
public class BlogQuery {

    private Long id;
    private String title;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;
}