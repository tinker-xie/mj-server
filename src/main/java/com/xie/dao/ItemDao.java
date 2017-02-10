package com.xie.dao;

import com.xie.model.bean.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xie on 16/11/24.
 */

@Component
public class ItemDao extends BaseDao {

    public Item getById(int id) {
        return this.sqlSession.selectOne("itemDao.getById", id);
    }


    public List<Item> getAll() {
        return this.sqlSession.selectList("itemDao.getAll");
    }

    public List<Item> getAllCanShow() {
        return this.sqlSession.selectList("itemDao.getAllCanShow");
    }

    public List<Item> getByCategory(Integer level1, Integer level2) {
        Map map = new HashMap<String, Object>();
        map.put("level1", level1);
        map.put("level2", level2);
        return this.sqlSession.selectList("itemDao.getByCategory", map);
    }

    public List<Item> getByCategory(Integer level1) {
        Map map = new HashMap<String, Object>();
        map.put("level1", level1);
        return this.sqlSession.selectList("itemDao.getByCategory", map);
    }

    public int count(boolean all) {
        return this.sqlSession.selectOne("itemDao.count", all);
    }

    public int insert(Item item) {
        return this.sqlSession.insert("itemDao.insert", item);
    }

    public int update(Item item) {
        return this.sqlSession.update("itemDao.update", item);
    }

    public int delete(Item item) {
        Assert.notNull(item);
        Assert.isTrue(item.getId() > 0);
        return this.sqlSession.delete("itemDao.delete", item.getId());
    }

    public int delete(int id) {
        Assert.isTrue(id > 0);
        return this.sqlSession.delete("itemDao.delete", id);
    }

    public int softDelete(int id) {
        Assert.isTrue(id > 0);
        return this.sqlSession.update("itemDao.softDelete", id);
    }

}