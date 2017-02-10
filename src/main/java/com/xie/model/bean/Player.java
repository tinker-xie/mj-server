package com.xie.model.bean;

import java.util.List;

/**
 * Created by xie on 16/8/23.
 */
public class Player {
    private int id;
    private String name;

    private List<PAI> inHand;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
