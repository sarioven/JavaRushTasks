package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    public void run() {
        State state = thread.getState();

        System.out.println(thread.getState());

        while(thread.getState() != Thread.State.TERMINATED) {
            if(!thread.getState().toString().equals(state.toString())) {
                state = thread.getState();
                System.out.println(state);
            }
        }

        System.out.println(thread.getState());
    }
}
