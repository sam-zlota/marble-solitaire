package european;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import org.junit.Test;

/**
 * Verifies that game score for a MarbleSolitaireModel is properly calculated.
 */
public class EuropeanSolitaireModelImplTestGetScore {

  private MarbleSolitaireModel msm1;

  private void init() {
    this.msm1 = new EuropeanSolitaireModelImpl();
  }

  @Test
  public void testIsGetScore() {
    int score = 36;
    this.init();
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(3,1,3,3);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(3,4,3,2);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(1,3,3,3);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(3,2,3,4);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(3,5,3,3);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(1,2,3,2);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(1,4,3,4);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(4,2,2,2);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(4,4,2,4);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(4,3,2,3);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(4,0,4,2);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(4,6,4,4);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(2,0,4,0);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(2,6,4,6);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(5,2,3,2);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(5,4,3,4);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(6,3,4,3);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(2,2,4,2);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(2,4,4,4);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(4,3,4,1);
    assertEquals(score, this.msm1.getScore());
    score--;
    this.msm1.move(4,0,4,2);
  }

}
