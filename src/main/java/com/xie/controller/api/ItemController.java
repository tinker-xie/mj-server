package com.xie.controller.api;

import com.xie.model.bean.Item;
import com.xie.model.response.BaseResponse;
import com.xie.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xie on 16/11/24.
 */
@Controller
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getAll(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return BaseResponse.ok(itemService.getAll(pageNum, pageSize));
    }

    @RequestMapping(value = "/getByCategory", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse getByCategory(@RequestParam("level1") Integer level1, @RequestParam("level2") Integer level2, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return BaseResponse.ok(itemService.getByCategory(level1, level2, pageNum, pageSize));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse get(@PathVariable("id") int id) {
        return BaseResponse.ok(itemService.getById(id));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    BaseResponse list(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return BaseResponse.ok(itemService.getAllCanShow(pageNum, pageNum));
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse post(@ModelAttribute Item item) {
        int result = itemService.insert(item);
        if (result > 0) {
            return BaseResponse.ok();
        } else {
            return BaseResponse.fail();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse put(@PathVariable int id, @ModelAttribute Item item) {
        int result = itemService.update(item);
        if (result > 0) {
            return BaseResponse.ok();
        } else {
            return BaseResponse.fail();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public BaseResponse delete(@PathVariable int id) {
        int result = itemService.softDelete(id);
        if (result > 0) {
            return BaseResponse.ok();
        } else {
            return BaseResponse.fail();
        }

    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse count(@RequestParam(value = "all", defaultValue = "false") boolean all) {
        return BaseResponse.ok(itemService.count(all));
    }
}
