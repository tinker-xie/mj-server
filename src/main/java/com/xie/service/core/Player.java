package com.xie.service.core;

import java.util.*;

/**
 * @Author xie
 * @Date 17/1/23 下午5:58.
 */
public class Player {
    private static final int NULL_CODE = 100;
    private HashMap<PAI, Integer> hand;
    private HashMap<PAI, Integer> peng;
    private HashMap<PAI, Integer> gang;

    public Player() {
        hand = new HashMap<>();
        peng = new HashMap<>();
        gang = new HashMap<>();
    }

    public void insertHand(PAI insert) {
        Integer count = hand.get(insert);
        if (count != null) {
            hand.put(insert, count + 1);
        } else {
            hand.put(insert, 1);
        }

    }

    public void insertHand(PAI[] insert) {
        for (int i = 0; i < insert.length; i++) {
            insertHand(insert[i]);
        }
    }

    public List<Integer> getHand() {
        List<Integer> list = new ArrayList<>();
        Iterator iter = hand.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            PAI pai = (PAI) entry.getKey();
            Integer count = (Integer) entry.getValue();
            if (pai != null && count > 0) {
                for (; count > 0; count--) {
                    list.add(pai.getCode());
                }
            }
        }
        return list;
    }

    public int getHandNumber() {
        int result = 0;
        Iterator iter = hand.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            PAI pai = (PAI) entry.getKey();
            Integer count = (Integer) entry.getValue();
            if (pai != null && count > 0) {
                result += count;
            }
        }
        return result;
    }
}
