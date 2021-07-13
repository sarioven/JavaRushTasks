package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hippodrome {
    public List<Horse> getHorses() {
        return horses;
    }

    private List<Horse> horses;

    static Hippodrome game;

    Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(
                new ArrayList<>(Arrays.asList(
                        new Horse("0", 3, 0),
                        new Horse("1", 3, 0),
                        new Horse("2", 3, 0))
                )
        );

        game.run();

        game.printWinner();
    }

    void run() {
        for(int i=0; i < 100; i++) {
            move();
            print();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    void move() {
        for(Horse horse : horses)
            horse.move();
    }

    void print() {
        for(Horse horse : horses)
            horse.print();

        for(int i=0; i< 10; i++)
            System.out.println();
    }

    public Horse getWinner() {
        Horse winner = null;

        for(Horse horse : horses) {
            if(winner == null) {
                winner = horse;
                continue;
            }

            if(winner.getDistance() < horse.getDistance())
                winner = horse;
        }

        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
