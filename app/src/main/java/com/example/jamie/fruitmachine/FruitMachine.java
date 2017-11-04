package com.example.jamie.fruitmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by jamie on 03/11/2017.
 */

class FruitMachine {
  private int funds;
  private Symbol[] reels;
  private ArrayList<Symbol> symbolArray;
  private Integer[] indices;

  FruitMachine(int funds, int reels) {
    this.funds = funds;
    this.reels = new Symbol[reels];
    this.symbolArray = generateSymbolArray();
    spinReels();

    this.indices = new Integer[reels];
  }

  private ArrayList<Symbol> generateSymbolArray() {
    ArrayList<Symbol> result = new ArrayList<>();
    for (Symbol symbol : Symbol.values()) {
      for (int i = 0; i < (64 / symbol.getWinnings()); i++) {
        result.add(symbol);
      }
    }
    Collections.shuffle(result);
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

  int spinIndices() throws NotEnoughMoneyException {
    for (int i = 0; i < indices.length; i++) {
      indices[i] = new Random().nextInt(symbolArray.size());
    }

    if (checkIndicesWin()) {
      return payOut(symbolArray.get(indices[0]).getWinnings());
    } else {
      return 0;
    }
  }

  private boolean checkIndicesWin() {
    for (Integer i : indices) {
      if (symbolArray.get(i) != symbolArray.get(indices[0])) {
        return false;
      }
    }
    return true;
  }

  void printThreeLines() {
    String line1 = "  ";
    String line2 = "- ";
    String line3 = "  ";

    for (Integer i : indices) {
      int middle = i + symbolArray.size();
      line3 += symbolArray.get((middle + 1) % symbolArray.size()).getEmoji() + " ";
      line1 += symbolArray.get((middle - 1) % symbolArray.size()).getEmoji() + " ";
      line2 += symbolArray.get(middle % symbolArray.size()).getEmoji() + " ";
    }
    System.out.println(line1);
    System.out.println(line2 + "-");
    System.out.println(line3);
  }
}
