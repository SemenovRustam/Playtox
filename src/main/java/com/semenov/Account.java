package com.semenov;

import com.semenov.exception.TransactionException;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private String id;
    private Integer money;

    public void depositMoney(int deposit) {
        money += deposit;
    }

    public void withdrawalMoney(int withdrawal) {
        if (money - withdrawal < 0) {
            throw new TransactionException("Insufficiently money!");
        }
        money -= withdrawal;
    }
}
