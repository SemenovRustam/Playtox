package com.semenov;

import com.semenov.Utils.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static final int NUMBER_OF_THREADS = 2;
    public static final int MONEY = 10_000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        Account account1 = createAccount();
        Account account2 = createAccount();
        Account account3 = createAccount();
        Account account4 = createAccount();
        Transaction transaction = new Transaction();

        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            futureList.add(CompletableFuture.runAsync(() -> transaction.transferMoney(account1, account2, Utils.createRandomAmount()), executorService));
            futureList.add(CompletableFuture.runAsync(() -> transaction.transferMoney(account3, account4, Utils.createRandomAmount()), executorService));
        }
        futureList.forEach(CompletableFuture::join);
    }

    private static Account createAccount() {
        Account account = Account.builder()
                .id(String.valueOf(Utils.createRandomId()))
                .money(MONEY)
                .build();
        log.info("Create new account with id {}", account.getId());
        return account;
    }
}
