package com.w3ma.concurrencyample.executorsandcallables.callable;

import com.w3ma.concurrencyample.model.PlayerDetails;

import java.util.concurrent.Callable;

/**
 * Created by emanuele on 19/08/2016.
 */
public class GetPlayerDetailsCallable implements Callable<PlayerDetails> {

    @Override
    public PlayerDetails call() throws Exception {
        System.out.println("Fetching player details");
        PlayerDetails playerDetails = new PlayerDetails();
        playerDetails.setFirstName("FirstName");
        playerDetails.setLastName("LastName");
        return playerDetails;
    }
}
