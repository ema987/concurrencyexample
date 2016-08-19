package com.w3ma.concurrencyample.executorsandcallables.callable;

import com.w3ma.concurrencyample.model.PlayerBalance;

import java.math.BigDecimal;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by emanuele on 19/08/2016.
 */
public class GetPlayerBalanceCallable implements Callable<PlayerBalance> {

    @Override
    public PlayerBalance call() throws Exception {
        System.out.println("Fetching player balance");
        PlayerBalance playerBalance = new PlayerBalance();
        playerBalance.setBalance(BigDecimal.TEN);
        TimeUnit.SECONDS.sleep(2);
        return playerBalance;
    }
}
