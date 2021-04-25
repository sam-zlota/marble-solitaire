package triangle;


import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Verifies that the move method works properly for the TriangleSolitaireModelImpl class.
 */
public class TriangleSolitaireModelImplTestMove {

  private MarbleSolitaireModel tri7;

  private void init() {
    this.tri7 = new TriangleSolitaireModelImpl(7,4 ,2);
  }

  @Test
  public void testMoveLeft() {
    this.init();
    try {
      this.tri7.move(4 ,4,4 ,2);
    } catch (IllegalArgumentException e) {
      Assert.fail("could not make move" + e.getMessage());
    }
  }

  @Test
  public void testMoveRight() {
    this.init();
    try {
      this.tri7.move(4 ,0,4 ,2);
    } catch (IllegalArgumentException e) {
      Assert.fail("could not make move" + e.getMessage());
    }
  }

  @Test
  public void testMoveUpLeft() {
    this.init();
    try {
      this.tri7.move(6 ,2,4 ,2);
    } catch (IllegalArgumentException e) {
      Assert.fail("could not make move" + e.getMessage());
    }
  }

  @Test
  public void testMoveUpRight() {
    this.init();
    try {
      this.tri7.move(6 ,4,4 ,2);
    } catch (IllegalArgumentException e) {
      Assert.fail("could not make move" + e.getMessage());
    }
  }

  @Test
  public void testMoveDownLeft() {
    this.init();
    try {
      this.tri7.move(2 ,2,4 ,2);
    } catch (IllegalArgumentException e) {
      Assert.fail("could not make move" + e.getMessage());
    }
  }

  @Test
  public void testMoveDownRight() {
    this.init();
    try {
      this.tri7.move(2 ,0,4 ,2);
    } catch (IllegalArgumentException e) {
      Assert.fail("could not make move" + e.getMessage());
    }

  }

  @Test
  public void testInvalidMoveFromInvalidOOB() {
    this.init();
    try {
      this.tri7.move(-2 ,0,4 ,2);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: cannot move to or from a position off of board", e.getMessage());
    }
  }

  @Test
  public void testInvalidMoveToInvalidOOB() {
    this.init();
    try {
      this.tri7.move(2 ,0,-4 ,2);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: cannot move to or from a position off of board", e.getMessage());
    }
  }

  @Test
  public void testInvalidMoveFromInvalidPos() {
    this.init();
    try {
      this.tri7.move(0 ,1,4 ,2);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: cannot move to or from a position off of board", e.getMessage());
    }
  }

  @Test
  public void testInvalidMoveToInvalidPos() {
    this.init();
    try {
      this.tri7.move(2 ,0,0 ,1);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: cannot move to or from a position off of board", e.getMessage());
    }
  }

  @Test
  public void testInvalidMoveFromEmpty() {
    this.init();
    try {
      this.tri7.move(4 ,2,4 ,4);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: no marble to move at from slot", e.getMessage());
    }
  }

  @Test
  public void testInvalidMoveToCovered() {
    this.init();
    try {
      this.tri7.move( 0,0,2 ,2);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: slot covered at to slot", e.getMessage());
    }
  }

  @Test
  public void testInvalidMoveTooFarHorizontally() {
    this.init();
    this.tri7.move(4 , 4, 4 ,2);
    try {
      this.tri7.move( 4,1,4 ,4);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: positions not two slots apart", e.getMessage());
    }
  }

  @Test
  public void testInvalidMoveTooCloseHorizontally() {
    this.init();
    try {
      this.tri7.move( 4,1,4 ,2);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: positions not two slots apart", e.getMessage());
    }
  }

  @Test
  public void testInvalidMoveTooFarDiagonally() {
    this.init();
    this.tri7.move(6 ,4,4 ,2);
    try {
      this.tri7.move(3 ,1,6 ,4);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: positions not two slots apart", e.getMessage());
    }
  }


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToItself() {
    this.init();
    this.tri7.move(6 ,4,6 ,4);
  }

  @Test
  public void testInvalidMoveNoPieceInbetween() {
    this.init();
    this.tri7.move(6 ,4,4 ,2);
    try {
      this.tri7.move(4 ,2,6 ,4);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid Move: no marble to jump over", e.getMessage());
    }
  }



}
