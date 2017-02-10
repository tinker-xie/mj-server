package com.xie.controller.api;

import com.xie.model.bean.Order;
import com.xie.model.response.BaseResponse;
import com.xie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xie on 16/11/24.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getAll(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return BaseResponse.ok(orderService.getAll(pageNum, pageSize));
    }

    @RequestMapping(value = "/getByUid", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getByCategory(@RequestParam("uid") Integer uid, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return BaseResponse.ok(orderService.getAllByUid(uid, pageNum, pageSize));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse get(@PathVariable("id") int id) {
        return BaseResponse.ok(orderService.getById(id));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse list(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return BaseResponse.ok(orderService.getAll(pageNum, pageNum));
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse post(@ModelAttribute Order item) {
        int result = orderService.insert(item);
        if (result > 0) {
            return BaseResponse.ok();
        } else {
            return BaseResponse.fail();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse put(@PathVariable int id, @ModelAttribute Order item) {
        int result = orderService.update(item);
        if (result > 0) {
            return BaseResponse.ok();
        } else {
            return BaseResponse.fail();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public BaseResponse delete(@PathVariable int id) {
        int result = orderService.softDelete(id);
        if (result > 0) {
            return BaseResponse.ok();
        } else {
            return BaseResponse.fail();
        }

    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse count(@RequestParam(value = "uid", required = true) Integer uid) {
        return BaseResponse.ok(orderService.countByUid(uid));
    }
}
