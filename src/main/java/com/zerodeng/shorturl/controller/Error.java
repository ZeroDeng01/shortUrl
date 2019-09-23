package com.zerodeng.shorturl.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName:Error
 * @Description:TODO
 * @Author:ZeroDeng
 * @Date:2019/9/23 16:28
 * @Version:1.0
 **/
@Controller
@RequestMapping("/error")
public class Error implements ErrorController {
    @Override
    public String getErrorPath() {
        return "index";
    }

    @RequestMapping
    public String error() {
        return getErrorPath();
    }
}
