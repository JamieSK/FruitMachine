package com.example.jamie.fruitmachine;

/**
 * Created by jamie on 03/11/2017.
 */

public enum Symbol {
  LEMON(1, "🍋"),
  CHERRIES(2, "🍒"),
  CUCUMBER(3, "🥒"),
  CHILI(4, "🌶"),
  STRAWBERRY(5, "🍓"),
  PEAR(6, "🍐"),
  GRAPES(7, "🍇"),
  BANANA(8, "🍌"),
  KIWI(9, "🥝"),
  SWEETCORN(10, "🌽"),
  TOMATO(11, "🍅"),
  AUBERGINE(12, "🍆"),
  AVOCADO(13, "🥑️"),
  APPLE(14, "🍏"),
  ORANGE(15, "🍊"),
  WATERMELON(16, "🍉");

  private int winnings;
  private String emoji;

  Symbol(int winnings, String emoji) {
    this.winnings = winnings;
    this.emoji = emoji;
  }

  public int getWinnings() {
    return winnings;
  }

  public String getEmoji() {
    return emoji;
  }

  public static Symbol getSymbolFromWinnings(int winnings) {
    for (Symbol symbol : Symbol.values()) {
      if (symbol.getWinnings() == winnings) {
        return symbol;
      }
    }
    return null;
  }
}
