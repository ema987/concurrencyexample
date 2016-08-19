package com.w3ma.concurrencyample.threadsandrunnables;

import com.w3ma.concurrencyample.model.Player;
import com.w3ma.concurrencyample.threadsandrunnables.runnable.GetPlayerRunnable;

/**
 * Created by emanuele on 08/08/2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Main started");
        new Thread(new GetPlayerRunnable((Player player) -> System.out.println("Got player " + player.toString()))).start();
        System.out.println("Main finished");
    }
}
