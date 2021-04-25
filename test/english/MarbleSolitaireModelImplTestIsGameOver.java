package english;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



/**
 * Verifies that the isGameOver() method in MarbleSolitaireModelImpl functions properly.
 */

public class MarbleSolitaireModelImplTestIsGameOver {

  private MarbleSolitaireModel msm1;

  private void init() {
    this.msm1 = new MarbleSolitaireModelImpl();
  }

  @Test
  public void testIsGameOver() {
    this.init();
    assertFalse(this.msm1.isGameOver());
    this.msm1.move(3,1,3,3);
    this.msm1.move(3,4,3,2);
    this.msm1.move(1,3,3,3);
    this.msm1.move(3,2,3,4);
    this.msm1.move(3,5,3,3);
    this.msm1.move(1,2,3,2);
    assertFalse(this.msm1.isGameOver());
    this.msm1.move(1,4,3,4);
    this.msm1.move(4,2,2,2);
    this.msm1.move(4,4,2,4);
    this.msm1.move(4,3,2,3);
    this.msm1.move(4,0,4,2);
    this.msm1.move(4,6,4,4);
    this.msm1.move(2,0,4,0);
    this.msm1.move(2,6,4,6);
    assertFalse(this.msm1.isGameOver());
    this.msm1.move(5,2,3,2);
    this.msm1.move(5,4,3,4);
    this.msm1.move(6,3,4,3);
    this.msm1.move(2,2,4,2);
    this.msm1.move(2,4,4,4);
    this.msm1.move(4,3,4,1);
    assertFalse(this.msm1.isGameOver());
    this.msm1.move(4,0,4,2);
    assertTrue(this.msm1.isGameOver());
    assertTrue(this.msm1.isGameOver());
  }

}
