package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.model.bean.User;

/**
 * Created by xie on 16/11/24.
 */
public interface UserService {

    User getById(int id);

    PageInfo<User> getAllUsers(int pageNum, int pageSize);

    int insert(User user);

    int update(User user);

    int delete(User user);

    int delete(int id);

    int softDelete(int id);
}
