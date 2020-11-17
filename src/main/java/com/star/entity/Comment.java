package com.star.entity;

import com.star.queryvo.DetailedBlog;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 评论实体类
 */
@Data
public class Comment {

    private Long id;
    private String nickname;
    private String email;
    private String content;

    /**
     * 头像
     */
    private String avatar;
    private Date createTime;

    private Long blogId;
    private Long parentCommentId;
    private String parentNickname;

    /**
     * 回复评论
     */
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;
    private boolean adminComment;

    private DetailedBlog blog;
}