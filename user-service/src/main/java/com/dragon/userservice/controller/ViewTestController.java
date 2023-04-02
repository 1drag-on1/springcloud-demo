package com.dragon.userservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    @GetMapping("/testDemo")
    public String testDemo(Model model){

        model.addAttribute("link","http://www.baidu.com");
        model.addAttribute("msg","你好，hello");
        //model中的数据会放被放在请求域中
        return "success";
    }


}
