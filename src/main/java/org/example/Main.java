package org.example;

import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int connect = 1_001;

        try(var executor = Executors.newVirtualThreadPerTaskExecutor()){
            for (int i = 1; i < connect; i++) {
                System.out.println("Connected : "+i);
                executor.execute(() -> {
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    }

                });

            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Connected : " + (end - connect)+ " ms." );
    }
}