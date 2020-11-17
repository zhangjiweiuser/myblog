package com.star.dao;

import com.star.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 留言持久层接口
 * @Date: Created in 11:25 2020/4/16
 * @Author: ONESTAR
 * @QQ群: 530311074
 * @URL: https://onestar.newstar.net.cn/
 */
@Mapper
@Repository
public interface MessageDao {

    /**
     * 添加一个评论
     */
    int saveMessage(Message message);

    /**
     * 查询父级评论
     *
     * @param parentId 父级评论id
     */
    List<Message> findByParentIdNull(@Param("parentId") Long parentId);

    /**
     * 查询一级回复
     *
     * @param id 评论id
     */
    List<Message> findByParentIdNotNull(@Param("id") Long id);

    /**
     * 查询二级以及所有子集回复
     *
     * @param childId 子评论id
     */
    List<Message> findByReplayId(@Param("childId") Long childId);

    /**
     * 删除评论
     */
    void deleteById(Long id);

}