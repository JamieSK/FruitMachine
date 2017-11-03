package com.example.jamie.fruitmachine;

/**
 * Created by jamie on 03/11/2017.
 */

public class NotEnoughMoneyException extends Exception {
  private int winnings;

  NotEnoughMoneyException(int winnings) {
    this.winnings = winnings;
  }

  public String getMessage() {
    return "Not enough money in the machine,\nyou've won £" + winnings + ",\nask an attendant for your winnings!";
  }
}
