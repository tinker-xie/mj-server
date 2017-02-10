package com.xie.service.core;

/**
 * @Author xie
 * @Date 17/1/23 下午5:58.
 */
public class Player {
    private static final int NULL_CODE = 100;
    private int[] hand = new int[14];
    private int[] peng = new int[5];
    private int[] gang = new int[5];

    public Player() {
        for (int i = 0; i < hand.length; i++) {
            hand[i] = NULL_CODE;
        }
        for (int i = 0; i < peng.length; i++) {
            peng[i] = NULL_CODE;
        }
        for (int i = 0; i < gang.length; i++) {
            gang[i] = NULL_CODE;
        }
    }

    public void insertHand(int insert) {
        hand[13] = insert;
        sort(hand, 0, hand.length - 1);
    }

    public void insertHand(int[] insert) {
        for (int i = 0; i < insert.length; i++) {
            hand[13 - i] = insert[i];
        }
        sort(hand, 0, hand.length - 1);
    }

    public int canPengOrGang(int in) {
        int result = 0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == in) {
                result++;
            }
        }
        if (result == 2) {
            return 2;
        } else if (result == 3) {
            return 3;
        } else {
            return 0;
        }
    }

    public boolean canHu(int in) {
        boolean result = false;
        for (int i = 0; i < hand.length; i++) {

        }
        return false;
    }

    public void peng(int in) {

    }

    public void gang(int in) {

    }

    public void hu(int in) {

    }

    public int[] getHand() {
        return hand;
    }

    public int getHandNumber() {
        int result = 13;
        while (hand[result] == NULL_CODE) {
            result--;
        }
        return result + 1;
    }

    private static void sort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];

        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > low) sort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        if (end < high) sort(a, end + 1, high);//右边序列。从关键值索引+1到最后一个
    }
}
