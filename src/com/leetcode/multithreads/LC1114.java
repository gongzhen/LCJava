package com.leetcode.multithreads;

import com.leetcode.Helper.PrintUtils;

import java.util.concurrent.Semaphore;

// https://zhuanlan.zhihu.com/p/81626432
public class LC1114 {
    private static class Foo {

        private Semaphore firstSemaphore;
        private Semaphore secondSemaphore;
        private Semaphore thirdSemaphore;

        public Foo() {
            this.firstSemaphore = new Semaphore(1);
            this.secondSemaphore = new Semaphore(0);
            this.thirdSemaphore = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            firstSemaphore.acquire();
            printFirst.run();
            secondSemaphore.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            secondSemaphore.acquire();
//             printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            thirdSemaphore.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            thirdSemaphore.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    private static class FirstThread extends Thread {
        private Foo foo;
        private Runnable firstRunnable;
        private FirstThread(Foo obj, Runnable runnable) {
            this.foo = obj;
            this.firstRunnable = runnable;
        }

        @Override
        public void run() {
            try {
                this.foo.first(this.firstRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class SecondThread extends Thread {
        private Foo foo;
        private Runnable secondRunnable;
        private SecondThread(Foo obj, Runnable runnable) {
            this.foo = obj;
            this.secondRunnable = runnable;
        }

        @Override
        public void run() {
            try {
                this.foo.second(this.secondRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ThirdThread extends Thread {
        private Foo foo;
        private Runnable thirdRunnable;
        private ThirdThread(Foo obj, Runnable runnable) {
            this.foo = obj;
            this.thirdRunnable = runnable;
        }

        @Override
        public void run() {
            try {
                this.foo.third(this.thirdRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int[] orders = new int[]{3, 2, 1};
        StringBuffer sb = new StringBuffer();
        Foo foo = new Foo();
        Runnable runFrist = () -> sb.append("first");
        Runnable runSecond = () -> sb.append("second");
        Runnable runThird = () -> sb.append("third");
        Thread[] threads = new Thread[3];

        int idx = 0;
        for(int n: orders) {
            Thread thread = null;
            if (n == 1) {
                thread = new FirstThread(foo, runFrist);
            } else if (n == 2) {
                thread = new SecondThread(foo, runSecond);
            } else if (n == 3) {
                thread = new ThirdThread(foo, runThird);
            }
            thread.start();
            threads[idx++] = thread;
        }

        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        PrintUtils.printString("result:" + sb.toString());
    }
}
