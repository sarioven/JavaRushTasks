package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{
    public MyThread() {
        setOptions();
    }

    public MyThread(Runnable target) {
        super(target);
        setOptions();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setOptions();
    }

    public MyThread(String name) {
        super(name);
        setOptions();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setOptions();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setOptions();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setOptions();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setOptions();
    }

    private static volatile AtomicInteger priority = new AtomicInteger(1);

    private void setOptions() {
        if(priority.get() > Thread.MAX_PRIORITY)
            priority.set(1);

        if(getThreadGroup() != null) {
            setPriority(Math.min(getThreadGroup().getMaxPriority(), priority.get()));
        }
        else {
            setPriority(priority.get());
        }

        priority.getAndIncrement();
    }
}
