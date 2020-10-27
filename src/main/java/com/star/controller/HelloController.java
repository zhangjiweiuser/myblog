package com.star.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {


    /**
     * hello测试界面
     *
     * @param model
     * @return
     */
    @GetMapping("/hello")
    public String index(Model model) {

        return "hello";
    }

}