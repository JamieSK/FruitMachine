package com.example.jamie.fruitmachine;

import java.util.Scanner;

/**
 * Created by jamie on 03/11/2017.
 */

public class FruitMachineRunner {
  private static FruitMachine fm = new FruitMachine(200, 3);

  public static void main(String[] args) throws InterruptedException {
    Scanner sc = new Scanner(System.in);

    moneyInAndPlay(sc);
  }

  private static void moneyInAndPlay(Scanner sc) throws InterruptedException {
    UI.howMuchMoney();
    try {
      int playerFunds = Integer.parseInt(sc.nextLine());
      UI.goodLuck();

      while (true) {
        playerFunds = checkFundsAndPlay(sc, playerFunds);
      }

    } catch (NumberFormatException e) {
      UI.NaN();
      System.exit(0);
    }
  }

  private static int checkFundsAndPlay(Scanner sc, int playerFunds) throws InterruptedException {
    if (playerFunds > 0) {
      UI.play();
      String input = sc.nextLine();

      playerFunds = yesNoInput(input, playerFunds);
    } else {
      UI.noMoney();
      try {
        playerFunds += Integer.parseInt(sc.nextLine());
        UI.goodLuck();
      } catch (NumberFormatException e) {
        UI.NaN();
        System.exit(0);
      }
    }
    return playerFunds;
  }

  private static int yesNoInput(String input, int playerFunds) throws InterruptedException {
    if (input.equals("n")) {
      System.exit(0);
    } else {
      playerFunds -= 1;
      try {
        int winnings = fm.spinIndices();
        fm.printThreeLines();

        winningCheck(playerFunds, winnings);

      } catch (NotEnoughMoneyException e) {
        System.out.println(e.getMessage());
        System.exit(0);
      }
    }
    return playerFunds;
  }

  private static void winningCheck(int playerFunds, int winnings) {
    if (winnings > 0) {
      playerFunds += winnings;
      UI.youWon(playerFunds, winnings);
    } else {
      UI.noWin(playerFunds);
    }
  }
}
