package com.xie.service.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author xie
 * @Date 17/1/23 下午5:22.
 */
public class MjCore {
    private final static int TOTAL = 34;

    private List<Player> players = new ArrayList<>(4);
    private int[] remains;

    public static void main1(String[] args) {
        MjCore mjCore = new MjCore();
        int[] arr = new int[TOTAL * 4];
        for (int i = 0; i < TOTAL; i++) {
            arr[i * 4] = i;
            arr[i * 4 + 1] = i;
            arr[i * 4 + 2] = i;
            arr[i * 4 + 3] = i;
        }
        arr = m3(arr);
        int[] first = Arrays.copyOfRange(arr, 0, 14);
        Player player1 = new Player();
        player1.insertHand(first);
        mjCore.getPlayers().add(player1);

        int[] second = Arrays.copyOfRange(arr, 14, 27);
        Player player2 = new Player();
        player2.insertHand(second);
        mjCore.getPlayers().add(player2);

        int[] third = Arrays.copyOfRange(arr, 27, 40);
        Player player3 = new Player();
        player3.insertHand(third);
        mjCore.getPlayers().add(player3);

        int[] four = Arrays.copyOfRange(arr, 40, 53);
        Player player4 = new Player();
        player4.insertHand(four);
        mjCore.getPlayers().add(player4);

        int[] remains = Arrays.copyOfRange(arr, 40, 136);
        mjCore.setRemains(remains);

        mjCore.printCurrent();
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] m3(int[] in) {
        int[] out = new int[in.length];
        int count = in.length;
        int cbRandCount = 0;// 索引
        int cbPosition = 0;// 位置
        int k = 0;
        do {
            Random rand = new Random();
            int r = count - cbRandCount;
            cbPosition = rand.nextInt(r);
            out[k++] = in[cbPosition];
            cbRandCount++;
            in[cbPosition] = in[r - 1];
        } while (cbRandCount < count);
        return out;
    }

    public void printCurrent() {
        System.out.println("剩余:" + remains.length);
        for (int i = 0; i < remains.length; i++) {
            System.out.print(GameHelper.getName(remains[i]) + ",");
        }
        System.out.println();


        int[] temp = players.get(0).getHand();
        System.out.println("玩家1:" + players.get(0).getHandNumber());
        for (int i = 0; i < temp.length; i++) {
            System.out.print(GameHelper.getName(temp[i]) + ",");
        }
        System.out.println();

        int[] temp2 = players.get(1).getHand();
        System.out.println("玩家2:" + players.get(1).getHandNumber());
        for (int i = 0; i < temp2.length; i++) {
            System.out.print(GameHelper.getName(temp2[i]) + ",");
        }
        System.out.println();

        int[] temp3 = players.get(2).getHand();
        System.out.println("玩家3:" + players.get(2).getHandNumber());
        for (int i = 0; i < temp3.length; i++) {
            System.out.print(GameHelper.getName(temp3[i]) + ",");
        }
        System.out.println();


        int[] temp4 = players.get(3).getHand();
        System.out.println("玩家4:" + players.get(3).getHandNumber());
        for (int i = 0; i < temp4.length; i++) {
            System.out.print(GameHelper.getName(temp4[i]) + ",");
        }
        System.out.println();
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int[] getRemains() {
        return remains;
    }

    public void setRemains(int[] remains) {
        this.remains = remains;
    }
}
