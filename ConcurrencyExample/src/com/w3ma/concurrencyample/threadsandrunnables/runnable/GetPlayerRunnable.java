package com.w3ma.concurrencyample.threadsandrunnables.runnable;

import com.w3ma.concurrencyample.model.Player;

import java.util.concurrent.CountDownLatch;

/**
 * Created by emanuele on 08/08/2016.
 */
public class GetPlayerRunnable implements Runnable {

    private Listener listener;
    private CountDownLatch countDownLatch;
    private Player player;

    public GetPlayerRunnable(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        System.out.println("Fetching player");
        countDownLatch = new CountDownLatch(2);
        player = new Player();
        try {
            new Thread(new GetPlayerDetailsRunnable(countDownLatch, (playerDetails) -> {
                System.out.println("Got player details");
                player.setPlayerDetails(playerDetails);
            })).start();

            new Thread(new GetPlayerBalanceRunnable(countDownLatch, (playerBalance) ->  {
                System.out.println("Got player balance");
                player.setPlayerBalance(playerBalance);
            })).start();

            System.out.println("GetPlayer waiting");
            countDownLatch.await();
            listener.onResult(player);

        } catch (InterruptedException e) {
            System.out.println("GetPlayer interrupted " + e.getMessage());
        }
    }

    public interface Listener {
        void onResult(Player player);
    }
}
