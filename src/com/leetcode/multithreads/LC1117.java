package com.leetcode.multithreads;

import com.leetcode.Helper.PrintUtils;

import java.util.concurrent.Semaphore;

// https://www.cnblogs.com/tqlin/p/11644165.html
public class LC1117 {

    private static class OxygenThread extends Thread {
        private H2O obj;
        private Runnable releaseOxygen;
        private OxygenThread(H2O obj, Runnable releaseOxygen) {
            this.obj = obj;
            this.releaseOxygen = releaseOxygen;
        }

        @Override
        public void run() {
            try {
                this.obj.oxygen(this.releaseOxygen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class HydrogenThread extends Thread {
        private H2O obj;
        private Runnable releaseHydrogen;

        private HydrogenThread(H2O obj, Runnable releaseHydrogen) {
            this.obj = obj;
            this.releaseHydrogen = releaseHydrogen;
        }

        @Override
        public void run() {
            try {
                this.obj.hydrogen(this.releaseHydrogen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class H2O {
        private Semaphore outputHydrogen, outputOxygen;

        public H2O() {
            outputHydrogen = new Semaphore(2, true);
            outputOxygen = new Semaphore(0, true);
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            outputHydrogen.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            outputOxygen.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            outputOxygen.acquire(2);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            outputHydrogen.release(2);
        }
    }


    public static void main(String[] args) {
        // String input = "HOHOHHOOHOHHHHHOHHHOH";
        String input = "OOOHHHHHH";
        H2O h2o = new H2O();
        StringBuffer sb = new StringBuffer();
        Thread threads[] = new Thread[input.length()];
        Runnable releaseOxygen = () -> sb.append('O');
        Runnable releaseHydrogen = () -> sb.append('H');

        int i = 0;
        for(char c : input.toCharArray()) {
            PrintUtils.printString("c:" + c);
            Thread thread = null;
            if (c == 'H') {
                thread = new HydrogenThread(h2o, releaseHydrogen);
            } else if(c == 'O') {
                thread = new OxygenThread(h2o, releaseOxygen);
            }
            thread.start();
            threads[i++] = thread;
        }
        for(Thread thread : threads) {
            try {
                PrintUtils.printString("thread " + thread.getName() + " joins");
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        PrintUtils.printString("buffer: " + sb.toString());
    }
}
