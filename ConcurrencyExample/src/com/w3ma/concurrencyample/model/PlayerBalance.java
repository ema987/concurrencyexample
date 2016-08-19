package com.w3ma.concurrencyample.model;

import java.math.BigDecimal;

/**
 * Created by emanuele on 08/08/2016.
 */
public class PlayerBalance {

    BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "PlayerBalance{" +
                "balance=" + balance +
                '}';
    }
}
