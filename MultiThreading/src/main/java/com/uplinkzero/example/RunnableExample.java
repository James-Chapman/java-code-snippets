/**
 * Created by jchapman on 10/12/2014.
 */
package com.uplinkzero.example;

public class RunnableExample implements Runnable {

    private Thread thread;
    private String threadName;

    /**
     * Default constructor
     */
    RunnableExample() {}

    /**
     * Override constructor
     * @param threadName
     */
    RunnableExample(String threadName) {
        this.threadName = threadName;
    }

    /**
     * What the thread does when it runs
     */
    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    /**
     * Start the thread
     */
    public void start() {
        System.out.println("Starting " + threadName );
        if (this.thread == null) {
            this.thread = new Thread(this, threadName);
            this.thread.start ();
        }
    }

    /**
     * Is the thread alive
     * @return true for alive, false for not alive
     */
    public boolean threadIsAlive() {
        return this.thread.isAlive();
    }
}
