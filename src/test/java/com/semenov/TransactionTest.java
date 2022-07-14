package com.semenov;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

        assertEquals(expectedAmountAcc1, account.getMoney());
        assertEquals(expectedAmountAcc2, account2.getMoney());
    }
}