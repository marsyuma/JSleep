package com.BintangMarsyumaRakhasunuJSleepJS;

public class ThreadingObject extends Thread {
    public ThreadingObject(String object) {
        super(object);
        this.start();
    }
    @Override
    public void run() {
        System.out.println("Thread " + this.getName() + " is running");
        System.out.println("ThreadId " + Thread.currentThread().getId());
    }
}

