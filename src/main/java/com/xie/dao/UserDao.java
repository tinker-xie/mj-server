package com.xie.dao;

import com.xie.model.bean.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by xie on 16/11/24.
 */

@Component
public class UserDao extends BaseDao {

    public User getById(Integer id) {
        return this.sqlSession.selectOne("userDao.getById", id);
    }

    public User getByName(String name) {
        return this.sqlSession.selectOne("userDao.getByName", name);
    }

    public int insert(User user) {
        return this.sqlSession.insert("userDao.insert", user);
    }

    public List<User> getAll() {
        return this.sqlSession.selectList("userDao.getAll");
    }

    public int update(User user) {
        return this.sqlSession.update("userDao.update", user);
    }

    public int delete(int id) {
        return this.sqlSession.delete("userDao.delete", id);
    }

    public int softDelete(int id) {
        return this.sqlSession.update("userDao.softDelete", id);
    }
}