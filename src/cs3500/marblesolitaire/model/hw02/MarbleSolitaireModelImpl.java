package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractMarbleSolitaireModel;

/**
 * This class implements the operations specified by the MarbleSolitaireModel interface by extending
 * the AbstractMarbleSolitaire class. One instance of this class represents the English
 * version of marble solitaire.
 */
public class MarbleSolitaireModelImpl extends AbstractMarbleSolitaireModel {

  /**
   * Constructs an English Marble Solitaire Model in terms of its arm thickness, the row coordinate
   * of the starting empty slot, and the column coordinate of the starting empty slot.
   *
   * @param a arm thickness
   * @param r row coordinate of the initial empty slot
   * @param c column coordinate of the initial empty slot
   * @throws IllegalArgumentException if the arm thickness is not odd or below 3
   * @throws IllegalArgumentException if the supplied position for empty is invalid
   */
  public MarbleSolitaireModelImpl(int a, int r, int c) throws IllegalArgumentException {
    super(a,r,c);
  }

  /**
   * Constructs an English Marble Solitaire Model in terms of its arm thickness and
   * by default places initial empty slot at center position.
   *
   * @param a arm thickness
   * @throws IllegalArgumentException if the arm thickness is not odd
   */
  public MarbleSolitaireModelImpl(int a) {
    this(a, (3 * a - 2) / 2, (3 * a - 2) / 2);
  }

  /**
   * Constructs an English Marble Solitaire Model with arm thickness of 3 and uses
   * the supplied coordinates to place initial empty slot.
   *
   * @param sRow row coordinate of empty slot
   * @param sCol column coordinate of empty slot
   * @throws IllegalArgumentException if the supplied position for empty is invalid
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    //second constructor
    this(3, sRow, sCol);
  }

  /**
   * Constructs an English Marble Solitaire Model with default arm thickness of 3 and
   * empty slot at the center position.
   */
  public MarbleSolitaireModelImpl() {
    //first constructor
    this(3, 3);
  }


}
