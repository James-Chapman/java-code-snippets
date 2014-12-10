/**
 * Created by jchapman on 10/12/2014.
 */
package com.uplinkzero.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

public class MultiThreadingExample {

    private AtomicBoolean threadInterrupted = new AtomicBoolean();
    private List<RunnableExample> runnableList = new ArrayList<RunnableExample>();
    private Lock listLock;

    /**
     * Default constructor
     */
    public MultiThreadingExample() {
        this.threadInterrupted.set(false);
    }

    /**
     * Main entry point for class
     * @throws InterruptedException
     */
    public void main() throws InterruptedException {

        for (int i = 10; i > 0; i--) {
            String strI = Integer.toString(i);
            createRunnableStartThread(strI);
            Thread.sleep(3);
        }
    }

    /**
     * Create a runnable example object and add it to the list
     * @param strI
     */
    private void createRunnableStartThread(String strI) {
        RunnableExample runnableExample = new RunnableExample("Thread-" + strI);
        runnableExample.start();
        this.runnableList.add(runnableExample);
    }

    /**
     * Get thread list
     * @return runnableExampleList
     */
    public List<RunnableExample> getRunnableList() {
        return runnableList;
    }

}
