package com.xie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xie on 17/1/7.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String index() {

        return "index";
    }
}
