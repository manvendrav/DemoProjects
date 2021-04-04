/**
 * 
 */
package com.utility.game;

import java.util.Scanner;

import com.utility.pojo.Player;
import com.utility.ruleEngine.Rules;

/**
 * @author mave0216
 *
 */
public class SnakeAndLadder {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SnakeAndLadder sn = new SnakeAndLadder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of players...");
        Player playerOne = new Player("Shubham");
        Player playerTwo = new Player("Bitti");
        Player playerThree = new Player("Monu");
        Player playerFour = new Player("Rupal");
        while (!(playerOne.getPoints() == 100) && !(playerTwo.getPoints() == 100) && !(playerThree.getPoints() == 100)
                && !(playerFour.getPoints() == 100)) {
            sn.playerChance(playerOne);
            sn.playerChance(playerTwo);
            sn.playerChance(playerThree);
            sn.playerChance(playerFour);
        }

    }

    public void playerChance(Player player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please " + player.getName() + " press enter to roll the dice...");
        sc.nextLine();

        Rules rules = new Rules();
        rules.playerRollTheDice(player);
        System.out.println("Points of " + player.getName() + " are " + player.getPoints());
    }

}
