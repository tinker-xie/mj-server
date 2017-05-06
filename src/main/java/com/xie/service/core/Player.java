package com.xie.service.core;

import java.util.*;

/**
 * @Author xie
 * @Date 17/1/23 下午5:58.
 */
public class Player {
    private HashMap<Integer, Integer> hand;
    private HashMap<Integer, Integer> peng;
    private HashMap<Integer, Integer> gang;
    private List<Integer> throwed;

    public Player() {
        hand = new HashMap<>();
        peng = new HashMap<>();
        gang = new HashMap<>();
        throwed = new ArrayList<>();
    }

    public void insertHand(Integer insert) {
        Integer count = hand.get(insert);
        if (count != null) {
            hand.put(insert, count + 1);
        } else {
            hand.put(insert, 1);
        }
    }

    public void insertHand(int insert) {
        Integer count = hand.get(insert);
        if (count != null) {
            hand.put(insert, count + 1);
        } else {
            hand.put(insert, 1);
        }
    }

    public void insertHand(Integer[] insert) {
        for (int i = 0; i < insert.length; i++) {
            insertHand(insert[i]);
        }
    }

    public void insertHand(int[] insert) {
        for (int i = 0; i < insert.length; i++) {
            insertHand(insert[i]);
        }
    }

    public List<Integer> getHand() {
        List<Integer> list = new ArrayList<>();
        Iterator iter = hand.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer pai = (Integer) entry.getKey();
            Integer count = (Integer) entry.getValue();
            if (pai != null && count > 0) {
                for (; count > 0; count--) {
                    list.add(pai);
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public int getHandNumber() {
        int result = 0;
        Iterator iter = hand.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer pai = (Integer) entry.getKey();
            Integer count = (Integer) entry.getValue();
            if (pai != null && count > 0) {
                result += count;
            }
        }
        return result;
    }

    public boolean handThrow(int pai) {
        Integer count = hand.get(pai);
        if (count != null) {
            int remain = count - 1;
            hand.put(pai, remain);
            throwed.add(pai);
            if (remain <= 0) {
                hand.remove(pai);
            }
            return true;

        }
        return false;
    }

    public boolean peng(int pai) {
        Integer count = hand.get(pai);
        if (count != null && count > 1) {
            int remain = count - 2;
            hand.put(pai, remain);
            peng.put(pai, 3);
            if (remain <= 0) {
                hand.remove(pai);
            }
            return true;
        }
        return false;
    }

    public boolean gang(int pai) {
        Integer count = hand.get(pai);
        if (count != null && count > 2) {
            int remain = count - 3;
            hand.put(pai, remain);
            gang.put(pai, 4);
            if (remain <= 0) {
                hand.remove(pai);
            }
            return true;
        }
        return false;
    }

    public boolean anGang() {

        Iterator iter = hand.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer pai = (Integer) entry.getKey();
            Integer count = (Integer) entry.getValue();
            if (pai != null && count == 4) {
                int remain = count - 3;
                hand.put(pai, remain);
                gang.put(pai, 4);
                if (remain <= 0) {
                    hand.remove(pai);
                }
                return true;
            }
        }
        return false;
    }


    public boolean canPeng(int pai) {
        Integer count = hand.get(pai);
        if (count != null && count > 1) {
            return true;
        }
        return false;
    }

    public boolean canGang(int pai) {
        Integer count = hand.get(pai);
        if (count != null && count == 3) {
            return true;
        }
        return false;
    }

    public boolean canAnGang() {
        Iterator iter = hand.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer pai = (Integer) entry.getKey();
            Integer count = (Integer) entry.getValue();
            if (pai != null && count == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean canHu() {
        int[] src = new int[PAI.END.getCode() + 1];
        Iterator iter = hand.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer pai = (Integer) entry.getKey();
            Integer count = (Integer) entry.getValue();
            if (pai != null && count > 0) {
                src[pai] = count;
            }
        }
        return GameUtils.analysing(src);
    }


    public int getNextTest(int size) {
        int result = GameUtils.NOT_PAI;
        Iterator iter = hand.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer pai = (Integer) entry.getKey();
            Integer count = (Integer) entry.getValue();
            if (pai != null && count == size) {
                result = pai;
                break;
            }
        }
        if (result != GameUtils.NOT_PAI) {
            return result;
        } else {
            return getNextTest(size - 1);
        }
    }
}
