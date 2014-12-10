/**
 * Created by jchapman on 10/12/2014.
 */
package com.uplinkzero.example;

import org.junit.Test;

import java.util.List;

public class MultiThreadingExampleTests {

    // Really a functional test more than anything else and to show the code running.
    @Test
    public void testMultiThreadingExampleMain_should_succeed() throws InterruptedException {

        MultiThreadingExample threadingExample = new MultiThreadingExample();
        threadingExample.main();

        List<RunnableExample> threadList = threadingExample.getRunnableList();

        Thread.sleep(1000);
        for (RunnableExample runner:threadList) {
            assert threadList.size() == 10;
        }
        boolean allDone = false;
        int listSize = threadList.size();
        int deadThreads = 0;

        while (deadThreads != listSize) {
            int dead = 0;
            for (RunnableExample runner : threadList) {
                if (!runner.threadIsAlive()) {
                    dead++;
                }
            }
            deadThreads = dead;
        }
    }
}
