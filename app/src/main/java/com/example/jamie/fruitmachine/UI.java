package com.example.jamie.fruitmachine;

/**
 * Created by jamie on 03/11/2017.
 */

public class UI {

  public static void howMuchMoney() {
    System.out.println("How much money are you putting in?");
  }

  public static void goodLuck() {
    System.out.println("Good luck, £1 a play.\n");
  }

  public static void NaN() {
    System.out.println("That wasn't a number.");
  }

  public static void play() {
    System.out.println("Play the fruit machine? Y/n");
  }

  public static void noMoney() {
    System.out.println("You've run out of money, want to put more in? [q to quit]");
  }

  public static void youWon(int playerFunds, int winnings) {
    System.out.println("You've won £" + winnings + "! You've got £" + playerFunds + " left.");
  }

  public static void noWin(int playerFunds) {
    System.out.println("Nothing this time. You've got £" + playerFunds + " left.");
  }
}
