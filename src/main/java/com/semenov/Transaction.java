package com.semenov;

import com.semenov.Utils.Utils;
import com.semenov.exception.TransactionException;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class Transaction {
    private Account to;
    private Account from;

    public void transferMoney(Account to, Account from, Integer money) {
        validateTransaction(from, money);

        depositMoney(to, money);
        log.info("Account {} deposit money {} $. Total amount {}$", to.getId(), money, to.getMoney());

        withdrawalMoney(from, money);
        log.info("Account {} withdrawal money {} $. Total amount {}$\n", from.getId(), money, from.getMoney());
        try {
            Thread.sleep(Utils.getRandomTime());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    private void depositMoney(Account to, int deposit) {
        Integer balance = to.getMoney();
        balance += deposit;
        to.setMoney(balance);
    }

    private void withdrawalMoney(Account from, int withdrawal) {
        Integer balance = from.getMoney();
        balance -= withdrawal;
        from.setMoney(balance);
    }

    private void validateTransaction(Account from, Integer money) {
        if (from.getMoney() - money < 0) {
            log.warn("Error! Insufficient funds to write off");
            throw new TransactionException("Insufficiently money!");
        }
    }
}
