package com.semenov.Utils;

import java.util.concurrent.ThreadLocalRandom;


public class Utils {


    public static int createRandomId() {
        return ThreadLocalRandom.current().nextInt(1000, 9999);
    }

    public static int createRandomAmount() {
        return ThreadLocalRandom.current().nextInt(50, 100);
    }

    public static int getRandomTime() {
        return ThreadLocalRandom.current().nextInt(1000, 2000);
    }

}
