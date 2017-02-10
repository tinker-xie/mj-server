package com.xie.controller.api;

import com.xie.model.bean.User;
import com.xie.model.response.BaseResponse;
import com.xie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xie on 16/11/24.
 */
@Controller()
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getUser(@PathVariable("id") int id) {
        return BaseResponse.ok(userService.getById(id));
    }


    @RequestMapping(value = "users", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getAllUser(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return BaseResponse.ok(userService.getAllUsers(pageNum, pageSize));
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BaseResponse postUser(@ModelAttribute User user) {
        userService.insert(user);
        return BaseResponse.ok();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public BaseResponse putUser(@PathVariable int id, @ModelAttribute User user) {
        int result = userService.update(user);
        if (result > 0) {
            return BaseResponse.ok();
        } else {
            return BaseResponse.fail();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public BaseResponse deleteUser(@PathVariable int id) {
        int result = userService.softDelete(id);
        if (result > 0) {
            return BaseResponse.ok();
        } else {
            return BaseResponse.fail();
        }
    }
}
