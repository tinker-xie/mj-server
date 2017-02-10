package com.xie.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xie
 * @Date 17/1/19 下午4:55.
 */
public class BaseDao {

    @Autowired
    protected SqlSession sqlSession;

}
