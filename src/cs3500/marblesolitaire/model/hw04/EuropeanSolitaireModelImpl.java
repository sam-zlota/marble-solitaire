package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.SlotState;

/**
 * This class implements the operations specified by the MarbleSolitaireModel interface by extending
 * the AbstractMarbleSolitaire class. One instance of this class represents the European
 * version of marble solitaire.
 */
public class EuropeanSolitaireModelImpl extends AbstractMarbleSolitaireModel {

  /**
   * Constructs a EuropeanSolitaireModel in terms of its side length, the row coordinate of the
   * starting empty slot, and the column coordinate of the starting empty slot.
   *
   * @param s side length
   * @param r row coordinate of the initial empty slot
   * @param c column coordinate of the initial empty slot
   * @throws IllegalArgumentException if the arm thickness is not odd or below 3
   * @throws IllegalArgumentException if the supplied position for empty is invalid
   */
  public EuropeanSolitaireModelImpl(int s, int r, int c) throws IllegalArgumentException {
    super(s,r,c);
  }

  /**
   * Constructs a Marble Solitaire Model in terms of its side length and by default places initial
   * empty slot at center position.
   *
   * @param s side length
   * @throws IllegalArgumentException if the side length is not odd
   */
  public EuropeanSolitaireModelImpl(int s) {
    this(s, (3 * s - 2) / 2, (3 * s - 2) / 2);
  }

  /**
   * Constructs a Marble Solitaire Model with side length of 3 and uses the supplied coordinates
   * to place initial empty slot.
   *
   * @param sRow row coordinate of empty slot
   * @param sCol column coordinate of empty slot
   * @throws IllegalArgumentException if the supplied position for empty is invalid
   */
  public EuropeanSolitaireModelImpl(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Constructs a European Marble Solitaire Model with default side length of 3 and empty slot at
   * the center position.
   */
  public EuropeanSolitaireModelImpl() {
    this(3, 3);
  }

  @Override
  protected void constructBoard(int size) {
    super.constructBoard(size); //start from english board
    int len = 3 * size - 2;
    for (int row = 0; row < len; row++) {
      for (int col = 0; col < len; col++) {
        if ((row < size - 1) && (col < size - 1)) { //top left corner
          if (row + col > size - 2) {
            //top left
            this.gameboard[row][col] = SlotState.VALID_COVERED;
            //top right (reflection Y)
            this.gameboard[row][len - col - 1] = SlotState.VALID_COVERED;
            //bottom left (reflection X)
            this.gameboard[len - row - 1][col] = SlotState.VALID_COVERED;
            //bottom right(reflection y = x)
            this.gameboard[len - row - 1][len - col - 1] = SlotState.VALID_COVERED;
          }
        }
      }
    }
  }

}
