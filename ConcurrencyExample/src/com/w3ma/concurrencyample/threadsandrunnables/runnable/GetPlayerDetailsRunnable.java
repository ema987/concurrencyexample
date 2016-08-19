package com.w3ma.concurrencyample.threadsandrunnables.runnable;

import com.w3ma.concurrencyample.model.PlayerDetails;

import java.util.concurrent.CountDownLatch;

/**
 * Created by emanuele on 08/08/2016.
 */
public class GetPlayerDetailsRunnable implements Runnable {

    private Listener listener;
    private CountDownLatch countDownLatch;

    public GetPlayerDetailsRunnable(CountDownLatch countDownLatch, Listener listener) {
        this.countDownLatch = countDownLatch;
        this.listener = listener;
    }

    @Override
    public void run() {
        System.out.println("Fetching player details");
        PlayerDetails playerDetails = new PlayerDetails();
        playerDetails.setFirstName("FirstName");
        playerDetails.setLastName("LastName");
        listener.onResult(playerDetails);
        countDownLatch.countDown();
    }

    public interface Listener {
        void onResult(PlayerDetails playerDetails);
    }
}
