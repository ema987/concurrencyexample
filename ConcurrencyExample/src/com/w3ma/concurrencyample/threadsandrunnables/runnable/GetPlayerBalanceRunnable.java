package com.w3ma.concurrencyample.threadsandrunnables.runnable;

import com.w3ma.concurrencyample.model.PlayerBalance;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by emanuele on 08/08/2016.
 */
public class GetPlayerBalanceRunnable implements Runnable {

    private Listener listener;
    private CountDownLatch countDownLatch;

    public GetPlayerBalanceRunnable(CountDownLatch countDownLatch, Listener listener) {
        this.countDownLatch = countDownLatch;
        this.listener = listener;
    }

    @Override
    public void run() {
        try {
            System.out.println("Fetching player balance");
            PlayerBalance playerBalance = new PlayerBalance();
            playerBalance.setBalance(BigDecimal.TEN);
            TimeUnit.SECONDS.sleep(2);
            listener.onResult(playerBalance);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public interface Listener {
        void onResult(PlayerBalance playerBalance);
    }
}
