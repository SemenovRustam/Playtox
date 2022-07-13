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
        validateTransaction(to, money);

        to.depositMoney(money);
        log.info("Account {} deposit money {} $. Total amount {}$", to.getId(), money, to.getMoney());

        from.withdrawalMoney(money);
        log.info("Account {} withdrawal money {} $. Total amount {}$\n", from.getId(), money, from.getMoney());
        try {
            Thread.sleep(Utils.getRandomTime());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    private void validateTransaction(Account to, Integer money) {
        if (to.getMoney() < 0) {
            log.warn("Error! Amount  can`t be less 0!");
            throw new TransactionException("Error! Amount can`t be less 0!");
        }
        if (to.getMoney() - money < 0) {
            log.warn("Error! Insufficient funds to write off");
            throw new TransactionException("Error! Insufficient funds to write off");
        }
    }
}
