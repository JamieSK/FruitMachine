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
  private ArrayList<Symbol> symbolArray;
  private Integer[] indices;

  FruitMachine(int funds, int reels) {
    this.funds = funds;
    this.symbolArray = generateSymbolArray();
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

  private int payOut(int winnings) throws NotEnoughMoneyException {
    if (funds >= winnings) {
      funds -= winnings;
      return winnings;
    } else {
      throw new NotEnoughMoneyException(winnings);
    }
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

  void printOneLineSlowly() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(500);
    for (Integer i : indices) {
      System.out.print(symbolArray.get(i).getEmoji() + " ");
      TimeUnit.MILLISECONDS.sleep(500);
    }
    System.out.println("");
  }

  void printThreeLines() {
    StringBuilder line1 = new StringBuilder("  ");
    StringBuilder line2 = new StringBuilder("- ");
    StringBuilder line3 = new StringBuilder("  ");

    for (Integer i : indices) {
      int middle = i + symbolArray.size();
      line3.append(symbolArray.get((middle + 1) % symbolArray.size()).getEmoji()).append(" ");
      line1.append(symbolArray.get((middle - 1) % symbolArray.size()).getEmoji()).append(" ");
      line2.append(symbolArray.get(middle % symbolArray.size()).getEmoji()).append(" ");
    }
    System.out.println(line1);
    System.out.println(line2 + "-");
    System.out.println(line3);
  }
}
