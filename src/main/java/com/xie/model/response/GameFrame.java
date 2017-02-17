package com.xie.model.response;

import com.xie.service.core.Player;

/**
 * @Author xie
 * @Date 17/2/17 下午4:44.
 */
public class GameFrame {

    private int game_current_step = 0;
    private int game_current_action;
    private int game_current_person;
    private int game_next_person;

    private Player player;


    public int getGame_current_step() {
        return game_current_step;
    }

    public void setGame_current_step(int game_current_step) {
        this.game_current_step = game_current_step;
    }

    public int getGame_current_action() {
        return game_current_action;
    }

    public void setGame_current_action(int game_current_action) {
        this.game_current_action = game_current_action;
    }

    public int getGame_current_person() {
        return game_current_person;
    }

    public void setGame_current_person(int game_current_person) {
        this.game_current_person = game_current_person;
    }

    public int getGame_next_person() {
        return game_next_person;
    }

    public void setGame_next_person(int game_next_person) {
        this.game_next_person = game_next_person;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
