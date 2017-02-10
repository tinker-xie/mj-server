package com.xie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author xie
 * @Date 17/1/19 下午4:37.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/logoutSuccess")
    public String logoutSuccess() {
        return "logoutSuccess";
    }
}
