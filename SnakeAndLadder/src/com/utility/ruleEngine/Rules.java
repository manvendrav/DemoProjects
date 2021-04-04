package com.utility.ruleEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.utility.pojo.Player;

public class Rules {

    private final Map<Integer, Integer> snakeFromAndTo = new HashMap<>();
    private final Map<Integer, Integer> ladderFromAndTo = new HashMap<>();

    {
        snakeFromAndTo.put(27, 5);
        snakeFromAndTo.put(40, 3);
        snakeFromAndTo.put(43, 18);
        snakeFromAndTo.put(54, 31);
        snakeFromAndTo.put(66, 45);
        snakeFromAndTo.put(76, 58);
        snakeFromAndTo.put(89, 53);
        snakeFromAndTo.put(99, 41);
        ladderFromAndTo.put(4, 25);
        ladderFromAndTo.put(13, 46);
        ladderFromAndTo.put(33, 49);
        ladderFromAndTo.put(42, 63);
        ladderFromAndTo.put(50, 69);
        ladderFromAndTo.put(62, 81);
        ladderFromAndTo.put(74, 92);

    }

    private int rollTheDice() {
        Random ran = new Random();
        return ran.nextInt(6) + 1;
    }

    public void playerRollTheDice(Player player) {
        int outcome = rollTheDice();
        if (player.getPoints() == 0 && outcome == 6) {
            System.out.println(player.getName() + " dice came out to be " + outcome);
            int updatedpoints = player.getPoints() + outcome;
            if (snakeFromAndTo.containsKey(updatedpoints)) {
                player.setPoints(snakeFromAndTo.get(updatedpoints));
                System.out.println("Ouch, snake has gotch ya!!!");

            } else if (ladderFromAndTo.containsKey(updatedpoints)) {
                player.setPoints(ladderFromAndTo.get(updatedpoints));
                System.out.println("Woah, rise through the ladder !!!");

            }

            else if (player.getPoints() + outcome <= 100) {
                player.setPoints(player.getPoints() + outcome);

            }

            if (6 == outcome) {
                rollAgain(player);
            }
            if (100 == player.getPoints()) {
                System.out.println(player.getName() + " wins");
            }
        }
        else {
            System.out.println("You need a 6 to start the game");
        }
    }

    public void rollAgain(Player player) {
        System.out.println(player.getName() + " is rolling the dice again");
        playerRollTheDice(player);

    }

}
