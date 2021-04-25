package european;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import org.junit.Test;


/**
 * Verifies that game state for a EuropeanMarbleSolitaireModel is properly displayed.
 */
public class EuropeanSolitaireModelImplTestGetGameState {

  private MarbleSolitaireModel msm1;
  private MarbleSolitaireModel msm2;
  private MarbleSolitaireModel msm3;
  private MarbleSolitaireModel msm4;

  private void init() {
    msm1 = new EuropeanSolitaireModelImpl();
    msm2 = new EuropeanSolitaireModelImpl(0,4);
    msm3 = new EuropeanSolitaireModelImpl(3,5,4);
    msm4 = new EuropeanSolitaireModelImpl(5);
  }

  @Test
  public void testGetGameStateInitial() {
    this.init();
    String gameState_msm1 = "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O";
    String gameState_msm2 = "    O O _\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O";
    String gameState_msm3 = "    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O _ O\n"
        + "    O O O";
    assertEquals(gameState_msm1, msm1.getGameState());
    assertEquals(gameState_msm2, msm2.getGameState());
    assertEquals(gameState_msm3, msm3.getGameState());
    assertEquals(
        "        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "      O O O O O O O\n"
            + "        O O O O O", msm4.getGameState());
  }

  @Test
  public void testGameStateGamePlay() {
    this.init();
    this.msm1.move(3,1,3,3);
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O",this.msm1.getGameState());
    this.msm1.move(3,4,3,2);
    this.msm1.move(1,3,3,3);
    this.msm1.move(3,2,3,4);
    this.msm1.move(3,5,3,3);
    this.msm1.move(1,2,3,2);
    this.msm1.move(1,4,3,4);
    this.msm1.move(4,2,2,2);
    this.msm1.move(4,4,2,4);
    this.msm1.move(4,3,2,3);
    this.msm1.move(4,0,4,2);
    assertEquals("    O O O\n"
        + "  O _ _ _ O\n"
        + "O O O O O O O\n"
        + "O _ _ _ _ _ O\n"
        + "_ _ O _ _ O O\n"
        + "  O O O O O\n"
        + "    O O O",this.msm1.getGameState());
    this.msm1.move(4,6,4,4);
    this.msm1.move(2,0,4,0);
    this.msm1.move(2,6,4,6);
    this.msm1.move(5,2,3,2);
    this.msm1.move(5,4,3,4);
    this.msm1.move(6,3,4,3);
    this.msm1.move(2,2,4,2);
    this.msm1.move(2,4,4,4);
    this.msm1.move(4,3,4,1);
    this.msm1.move(4,0,4,2);
    assertEquals("    O O O\n"
        + "  O _ _ _ O\n"
        + "_ O _ O _ O _\n"
        + "_ _ _ _ _ _ _\n"
        + "_ _ O _ O _ O\n"
        + "  O _ _ _ O\n"
        + "    O _ O",this.msm1.getGameState());
  }
}