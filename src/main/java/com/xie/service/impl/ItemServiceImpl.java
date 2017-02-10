package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.dao.ItemDao;
import com.xie.model.bean.Item;
import com.xie.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by xie on 16/11/24.
 */
@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemDao itemDao;

    @Override
    public Item getById(int id) {
        return itemDao.getById(id);
    }

    @Override
    public PageInfo<Item> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Item> page = new PageInfo<Item>(itemDao.getAll());
        return page;
    }

    @Override
    public PageInfo<Item> getAllCanShow(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Item> page = new PageInfo<Item>(itemDao.getAllCanShow());
        return page;
    }

    @Override
    public PageInfo<Item> getByCategory(Integer level1, Integer level2, int pageNum, int pageSize) {
        PageInfo<Item> page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> itemDao.getByCategory(level1, level2));
        return page;
    }

    @Override
    public PageInfo<Item> getByCategory(Integer level1, int pageNum, int pageSize) {
        PageInfo<Item> page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> itemDao.getByCategory(level1, null));
        return page;
    }

    @Override
    public int count(boolean all) {
        return itemDao.count(all);
    }

    @Override
    public int insert(Item item) {
        return itemDao.insert(item);
    }

    @Override
    public int update(Item item) {
        return itemDao.update(item);
    }

    @Override
    public int delete(Item item) {
        Assert.notNull(item);
        Assert.isTrue(item.getId() > 0);
        return itemDao.delete(item.getId());
    }

    @Override
    public int delete(int id) {
        Assert.isTrue(id > 0);
        return itemDao.delete(id);
    }

    @Override
    public int softDelete(int id) {
        Assert.isTrue(id > 0);
        return itemDao.softDelete(id);
    }
}
