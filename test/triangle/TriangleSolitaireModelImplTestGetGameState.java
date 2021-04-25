package triangle;


import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import org.junit.Test;

/**
 * Verifies that game state for a EuropeanMarbleSolitaireModel is properly displayed.
 */
public class TriangleSolitaireModelImplTestGetGameState {
  private MarbleSolitaireModel msm1;
  private MarbleSolitaireModel msm2;
  private MarbleSolitaireModel msm3;
  private MarbleSolitaireModel msm4;
  private MarbleSolitaireModel msm5;


  private void init() {
    msm1 = new TriangleSolitaireModelImpl();
    msm2 = new TriangleSolitaireModelImpl(1,1);
    msm3 = new TriangleSolitaireModelImpl(5,4,4);
    msm4 = new TriangleSolitaireModelImpl(13);
    msm5 = new TriangleSolitaireModelImpl(3);
  }

  @Test
  public void testGetGameStateInitial() {
    this.init();
    String gameState_msm1 = "    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O";
    String gameState_msm2 = "    O\n"
        + "   O _\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O";
    String gameState_msm3 = "    O\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O _";
    assertEquals(gameState_msm1, msm1.getGameState());
    assertEquals(gameState_msm2, msm2.getGameState());
    assertEquals(gameState_msm3, msm3.getGameState());
    assertEquals(
        "            _\n"
            + "           O O\n"
            + "          O O O\n"
            + "         O O O O\n"
            + "        O O O O O\n"
            + "       O O O O O O\n"
            + "      O O O O O O O\n"
            + "     O O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "   O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + " O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O", msm4.getGameState());


  }

  @Test
  public void testGameStateGamePlay() {
    this.init();
    assertEquals("  _\n"
        + " O O\n"
        + "O O O", this.msm5.getGameState());
    this.msm5.move(2, 0, 0, 0);
    assertEquals("  O\n"
        + " _ O\n"
        + "_ O O", this.msm5.getGameState());
    this.msm5.move(2, 2, 2, 0);
    assertEquals("  O\n"
        + " _ O\n"
        + "O _ _", this.msm5.getGameState());
    this.msm5.move(0, 0, 2, 2);
    assertEquals("  _\n"
        + " _ _\n"
        + "O _ O", this.msm5.getGameState());



  }

}
