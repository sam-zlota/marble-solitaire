package english;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Verifies that constructors work properply and throw appropriate exceptions for Marble
 * Solitaire Model.
 */

public class MarbleSolitaireModelImplTestConstructors {

  @Test()
  public void testConstructorEvenArmLength() {
    try {
      new MarbleSolitaireModelImpl(4);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("invalid arm length: not odd", e.getMessage());
    }
  }

  @Test()
  public void testConstructorSideLengthTooSmall() {
    try {
      new EuropeanSolitaireModelImpl(-3, 3, 3);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("invalid arm length: too small", e.getMessage());
    }
  }

  @Test()
  public void testConstructorArmLengthTooSmall2() {
    try {
      new MarbleSolitaireModelImpl(1);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("invalid arm length: too small", e.getMessage());
    }
  }

  @Test
  public void testConstructorInvalidEmptyOOB() {
    try {
      new MarbleSolitaireModelImpl(-1,0);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals(  "Empty cell position not on board (-1,0)", e.getMessage());
    }
  }

  @Test()
  public void testConstructorInvalidEmptyInvalidPos() {
    try {
      new MarbleSolitaireModelImpl(3,0,0);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals(  "Empty cell position not on board (0,0)", e.getMessage());
    }
  }

}
