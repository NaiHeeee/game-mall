package com.yuier.gamemall;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Executors;

@SpringBootTest
class GameMallApplicationTests {

    public static void main(String[] args) {
        System.out.println();
    }

    @Test
    void contextLoads() {

        Executors.newCachedThreadPool();
    }


}
