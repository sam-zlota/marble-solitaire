package european;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import org.junit.Test;

/**
 * Verifies that the isGameOver() method in EuropeanMarbleSolitaireModel functions properly.
 */
public class EuropeanSolitaireModelImplTestIsGameOver {

  private EuropeanSolitaireModelImpl msm1;

  private void init() {
    this.msm1 = new EuropeanSolitaireModelImpl();
  }

  @Test
  public void testIsGameOver() {
    this.init();
    assertFalse(this.msm1.isGameOver());
    this.msm1.move(5,3,3,3);
    this.msm1.move(2,3,4,3);
    this.msm1.move(3,1,3,3);
    this.msm1.move(3,4,3,2);
    this.msm1.move(0,3,2,3);
    this.msm1.move(3,6,3,4);
    assertFalse(this.msm1.isGameOver());
    this.msm1.move(5,1,5,3);
    this.msm1.move(5,4,5,2);
    this.msm1.move(1,1,3,1);
    this.msm1.move(3,1,3,3);
    this.msm1.move(3,3,5,3);
    this.msm1.move(6,3,4,3);
    this.msm1.move(1,2,3,2);
    this.msm1.move(2,4,2,2);
    assertFalse(this.msm1.isGameOver());
    this.msm1.move(0,4,2,4);
    this.msm1.move(2,5,2,3);
    this.msm1.move(2,2,2,4);
    this.msm1.move(3,4,1,4);
    this.msm1.move(1,5,1,3);
    this.msm1.move(5,5,3,5);
    assertFalse(this.msm1.isGameOver());
    this.msm1.move(4,2,2,2);
    this.msm1.move(6,2,4,2);
    this.msm1.move(4,3,4,5);
    this.msm1.move(4,1,4,3);
    this.msm1.move(4,6,4,4);
    this.msm1.move(4,3,4,5);
    assertFalse(this.msm1.isGameOver());
    this.msm1.move(4,5,2,5);
    assertFalse(this.msm1.isGameOver());
    this.msm1.move(2,6,2,4);
    assertTrue(this.msm1.isGameOver());
    assertTrue(this.msm1.isGameOver());
  }
}
