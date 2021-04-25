package triangle;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import org.junit.Assert;
import org.junit.Test;



/**
 * Verifies that constructors work properply and throw appropriate exceptions for Triangle Marble
 * Solitaire Model.
 */
public class TriangleSolitaireModelImplTestConstructors {

  @Test()
  public void testConstructorSideLengthTooSmall() {
    try {
      new TriangleSolitaireModelImpl(-3, 3, 3);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid dimensions: non-positive", e.getMessage());
    }
  }

  @Test()
  public void testConstructorSideLengthTooSmall2() {
    try {
      new TriangleSolitaireModelImpl(0);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid dimensions: non-positive", e.getMessage());
    }
  }

  @Test
  public void testConstructorInvalidEmptyOOB() {
    try {
      new TriangleSolitaireModelImpl(-1,0);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals(  "Empty cell position not on board (-1,0)", e.getMessage());
    }
  }

  @Test()
  public void testConstructorInvalidEmptyInvalidPos() {
    try {
      new TriangleSolitaireModelImpl(3,0,10);
      Assert.fail("did not throw exception");
    } catch (IllegalArgumentException e) {
      assertEquals(  "Empty cell position not on board (0,10)", e.getMessage());
    }
  }
}