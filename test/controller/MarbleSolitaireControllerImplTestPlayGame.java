package controller;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import java.io.StringReader;
import org.junit.Assert;
import org.junit.Test;

/**
 * To test the functionality of the Marble Solitaire Controller.
 */
public class MarbleSolitaireControllerImplTestPlayGame {

  private String simulate(String input) {
    MarbleSolitaireModel m = new MarbleSolitaireModelImpl();
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(new StringReader(input),
        gameLog);
    c.playGame(m);
    return gameLog.toString();
  }

  //"6 4 4 4 q"
  @Test
  public void testSingleValidMove() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Enter a move: \n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n", simulate("6 4 4 4 q"));
  }

  //"6\n4\n4\n4\nq"
  @Test
  public void testSingleValidMoveMultipleLines() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Enter a move: \n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n", simulate("6\n4\n4\n4\nq"));
  }

  //"6 4 4 4 3 4 5 4 q"
  @Test
  public void testTwoValidMoves() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Enter a move: \n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O _ O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "Enter a move: \n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O _ O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 30\n", simulate("6 4 4 4 3 4 5 4 q"));


  }

  //"6 4 4 4 3 4 5 4 4 2 4 4 4 5 4 3 1 4 3 4 4 7 4 5"
  @Test
  public void testGameOver() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Enter a move: \n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O _ O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "Enter a move: \n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O _ O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 29\n"
        + "Enter a move: \n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O _ O O O\n"
        + "O _ O _ _ O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 28\n"
        + "Enter a move: \n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O _ O _ _ O O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 27\n"
        + "Enter a move: \n"
        + "Game over!\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "O _ O _ O _ _\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 26\n", simulate( "6 4 4 4 3 4 5 4 4 2 4 4 4 5 4 3 1 4 3 4 4 7 4 5"));
  }

  //"6 4 4 3 q"
  @Test
  public void testSingleInvalidMove() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "Invalid move. Play again. (6, 4) ---> (4, 3) slot covered at to slot\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", simulate("6 4 4 3 q"));
  }

  //"6 4 4 4 6 4 4 4 q"
  @Test
  public void testValidInvalidMoves() {

    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Enter a move: \n"
        + "Invalid move. Play again. (6, 4) ---> (4, 4) no marble to move at from slot\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n", simulate("6 4 4 4 6 4 4 4 q"));
  }

  //"6 4 4 3 6 4 4 4 q"
  @Test
  public void testInvalidValidMoves() {

    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "Invalid move. Play again. (6, 4) ---> (4, 3) slot covered at to slot\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Enter a move: \n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n", simulate("6 4 4 3 6 4 4 4 q"));
  }


  //"q"
  //"Q"
  //"1 2 Q 4"
  //"q 1 2 4"
  //"1 2 4 Q"
  @Test
  public void testQuit() {
    String quit =    "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n";
    assertEquals(quit, simulate("q"));
    assertEquals(quit, simulate("Q"));
    assertEquals(quit, simulate("1 2 Q 4"));
    assertEquals(quit, simulate("q 1 2 4"));
    assertEquals(quit, simulate("1 2 4 Q"));
  }

  //"! q"
  @Test
  public void testInvalidEntryNonInteger() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "\"!\" is invalid. Re-enter value.\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", simulate("! q"));
  }

  //"6! q"
  @Test
  public void testInvalidEntryNonInteger2() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "\"6!\" is invalid. Re-enter value.\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", simulate("6! q"));
  }

  //"6 ! q"
  @Test
  public void testInvalidEntryNonInteger3() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "\"!\" is invalid. Re-enter value.\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", simulate("6 ! q"));
  }

  //"0 q"
  @Test
  public void testInvalidEntryZero() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "\"0\" is invalid. Re-enter value.\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", simulate("0 q"));
  }

  //"-2 q"
  @Test
  public void testInvalidEntryNegativeInteger() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "\"-2\" is invalid. Re-enter value.\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", simulate("-2 q"));
  }

  //"6 -2 q"
  @Test
  public void testInvalidEntryNegativeInteger2() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Enter a move: \n"
        + "\"-2\" is invalid. Re-enter value.\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n", simulate("6 -2 q"));
  }

  //////////////////////////////////////////////
  //++++++++++++++++++++++++++++++++++++++++++//
  //++++++++++++++++EXCEPTIONS++++++++++++++++//
  //++++++++++++++++++++++++++++++++++++++++++//
  //////////////////////////////////////////////

  @Test
  public void testNullModel() {

    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(new StringReader(""),
        gameLog);
    try {
      c.playGame(null);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException iae) {
      assertEquals(iae.getMessage(), "Model cannot be null");
    }
  }

  @Test
  public void testNullReadableConstructor() {
    try {
      new MarbleSolitaireControllerImpl(null, new StringBuilder());
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Readable and Appendable cannot be null", iae.getMessage());
    }
  }

  @Test
  public void testNullAppendableConstructor() {
    try {
      new MarbleSolitaireControllerImpl(new StringReader(" 1 q"), null);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException iae) {
      assertEquals("Readable and Appendable cannot be null", iae.getMessage());
    }
  }

  @Test
  public void testEmptyReadable() {
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(new StringReader(""),
        gameLog);
    try {
      c.playGame(new MarbleSolitaireModelImpl());
      Assert.fail("did not throw exception");
    } catch (IllegalStateException ise) {
      assertEquals("Readable ran out of input", ise.getMessage());
    }

  }

  @Test
  public void testOutOfInputReadable() {
    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(new StringReader(" ! w 2 1"),
        gameLog);
    try {
      c.playGame(new MarbleSolitaireModelImpl());
      Assert.fail("did not throw exception");
    } catch (IllegalStateException ise) {
      assertEquals("Readable ran out of input", ise.getMessage());
    }

  }

  @Test
  public void testClosedReadable() {
    StringBuilder gameLog = new StringBuilder();
    StringReader input = new StringReader("123 45 q");
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(input,
        gameLog);
    input.close();
    try {
      c.playGame(new MarbleSolitaireModelImpl());
      Assert.fail("did not throw exception");
    } catch (IllegalStateException ise) {
      assertEquals("Readable ran out of input", ise.getMessage());
    }
  }

  @Test
  public void testFailingAppendable() {

    StringBuilder gameLog = new StringBuilder();
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(new StringReader(" ! w 2 1 q"),
        new FailingAppendable());
    try {
      c.playGame(new MarbleSolitaireModelImpl());
      Assert.fail("did not throw exception");
    } catch (IllegalStateException ise) {
      assertEquals("Cannot write to Appendable", ise.getMessage());
    }

  }



}
