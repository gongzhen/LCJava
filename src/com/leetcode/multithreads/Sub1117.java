package com.leetcode.multithreads;

// https://www.cnblogs.com/tqlin/p/11644165.html
public class Sub1117 {
    public static void main(String[] args) throws InterruptedException {
        //测试用例字符串
        String test = "HOHOHHOOHOHHHHHOHHHOH";

        //生成结果字符串
        StringBuffer result = new StringBuffer();

        //注意：创建的Runnable任务，无法启动线程，必须依托其他类或线程启动
        //创建生成氧气任务
        Runnable releaseHydrogen = () -> result.append("H");

        //创建生成氧气任务
        Runnable releaseOxygen = () -> result.append("O");

        //保存线程数组
        Thread threads[] = new Thread[test.length()];

        H2O h2o = new H2O();
        for (int i = 0; i < test.length(); ++i) {
            Thread thread = null;
            //根据获得的字符调用相应的氧气或氢气线程
            if (test.charAt(i) == 'O') {
                thread = new OGenerator(h2o, releaseOxygen);
            } else if (test.charAt(i) == 'H') {
                thread = new HGenerator(h2o, releaseHydrogen);
            }
            //开始线程
            thread.start();
            //保存到线程数组
            threads[i] = thread;
        }

        //等侍所有线程执行完
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        //输出结果串
        System.out.println(result.toString());
    }
}

//氢气生成线程
class HGenerator extends Thread {
    H2O h2o;
    Runnable releaseHydrogen;

    public HGenerator(H2O h2o, Runnable releaseHydrogen) {
        this.h2o = h2o;
        this.releaseHydrogen = releaseHydrogen;
    }

    @Override
    public void run() {
        try {
            h2o.hydrogen(releaseHydrogen);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//氧气生成线程
class OGenerator extends Thread {
    H2O h2o;
    Runnable releaseOxygen;

    public OGenerator(H2O h2o, Runnable releaseOxygen) {
        this.h2o = h2o;
        this.releaseOxygen = releaseOxygen;
    }

    @Override
    public void run() {
        try {
            h2o.oxygen(releaseOxygen);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class H2O {
    public H2O() {
    }

    int h = 0;

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (h == 2) {
            this.wait();
        }
        releaseHydrogen.run();
        ++h;
        this.notify();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (h < 2) {
            this.wait();
        }
        releaseOxygen.run();
        h = 0;
        this.notify();
    }
}
