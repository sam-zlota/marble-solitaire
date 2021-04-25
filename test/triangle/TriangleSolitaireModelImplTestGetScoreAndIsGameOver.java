package triangle;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import org.junit.Test;

/**
 * Verifies that game score for a MarbleSolitaireModel is properly calculated.
 */
public class TriangleSolitaireModelImplTestGetScoreAndIsGameOver {

  private MarbleSolitaireModel tri3;

  private void init() {
    this.tri3 = new TriangleSolitaireModelImpl(3);
  }

  @Test
  public void testGetScore() {
    this.init();
    int score = 5;

    assertEquals(score, this.tri3.getScore());
    assertFalse(this.tri3.isGameOver());
    this.tri3.move(2, 0, 0, 0);
    score--;
    assertEquals(score, this.tri3.getScore());
    assertFalse(this.tri3.isGameOver());
    this.tri3.move(2, 2, 2, 0);
    score--;
    assertEquals(score, this.tri3.getScore());
    assertFalse(this.tri3.isGameOver());
    this.tri3.move(0, 0, 2, 2);
    score--;
    assertEquals(score, this.tri3.getScore());
    assertTrue(this.tri3.isGameOver());



  }
}
