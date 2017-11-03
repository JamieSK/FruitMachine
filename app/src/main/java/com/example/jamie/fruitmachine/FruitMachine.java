package com.example.jamie.fruitmachine;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by jamie on 03/11/2017.
 */

class FruitMachine {
  private int funds;
  private Symbol[] reels;
  private ArrayList<Symbol> symbolArray;

  FruitMachine(int funds, int reels) {
    this.funds = funds;
    this.reels = new Symbol[reels];
    this.symbolArray = generateSymbolArray();
    spinReels();
  }

  ArrayList<Symbol> generateSymbolArray() {
    ArrayList<Symbol> result = new ArrayList<>();
    for (Symbol symbol : Symbol.values()) {
      for (int i = 0; i < (64 / symbol.getWinnings()); i++) {
        result.add(symbol);
      }
    }
    return result;
  }

  Symbol getRandomSymbol() {
    int randomNumber = new Random().nextInt(symbolArray.size());
    return symbolArray.get(randomNumber);
  }

  Symbol[] spinReels() {
    Symbol[] newArray = reels;
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = getRandomSymbol();
    }
    return newArray;
  }

  boolean checkWin() {
    for (Symbol reel : reels) {
      if (reel != reels[0]) {
        return false;
      }
    }
    return true;
  }

  private int payOut(int winnings) throws NotEnoughMoneyException {
    if (funds >= winnings) {
      funds -= winnings;
      return winnings;
    } else {
      throw new NotEnoughMoneyException(winnings);
    }
  }

  int spin() throws NotEnoughMoneyException {
    reels = spinReels();
    if (checkWin()) {
      return payOut(reels[0].getWinnings());
    } else {
      return 0;
    }
  }

  void slowPrintReels() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(500);
    for (Symbol reel : reels) {
      System.out.print(reel.getEmoji() + " ");
      TimeUnit.MILLISECONDS.sleep(500);
    }
    System.out.println("");
  }
}
