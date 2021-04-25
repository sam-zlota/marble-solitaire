package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.SlotState;

/**
 * This class implements the operations specified by the MarbleSolitaireModel interface by extending
 * the AbstractMarbleSolitaire class. One instance of this class represents the Triangle
 * version of marble solitaire.
 */

public class TriangleSolitaireModelImpl extends AbstractMarbleSolitaireModel {

  /**
   * Constructs a TriangleSolitaireModelImpl in terms of its base length, the row coordinate of the
   * starting empty slot, and the column coordinate of the starting empty slot.
   *
   * @param size base length
   * @param row row coordinate of the initial empty slot
   * @param col column coordinate of the initial empty slot
   * @throws IllegalArgumentException if the base is less than 1
   * @throws IllegalArgumentException if the supplied position for empty is invalid
   */
  public TriangleSolitaireModelImpl(int size, int row, int col) {
    super();
    if (size < 1) {
      throw new IllegalArgumentException("Invalid dimensions: non-positive");
    }
    else if (row < 0 || row >= size || col < 0 || col >= size ) {
      throw new IllegalArgumentException("Empty cell position not on board "
          + "(" + row + "," + col + ")");
    } else {
      this.constructBoard(size);
      if (this.gameboard[row][col] == SlotState.INVALID) {
        throw new IllegalArgumentException("Empty cell position not on board "
            + "(" + row + "," + col + ")");
      }
      this.gameboard[row][col] = SlotState.VALID_EMPTY;
    }
  }

  /**
   * Constructs a TriangleSolitaireModelImpl using specified base length, and sets the
   * coordinates of the starting empty slot to (0, 0).
   *
   * @param size base length
   * @throws IllegalArgumentException if the base is less than 1
   */
  public TriangleSolitaireModelImpl(int size) {
    this(size, 0 , 0);
  }

  /**
   * Constructs a TriangleSolitaireModelImpl with default base length 5 and the default row
   * and column coordinate of the starting empty slot at (0, 0).
   *
   */
  public TriangleSolitaireModelImpl() {
    this(0,0);
  }

  /**
   * Constructs a TriangleSolitaireModelImpl with default base length 5 and the specified row
   * and column coordinate of the starting empty slot.
   *
   * @param row row coordinate of the initial empty slot
   * @param col column coordinate of the initial empty slot
   * @throws IllegalArgumentException if the supplied position for empty is invalid
   */
  public TriangleSolitaireModelImpl(int row, int col) {
    this(5, row, col);
  }

  @Override
  protected void constructBoard(int size) {
    //stores board as a nearly equalateral triangle with
    //left edge align vertically in first column of 2D array
    this.gameboard = new SlotState[size][size];
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        if (col <= row) {
          this.gameboard[row][col] = SlotState.VALID_COVERED;
        }
        else {
          this.gameboard[row][col] = SlotState.INVALID;
        }
      }
    }
  }

  @Override
  public String getGameState() {
    String gameState = "";
    String nextRow;
    int numSpaces; //number of spaces to be padded onto a given row
    for (int row = 0; row < this.gameboard.length; row++) {
      numSpaces = this.gameboard.length - row - 1;
      nextRow = "";
      while (numSpaces > 0) {
        nextRow += " ";
        numSpaces--;
      }
      for (int col = 0; col < this.gameboard.length; col++) {
        if (this.gameboard[row][col] == SlotState.VALID_COVERED) {
          nextRow += "O ";
        }
        else if (this.gameboard[row][col] == SlotState.VALID_EMPTY) {
          nextRow += "_ ";
        }
      }

      //remove spaces at end of row
      while (nextRow.substring(nextRow.length() - 1).equals(" ")) {
        nextRow = nextRow.substring(0, nextRow.length() - 1);
      }
      nextRow += "\n";
      gameState += nextRow;
    }
    //remove last newline
    gameState = gameState.substring(0, gameState.length() - 1);
    return gameState;
  }

  @Override
  protected boolean hasMove(int row, int col) {
    try {
      //down-right
      isValidMove(row, col, row + 2, col + 2, row + 1, col + 1);
    } catch (IllegalArgumentException e1) {
      try {
        //up-left
        isValidMove(row, col, row - 2, col - 2, row - 1, col - 1);
      } catch (IllegalArgumentException e2) {
        try {
          //down-left
          isValidMove(row, col, row + 2, col, row + 1, col );
        } catch (IllegalArgumentException e3) {
          try {
            //up-right
            isValidMove(row, col, row - 2, col, row - 1, col);
          } catch (IllegalArgumentException e4) {
            try {
              //move left
              isValidMove(row, col, row, col - 2, row, col - 1);
            } catch (IllegalArgumentException e6) {
              try {
                //move right
                isValidMove(row, col, row, col + 2, row, col + 1);
              } catch (IllegalArgumentException e7) {
                return false;//has no valid moves
              }
            }
          }
        }
      }
    }
    return true;//has at least one valid move
  }


  /**
   * overrides isValidMove to allow for diagonal moves exactly two slots away.
   */
  @Override
  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, int jumpRow,
      int jumpCol) {
    try {
      return super.isValidMove(fromRow, fromCol, toRow, toCol, jumpRow, jumpCol);
    } catch (IllegalArgumentException iae) {
      if (iae.getMessage().equals("Invalid Move: cannot make diagonal move")) {
        if ((Math.abs(fromRow - toRow) == 2) && (Math.abs(fromCol - toCol) == 2)) {
          return true;
        }
      }
      throw iae;
    }
  }


}
