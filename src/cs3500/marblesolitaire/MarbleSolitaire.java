package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;
import java.io.InputStreamReader;

/**
 * A class with main method to play a MarbleSolitaireModel from the command line.
 */
public final class MarbleSolitaire {
  /**
   * The main method to be called from the command line to interactively run a game of Marble
   * Solitaire. The user can specify with command line arguments how they would like to configure
   * their model.
   * @param args command line arguments
   */
  public static void main(String[] args) {
    MarbleSolitaireModel model = null;
    int len = args.length;
    if (len == 1) {
      switch (args[0]) {
        case "english":
          model = new MarbleSolitaireModelImpl();
          break;
        case "european":
          model = new EuropeanSolitaireModelImpl();
          break;
        case "triangular":
          model = new TriangleSolitaireModelImpl();
          break;
        default:
          break;
      }
    } else if (len == 3) {
      switch (args[0]) {
        case "english":
          model = new MarbleSolitaireModelImpl(Integer.parseInt(args[2]));
          break;
        case "european":
          model = new EuropeanSolitaireModelImpl(Integer.parseInt(args[2]));
          break;
        case "triangular":
          model = new TriangleSolitaireModelImpl(Integer.parseInt(args[2]));
          break;
        default:
          break;
      }

    } else if (len == 4) {
      switch (args[0]) {
        case "english":
          model = new MarbleSolitaireModelImpl(Integer.parseInt(args[2]),Integer.parseInt(args[3]));
          break;
        case "european":
          model = new EuropeanSolitaireModelImpl(Integer.parseInt(args[2]),
              Integer.parseInt(args[3]));
          break;
        case "triangular":
          model = new TriangleSolitaireModelImpl(Integer.parseInt(args[2]),
              Integer.parseInt(args[3]));
          break;
        default:
          break;
      }
    } else {
      //do nothing
    }
    (new MarbleSolitaireControllerImpl(new InputStreamReader(System.in),
        System.out)).playGame(model);
  }
}