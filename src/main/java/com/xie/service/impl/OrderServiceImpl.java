package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.dao.OrderDao;
import com.xie.model.bean.Order;
import com.xie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @Author xie
 * @Date 17/1/23 上午10:36.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order getById(int id) {
        return orderDao.getById(id);
    }

    @Override
    public PageInfo<Order> getAllByUid(int uid, int pageNum, int pageSize) {
        PageInfo<Order> page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> orderDao.getAllByUid(uid));
        return page;
    }

    @Override
    public PageInfo<Order> getAll(int pageNum, int pageSize) {
        PageInfo<Order> page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> orderDao.getAll());
        return page;
    }

    @Override
    public int insert(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public int update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public int delete(Order order) {
        Assert.notNull(order);
        return orderDao.delete(order.getId());
    }

    @Override
    public int delete(int id) {
        return orderDao.delete(id);
    }

    @Override
    public int softDelete(int id) {
        return orderDao.softDelete(id);
    }

    @Override
    public int countByUid(int uid) {
        return orderDao.countByUid(uid);
    }
}
