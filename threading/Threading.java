package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threading {

    public static class asyncHello implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println("Асинхронный привет!");
                Thread.sleep(5000);
                System.out.println("Асинхронный пока!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new asyncHello());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println("Работает основная программа");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
