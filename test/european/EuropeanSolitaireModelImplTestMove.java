package european;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Verifies that the move method works properly for the EuropeanMarbleSolitaireModelImpl class.
 */
public class EuropeanSolitaireModelImplTestMove {
  private MarbleSolitaireModel msm1;
  private MarbleSolitaireModel msm2;

  private void init() {
    this.msm1 = new EuropeanSolitaireModelImpl();
    this.msm2 = new EuropeanSolitaireModelImpl(3,4,6);
  }

  @Test
  public void testMoveLeft() {
    this.init();
    int initScore = msm1.getScore();
    //from starting default board armLength = 3 and empty slot at (3,3)
    //moves piece to two positions to the right of center to center
    msm1.move(3,5,3,3);
    assertEquals(initScore - 1, msm1.getScore());

  }

  @Test
  public void testMoveRight() {
    this.init();
    int initScore = msm1.getScore();
    //from starting default board armLength = 3 and empty slot at (3,3)
    //moves piece to two positions to the right of center to center
    msm1.move(3,1,3,3);
    assertEquals(initScore - 1, msm1.getScore());

  }

  @Test
  public void testMoveUp() {
    this.init();
    int initScore = msm1.getScore();
    //from starting default board armLength = 3 and empty slot at (3,3)
    //moves piece to two positions to the right of center to center
    msm1.move(5,3,3,3);
    assertEquals(initScore - 1, msm1.getScore());

  }

  @Test
  public void testMoveDown() {
    this.init();
    int initScore = msm1.getScore();
    //from starting default board armLength = 3 and empty slot at (3,3)
    //moves piece to two positions to the right of center to center
    msm1.move(1,3,3,3);
    assertEquals(initScore - 1, msm1.getScore());

  }

  //========================
  //
  //EXCEPTIONS
  //
  //===========================


  //Out of Bounds Exceptions
  @Test()
  public void testInvalidMoveFromOOB() {
    this.init();
    try {
      msm1.move(-1,0,0,0);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: cannot move to or from a position off of board", e.getMessage());
    }
  }

  @Test()
  public void testInvalidMoveToOOB() {
    this.init();
    try {
      msm1.move(0,0,-1,0);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: cannot move to or from a position off of board", e.getMessage());
    }
  }

  //Invalid board positons Excpetions not OOB, but still invalid because off board
  @Test()
  public void testInvalidMoveFromInvalidPos() {
    this.init();
    try {
      msm1.move(0,0,4,3);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: cannot move to or from a position off of board", e.getMessage());
    }
  }

  @Test()
  public void testInvalidMoveToInvalidPos() {
    this.init();
    try {
      msm1.move(3,4,6,6);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: cannot move to or from a position off of board", e.getMessage());
    }
  }

  //Moving from an empty positon
  @Test()
  public void testInvalidMoveFromEmpty() {
    this.init();
    try {
      msm1.move(3,3,3,5);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: no marble to move at from slot", e.getMessage());
    }
  }

  //moving to a covered position
  @Test()
  public void testInvalidMoveToCovered() {
    this.init();
    try {
      msm1.move(3,4,3,6);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: slot covered at to slot", e.getMessage());
    }
  }

  //moving to position more than 2 slots apart horizontally
  @Test()
  public void testInvalidMoveTooFarHorizontally() {
    this.init();
    try {
      msm1.move(3,6,3,3);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: positions not two slots apart", e.getMessage());
    }
  }

  //moving to position more than 2 slots apart vertically
  @Test()
  public void testInvalidMoveTooFarVertically() {
    this.init();
    try {
      msm1.move(0,3,3,3);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: positions not two slots apart", e.getMessage());
    }
  }

  //moving to position less than 2 slots apart horizontally
  @Test()
  public void testInvalidMoveTooCloseHorizontally() {
    this.init();
    try {
      msm1.move(3,4,3,3);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: positions not two slots apart", e.getMessage());
    }
  }

  //moving to position less than 2 slots apart vertically
  @Test()
  public void testInvalidMoveTooCloseVertically() {
    this.init();
    try {
      msm1.move(2,3,3,3);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: positions not two slots apart", e.getMessage());
    }
  }

  //moving piece to itself( multiple excpetions could be thrown)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToItself() {
    this.init();
    msm1.move(3,3,3,3);
  }

  //no piece in between
  @Test()
  public void testInvalidMoveNoPieceInbetween() {
    this.init();
    msm1.move(3,5,3,3);
    try {
      msm1.move(3,3,3,5);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: no marble to jump over", e.getMessage());
    }
  }

  //diagonal
  @Test()
  public void testInvalidMoveDiagonal() {
    this.init();
    try {
      msm2.move(2,4,4,6);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: cannot make diagonal move", e.getMessage());
    }
  }

  //diagonal
  @Test()
  public void testInvalidMoveDiagonal2() {
    this.init();
    try {
      msm1.move(1,2,3,3);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: cannot make diagonal move", e.getMessage());
    }
  }


}

