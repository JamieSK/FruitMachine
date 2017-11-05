//package com.example.jamie.fruitmachine;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by jamie on 03/11/2017.
// */
//
//public class FruitMachineTest {
//  private FruitMachine spy;
//
//  @Before
//  public void before() {
//    FruitMachine fm = new FruitMachine(200, 3);
//    spy = Mockito.spy(fm);
//  }
//
//  @Test
//  public void spinToWin() throws NotEnoughMoneyException {
//    for (Symbol symbol : Symbol.values()) {
//      Mockito.when(spy.getRandomSymbol()).thenReturn(symbol);
//      assertEquals(symbol.getWinnings(), spy.spin());
//    }
//  }
//
//  @Test
//  public void checkWin() throws NotEnoughMoneyException {
//    Symbol[] win = new Symbol[] {Symbol.LEMON, Symbol.LEMON, Symbol.LEMON};
//    Symbol[] lose = new Symbol[] {Symbol.STRAWBERRY, Symbol.LEMON, Symbol.LEMON};
//
//    Mockito.when(spy.spinReels()).thenReturn(win);
//    spy.spin();
//    assertEquals(true, spy.checkWin());
//
//    Mockito.when(spy.spinReels()).thenReturn(lose);
//    spy.spin();
//    assertEquals(false, spy.checkWin());
//  }
//
//  @Test
//  public void bigWinThrowsException() {
//    Mockito.when(spy.getRandomSymbol()).thenReturn(Symbol.WATERMELON);
//
//    boolean thrown = false;
//    try {
//      while (true) {
//        spy.spin();
//      }
//    } catch (NotEnoughMoneyException e) {
//      System.out.println(e.getMessage());
//      thrown = true;
//    }
//    assertTrue(thrown);
//  }
//}
