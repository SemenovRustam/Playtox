package com.semenov;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {

    @Spy
    private Transaction transaction;

    @Test
    public void transferMoney() {
        Integer expectedAmountAcc1 = 10100;
        Integer expectedAmountAcc2 = 9900;

        Account account = Account.builder()
                .id("1")
                .money(10_000)
                .build();

        Account account2 = Account.builder()
                .id("2")
                .money(10_000)
                .build();

        transaction.transferMoney(account, account2, 100);

        Integer actualAmountAcc1 = account.getMoney();
        Integer actualAmountAcc2 = account2.getMoney();

        assertEquals(expectedAmountAcc1, actualAmountAcc1);
        assertEquals(expectedAmountAcc2, actualAmountAcc2);
    }
}