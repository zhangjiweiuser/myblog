package com.star.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 博客实体类
 */
@Data
public class Blog {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 首图
     */
    private String firstPicture;
    /**
     * 文章类型-》原创，转载，翻译等
     */
    private String flag;
    /**
     * 查看人数
     */
    private Integer views;
    /**
     * 评论总数
     */
    private Integer commentCount;
    /**
     * 是否打开赞赏功能
     */
    private boolean appreciation;
    /**
     * 是否允许分享
     */
    private boolean shareStatement;
    /**
     * 是否打开评论功能
     */
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    /**
     * 新增时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 文章类型
     */
    private Long typeId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 博客描述
     */
    private String description;
    private Type type;
    private User user;
    /**
     * 评论
     */
    private List<Comment> comments = new ArrayList<>();

}