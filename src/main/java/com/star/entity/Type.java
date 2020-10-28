package com.star.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章分类实体类
 */
@Data
public class Type {

    private Long id;
    private String name;

    private List<Blog> blogs = new ArrayList<>();

}