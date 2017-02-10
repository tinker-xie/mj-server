package com.xie.service.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author xie
 * @Date 17/2/10 下午3:57.
 */
public class GameDispatch {
    /**
     * 配置项
     */
    private int game_person_number;
    private int game_win_eggs;


    /**
     * 游戏参数
     */
    private int game_current_step;
    private int game_current_action;
    private int game_current_person;
    private int game_next_person;


    private List<Player> players;
    private int[] remains;

    public GameDispatch(int game_person_number, int game_win_eggs) {
        this.game_person_number = game_person_number;
        this.game_win_eggs = game_win_eggs;

        players = new ArrayList<>(game_person_number);
        init();
    }

    private void init() {
        int[] arr = new int[GameUtils.TOTAL * 4];
        for (int i = 0; i < GameUtils.TOTAL; i++) {
            arr[i * 4] = i;
            arr[i * 4 + 1] = i;
            arr[i * 4 + 2] = i;
            arr[i * 4 + 3] = i;
        }
        arr = GameUtils.wash(arr);
        int i = 0;
        for (i = 0; i < game_person_number; i++) {
            if (i == 0) {
                int[] first = Arrays.copyOfRange(arr, 0, 14);
                Player player = new Player();
                player.insertHand(first);
                players.add(player);
            } else {
                int[] other = Arrays.copyOfRange(arr, (i + 1) * 13 + 1, (i + 2) * 13 + 1);
                Player player = new Player();
                player.insertHand(other);
                players.add(player);
            }
        }
        remains = Arrays.copyOfRange(arr, (i) * 13 + 1, GameUtils.TOTAL * 4);
    }


    public void printCurrent() {
        System.out.println("剩余:" + remains.length);
        for (int i = 0; i < remains.length; i++) {
            System.out.print(GameHelper.getName(remains[i]) + ",");
        }
        System.out.println();

        for (int k = 0; k < game_person_number; k++) {
            int[] temp = players.get(k).getHand();
            System.out.println("玩家 -  " + (k + 1) + " :" + players.get(k).getHandNumber());
            for (int i = 0; i < temp.length; i++) {
                System.out.print(GameHelper.getName(temp[i]) + ",");
            }
            System.out.println();
        }
    }


}
