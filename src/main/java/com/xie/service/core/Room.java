package com.xie.service.core;

import com.xie.model.response.GameFrame;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

/**
 * @Author xie
 * @Date 17/2/17 下午3:54.
 */
public class Room {
    /**
     * 配置项
     */
    private int game_person_number;
    private int game_win_eggs;


    /**
     * 游戏参数
     */
    private int game_current_step = 0;
    private int game_current_action;
    private int game_current_person;
    private int game_current_pai;
    private int game_next_person;
    private int game_next_action;
    private int game_next_pai;


    private List<Player> players;
    private Queue<Integer> paiQueue;

    public Room(int game_person_number, int game_win_eggs) {
        this.game_person_number = game_person_number;
        this.game_win_eggs = game_win_eggs;

        paiQueue = new ConcurrentLinkedDeque<>();
        players = new ArrayList<>(game_person_number);

        setResult(game_current_step, GameUtils.SYS, Action.分牌.getCode(), GameUtils.NOT_PAI, GameUtils.SYS, Action.分牌.getCode(), GameUtils.NOT_PAI);

        //初始化分牌
        initTest();

        //下一步
        setResult(game_current_step + 1, GameUtils.SYS, Action.分牌.getCode(), GameUtils.NOT_PAI, GameUtils.PLAYER_0, Action.出牌.getCode(), GameUtils.NOT_PAI);
    }

    public static void main(String[] args) {

        Room game = new Room(3, 2);
        game.printCurrent();

        System.out.println("\n");

        game.nextStep(Action.出牌.getCode(), GameUtils.NOT_PAI);
        game.printCurrent();
        System.out.println("\n");
        boolean next = true;
        for (int i = 0; i < 18; i++) {
            next = game.nextStepTest();
            if (!next) {
                break;
            }
            game.printCurrent();
            System.out.println("\n");
        }

    }

    private void initTest() {
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
                int[] first = {0, 0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5};
                Player player = new Player();
                GameUtils.sort(first, 0, first.length - 1);
                player.insertHand(first);
                players.add(player);
            } else if (i == 1) {
                int[] other = {0, 0, 1, 1, 2, 2, 3, 4, 4, 5, 6, 6, 6};
                Player player = new Player();
                GameUtils.sort(other, 0, other.length - 1);
                player.insertHand(other);
                players.add(player);
            } else {
                int[] other = {7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11};
                Player player = new Player();
                GameUtils.sort(other, 0, other.length - 1);
                player.insertHand(other);
                players.add(player);
            }
        }
        int[] remains = Arrays.copyOfRange(arr, (4) * 13 + 1, 55);
        for (int k = 0; k < remains.length; k++) {
            paiQueue.offer(remains[k]);
        }
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
                GameUtils.sort(first, 0, first.length - 1);
                player.insertHand(first);
                players.add(player);
            } else {
                int[] other = Arrays.copyOfRange(arr, (i + 1) * 13 + 1, (i + 2) * 13 + 1);
                Player player = new Player();
                GameUtils.sort(other, 0, other.length - 1);
                player.insertHand(other);
                players.add(player);
            }
        }
        int[] remains = Arrays.copyOfRange(arr, (i) * 13 + 1, GameUtils.TOTAL * 4);
        for (int k = 0; k < remains.length; k++) {
            paiQueue.offer(remains[k]);
        }
    }

    private void setResult(int game_current_step, int game_current_person, int game_current_action, int game_current_pai,
                           int game_next_person, int game_next_action, int game_next_pai) {

        this.game_current_step = game_current_step;
        this.game_current_action = game_current_action;
        this.game_current_person = game_current_person;
        this.game_current_pai = game_current_pai;
        this.game_next_person = game_next_person;
        this.game_next_action = game_next_action;
        this.game_next_pai = game_next_pai;
    }

    public GameFrame getGameFrame(int index) {
        GameFrame gameFrame = new GameFrame();
        BeanUtils.copyProperties(this, gameFrame);
        gameFrame.setPlayer(players.get(index));
        return gameFrame;
    }

    public void nextStep(int action, int pai) {

        if (action != game_next_action) {
            if (game_next_action == Action.判碰杠.getCode()) {
                if (action != Action.杠.getCode() && action != Action.碰.getCode() && action != Action.不碰杠.getCode()) {
                    return;
                }
            } else if (game_next_action == Action.判碰.getCode() && action != Action.碰.getCode() && action != Action.不碰杠.getCode()) {
                return;
            } else if (game_next_action == Action.判杠.getCode() && action != Action.杠.getCode() && action != Action.不碰杠.getCode()) {
                return;
            }
        }
        if (checkPai(pai)) {
            if (action == Action.出牌.getCode()) {
                pai = players.get(game_next_person).getNextTest(2);
                players.get(game_next_person).handThrow(pai);
                //下一步
                int[] result = checkPengOrGang(pai);
                if (result[0] == GameUtils.PENG_GANG_NONE) {
                    setResult(game_current_step + 1, game_next_person, action, pai,
                            getNextPerson(game_next_person), Action.摸牌.getCode(), GameUtils.NOT_PAI);
                } else {
                    setResult(game_current_step + 1, game_next_person, action, pai,
                            result[1], result[0], GameUtils.NOT_PAI);
                }
            } else if (action == Action.摸牌.getCode()) {
                Integer next = paiQueue.poll();
                if (null == next) {
                    setResult(game_current_step + 1, game_next_person, action, GameUtils.NOT_PAI,
                            GameUtils.SYS, Action.流局.getCode(), GameUtils.NOT_PAI);
                } else {
                    players.get(game_next_person).insertHand(next);
                    setResult(game_current_step + 1, game_next_person, action, next,
                            game_next_person, Action.出牌.getCode(), GameUtils.NOT_PAI);
                }
            } else if (action == Action.不碰杠.getCode()) {
                setResult(game_current_step + 1, game_next_person, action, pai,
                        getNextPerson(game_next_person), Action.摸牌.getCode(), GameUtils.NOT_PAI);
            } else if (action == Action.杠.getCode()) {
                players.get(game_next_person).gang(pai);
                setResult(game_current_step + 1, game_next_person, action, pai,
                        game_next_person, Action.摸牌.getCode(), GameUtils.NOT_PAI);
            } else if (action == Action.碰.getCode()) {
                players.get(game_next_person).peng(pai);
                setResult(game_current_step + 1, game_next_person, action, pai,
                        game_next_person, Action.出牌.getCode(), GameUtils.NOT_PAI);
            }

        }
    }

    private boolean checkPai(int pai) {
        if (pai == GameUtils.NOT_PAI) {
            return true;
        } else if (pai >= PAI.START.getCode() && pai <= PAI.END.getCode()) {
            return true;
        }
        return false;
    }

    private int[] checkPengOrGang(int pai) {
        int[] result = new int[2];
        result[0] = GameUtils.PENG_GANG_NONE;
        result[1] = GameUtils.PENG_GANG_NONE_USER;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).canPeng(pai) && players.get(i).canGang(pai)) {
                result[0] = Action.判碰杠.getCode();
                result[1] = i;
            }
            if (players.get(i).canPeng(pai)) {
                result[0] = Action.判碰.getCode();
                result[1] = i;
            }
            if (players.get(i).canGang(pai)) {
                result[0] = Action.判杠.getCode();
                result[1] = i;
            }
        }
        return result;
    }

    private int getNextPerson(int index) {
        int next = index + 1;
        return next % game_person_number;
    }

    public void printCurrent() {
        System.out.print("剩余 - " + paiQueue.size() + "       ====    ");
        List<Integer> list = paiQueue.stream().collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(GameHelper.getName(list.get(i)) + ",");
        }
        System.out.println();

        for (int k = 0; k < game_person_number; k++) {
            List<Integer> temp = players.get(k).getHand();
            System.out.print("玩家 - " + (k + 1) + ":  " + players.get(k).getHandNumber() + "    ====    ");
            for (int i = 0; i < temp.size(); i++) {
                System.out.print(GameHelper.getName(temp.get(i)) + ",");
            }
            System.out.println();
        }

        System.out.print("当前步数" + game_current_step + " | ");
        System.out.print("当前玩家(" + game_current_person + ") " + Action.valueOf(game_current_action) + "(" + GameHelper.getName(game_current_pai) + ")");
        System.out.print("  |  ");

        System.out.print("下一玩家(" + game_next_person + ") " + Action.valueOf(game_next_action) + "(" + GameHelper.getName(game_next_pai) + ")");
        System.out.print("  |  ");
    }

    public boolean nextStepTest() {
        if (game_next_action == Action.摸牌.getCode()) {
            nextStep(Action.摸牌.getCode(), GameUtils.NOT_PAI);
        } else if (game_next_action == Action.出牌.getCode()) {
            nextStep(Action.出牌.getCode(), GameUtils.NOT_PAI);
        } else if (game_next_action == Action.判碰.getCode()) {
            nextStep(Action.碰.getCode(), game_current_pai);
        } else if (game_next_action == Action.判杠.getCode()) {
            nextStep(Action.杠.getCode(), game_current_pai);
        } else if (game_next_action == Action.判碰杠.getCode()) {
            nextStep(Action.杠.getCode(), game_current_pai);
        } else if (game_next_action == Action.流局.getCode()) {
            System.out.println("游戏结束");
            return false;
        }
        return true;
    }

}
