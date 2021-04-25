package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This interface offers all the operations for a controller to be implemented for
 * a game of Marble Solitaire. It controls the flow of input and output in conjunction with the
 * model.
 */
public interface MarbleSolitaireController {

  /**
   * Executes the playing of a singular game of Marble Solitaire.
   * @param model a non-null MarbleSolitaireModel
   * @throws IllegalArgumentException if the provided model is null
   * @throws IllegalStateException if the controller is unable to successfully manage I/O
   */
  void playGame(MarbleSolitaireModel model) throws IllegalArgumentException, IllegalStateException;
}
