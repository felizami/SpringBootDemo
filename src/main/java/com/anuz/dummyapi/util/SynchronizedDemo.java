/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anuz.dummyapi.util;

import org.slf4j.LoggerFactory;

/**
 *
 * @author anuz
 */
public class SynchronizedDemo {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private int count = 0;

    public static int demo() {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        return synchronizedDemo.testThreadOp();
    }

    public synchronized void increment() {
        count++;
    }

    public int testThreadOp() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000; i++) {
//                    count++;
                    increment();
                }
            }

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10000; i++) {
//                    count++;
                    increment();
                }
            }

        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            logger.info("Count:"+count);
            logger.error("Count:"+count);
            logger.debug("count:"+count);
        } catch (InterruptedException ex) {
            logger.error("Interrupt error:" + ex.getMessage());
        }
        return count;

    }
}
