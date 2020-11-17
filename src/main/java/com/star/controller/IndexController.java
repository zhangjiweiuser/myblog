package com.star.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.star.entity.Comment;
import com.star.queryvo.DetailedBlog;
import com.star.queryvo.FirstPageBlog;
import com.star.service.BlogService;
import com.star.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


/**
 * @Description: 首页控制器
 */
@Slf4j
@Controller
public class IndexController {


    @Autowired
    private BlogService blogService;


    @Autowired
    private CommentService commentService;

    /**
     * 分页查询博客列表
     */
    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, RedirectAttributes attributes) {
        PageHelper.startPage(pageNum, 10);
        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();


        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        log.info("首页数据为:{}", JSONObject.toJSONString(pageInfo, true));
        model.addAttribute("pageInfo", pageInfo);


        return "index";
    }

    /**
     * 搜索博客
     */
    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                         @RequestParam String query) {
        PageHelper.startPage(pageNum, 20);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }

    /**
     * 跳转博客详情页面
     */
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
        // 打开评论功能才加载评论，否则不加载
        if (detailedBlog.isCommentabled()) {
            List<Comment> comments = commentService.listCommentByBlogId(id);
            log.info("博客id为{}的评论:{}", id, JSONObject.toJSONString(comments, true));
            model.addAttribute("comments", comments);
        }
        log.info("博客id为{}的详情:{}", id, JSONObject.toJSONString(detailedBlog, true));

        model.addAttribute("blog", detailedBlog);
        return "blog";
    }

    /**
     * 博客信息
     */
    @GetMapping("/footer/blogmessage")
    public String blogMessage(Model model) {
        int blogTotal = blogService.getBlogTotal();
        int blogViewTotal = blogService.getBlogViewTotal();
        int blogCommentTotal = blogService.getBlogCommentTotal();
        int blogMessageTotal = blogService.getBlogMessageTotal();

        model.addAttribute("blogTotal", blogTotal);
        model.addAttribute("blogViewTotal", blogViewTotal);
        model.addAttribute("blogCommentTotal", blogCommentTotal);
        model.addAttribute("blogMessageTotal", blogMessageTotal);
        return "footer :: blogMessage";
    }
}