package com.w3ma.concurrencyample.executorsandcallables;

import com.w3ma.concurrencyample.executorsandcallables.callable.GetPlayerCallable;
import com.w3ma.concurrencyample.model.Player;

import java.util.concurrent.*;

/**
 * Created by emanuele on 19/08/2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Main started");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Player> playerFuture = executor.submit(new GetPlayerCallable());
        try {
            Player player = playerFuture.get();
            System.out.println("Got player " + player.toString());
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Task interrupted", e);
        }
        try {
            System.out.println("Attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.out.println("Tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.out.println("Cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("Shutdown finished");
        }

    }
}
