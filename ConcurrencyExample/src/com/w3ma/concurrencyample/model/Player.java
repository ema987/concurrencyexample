package com.w3ma.concurrencyample.model;

/**
 * Created by emanuele on 19/08/2016.
 */
public class Player {

    PlayerDetails playerDetails;
    PlayerBalance playerBalance;

    public PlayerDetails getPlayerDetails() {
        return playerDetails;
    }

    public void setPlayerDetails(PlayerDetails playerDetails) {
        this.playerDetails = playerDetails;
    }

    public PlayerBalance getPlayerBalance() {
        return playerBalance;
    }

    public void setPlayerBalance(PlayerBalance playerBalance) {
        this.playerBalance = playerBalance;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerDetails=" + playerDetails +
                ", playerBalance=" + playerBalance +
                '}';
    }
}
