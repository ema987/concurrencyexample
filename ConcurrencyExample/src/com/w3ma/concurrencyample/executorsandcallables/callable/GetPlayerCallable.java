package com.w3ma.concurrencyample.executorsandcallables.callable;

import com.w3ma.concurrencyample.model.Player;
import com.w3ma.concurrencyample.model.PlayerBalance;
import com.w3ma.concurrencyample.model.PlayerDetails;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by emanuele on 19/08/2016.
 */
public class GetPlayerCallable implements Callable<Player> {

    ExecutorService executor;

    public GetPlayerCallable() {
        executor = Executors.newFixedThreadPool(2);
    }

    @Override
    public Player call() throws Exception {
        System.out.println("Fetching player");
        Future<PlayerBalance> playerBalanceFuture = executor.submit(new GetPlayerBalanceCallable());
        Future<PlayerDetails> playerDetailsFuture = executor.submit(new GetPlayerDetailsCallable());
        System.out.println("GetPlayer waiting");
        PlayerBalance playerBalance = playerBalanceFuture.get();
        System.out.println("Got player balance");
        PlayerDetails playerDetails = playerDetailsFuture.get();
        System.out.println("Got player details");
        Player player = new Player();
        player.setPlayerBalance(playerBalance);
        player.setPlayerDetails(playerDetails);
        return player;
    }
}
