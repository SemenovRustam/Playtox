package com.semenov;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    private Account account;

    @Test
    public void depositMoneyTest() {
        Integer expectedMoney = 10100;
        int deposit = 100;

        when(account.getMoney()).thenReturn(10100);
        account.depositMoney(deposit);

        assertEquals(expectedMoney, account.getMoney());
    }

    @Test
    public void withdrawalMoney() {
        Integer expectedMoney = 9900;
        int withdrawal = 100;

        when(account.getMoney()).thenReturn(9900);
        account.withdrawalMoney(withdrawal);

        assertEquals(expectedMoney, account.getMoney());
    }
}