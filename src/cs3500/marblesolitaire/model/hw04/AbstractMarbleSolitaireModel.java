package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.SlotState;

/**
 * Abstract class to be used in representing any valid marble solitaire board. The marble
 * solitaire model manages game state and enforces the rules. One object of the model
 * represents one game of marble solitaire.
 */
public abstract class AbstractMarbleSolitaireModel implements MarbleSolitaireModel {

  protected SlotState[][] gameboard;

  protected AbstractMarbleSolitaireModel() {
    //is called by Triangle class
    //does nothing really
    this.gameboard = new SlotState[0][];
  }

  protected AbstractMarbleSolitaireModel(int size, int r, int c) throws IllegalArgumentException {
    if (size < 3) {
      throw new IllegalArgumentException("invalid arm length: too small");
    } else if (size % 2 != 1) {
      throw new IllegalArgumentException("invalid arm length: not odd");
    } else if (r < 0 || r >= 3 * size - 2 || c < 0 || c >= 3 * size - 2) {
      throw new IllegalArgumentException("Empty cell position not on board "
          + "(" + r + "," + c + ")");
    } else {
      //constructs 2D array board with invalid and valid postions
      //but all the valid positions are covered: none are empty
      this.constructBoard(size);
      if (this.gameboard[r][c] == SlotState.INVALID) {
        throw new IllegalArgumentException("Empty cell position not on board"
            + " (" + r + "," + c + ")");
      } else {
        this.gameboard[r][c] = SlotState.VALID_EMPTY;
      }
    }
  }

  @Override
  public String getGameState() {
    String gameState = "";
    for (SlotState[] row: this.gameboard) {
      String nextRow = "";
      for (SlotState slot: row) {
        switch (slot) {
          case VALID_COVERED:
            nextRow += "O ";
            break;
          case VALID_EMPTY:
            nextRow += "_ ";
            break;
          default:
            nextRow += "  ";
            break;
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
  public boolean isGameOver() {
    for (int row = 0; row < this.gameboard.length; row++) {
      for (int col = 0; col < this.gameboard.length; col++) {
        //checks that each valid, covered position does not have any moves
        if (this.gameboard[row][col] == SlotState.VALID_COVERED && hasMove(row,col)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int getScore() {
    int score = 0;
    for (SlotState[] row: this.gameboard) {
      for (SlotState slot: row) {
        if (slot == SlotState.VALID_COVERED) {
          score++;
        }
      }
    }
    return score;
  }


  /**
   * Performs same operations as specified in interface. Specifications of exceptions thrown are
   * detailed below.
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow the row number of the position to be moved to
   *              (starts at 0)
   * @param toCol the column number of the position to be moved to
   *              (starts at 0)
   * @throws IllegalArgumentException if moving to or from position off of board
   * @throws IllegalArgumentException if moving from position with no marble
   * @throws IllegalArgumentException if moving to position with a marble
   * @throws IllegalArgumentException if moving more than two positions away
   * @throws IllegalArgumentException if moving over empty slot
   * @throws IllegalArgumentException if moving diagonally
   *
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    //determines which direction potential move would be in
    //and what the coordinates are of the space in between
    int jumpRow = getJumpRow(fromRow, toRow);
    int jumpCol = getJumpCol(fromCol, toCol);

    //will throw exception if move is not valid
    if (isValidMove(fromRow, fromCol, toRow, toCol, jumpRow, jumpCol)) {
      //remove piece in between
      this.gameboard[jumpRow][jumpCol] = SlotState.VALID_EMPTY;
      //uncover slot at initial position
      this.gameboard[fromRow][fromCol] = SlotState.VALID_EMPTY;
      //cover slot at final position
      this.gameboard[toRow][toCol] = SlotState.VALID_COVERED;
    }

  }

  protected void constructBoard(int size) {
    int len = 3 * size - 2; //length of 2D array corresponding to game board with givne arm length
    this.gameboard = new SlotState[len][len];

    for (int row = 0; row < len; row++) {
      for (int col = 0; col < len; col++) {
        if (((row < size - 1) || (row >= 2 * size - 2))
            && (col >= size - 1) && (col <= 2 * size - 2)) {
          //non-overlapping portion of top or bottom square
          this.gameboard[row][col] = SlotState.VALID_COVERED;
        } else if ((row >= size - 1) && (row <= 2 * size - 2)) {
          //entirety of left, right, and center square {
          this.gameboard[row][col] = SlotState.VALID_COVERED;
        } else {
          this.gameboard[row][col] = SlotState.INVALID;
        }
      }
    }
  }

  protected int getJumpRow(int fromRow, int toRow) {
    int jumpRow = fromRow;
    if (fromRow - toRow == 2) {
      //trying to move up
      jumpRow = fromRow - 1;
    } else if (toRow - fromRow == 2) {
      //trying to move down
      jumpRow = fromRow + 1;
    }
    return jumpRow;
  }

  protected int getJumpCol(int fromCol, int toCol) {
    int jumpCol = fromCol;
    if (fromCol - toCol == 2) {
      //trying to move left
      jumpCol = fromCol - 1;
    } else if (toCol - fromCol == 2)  {
      //trying to move right
      jumpCol = fromCol + 1;
    }
    return jumpCol;
  }

  protected boolean hasMove(int row, int col) {
    //rectilinear moves only
    //does not handle diagonal
    try {
      isValidMove(row, col, row + 2, col, row + 1, col);//move down
    } catch (IllegalArgumentException e1) {
      try {
        isValidMove(row, col, row - 2, col, row - 1, col);//move up
      } catch (IllegalArgumentException e2) {
        try {
          isValidMove(row, col, row, col - 2, row, col - 1);//move left
        } catch (IllegalArgumentException e3) {
          try {
            isValidMove(row, col, row, col + 2, row, col + 1); //move right
          } catch (IllegalArgumentException e4) {
            return false;
          }
        }
      }
    }
    return true;
  }

  protected boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, int jumpRow,
      int jumpCol) {
    if ((fromRow < 0) || (fromRow >= this.gameboard.length)
        || (fromCol < 0) || (fromCol > this.gameboard.length)
        || (toRow < 0) || (toRow >= this.gameboard.length)
        || (toCol < 0) || (toCol >= this.gameboard.length)) {
      throw new IllegalArgumentException(
          "Invalid Move: cannot move to or from a position off of board");
    } else if (this.gameboard[fromRow][fromCol] == SlotState.INVALID
        || this.gameboard[toRow][toCol] == SlotState.INVALID) {
      throw new IllegalArgumentException("Invalid Move: "
          + "cannot move to or from a position off of board");
    } else if (this.gameboard[fromRow][fromCol] == SlotState.VALID_EMPTY) {
      throw new IllegalArgumentException("Invalid Move: no marble to move at from slot");
    } else if (this.gameboard[toRow][toCol] == SlotState.VALID_COVERED) {
      throw new IllegalArgumentException("Invalid Move: slot covered at to slot");
    } else if ((Math.abs(fromRow - toRow) != 2) && (Math.abs(fromCol - toCol) != 2)) {
      throw new IllegalArgumentException("Invalid Move: positions not two slots apart");
    } else if (this.gameboard[jumpRow][jumpCol] == SlotState.VALID_EMPTY) {
      throw new IllegalArgumentException("Invalid Move: no marble to jump over");
    } else if ((fromRow != toRow) && (fromCol != toCol)) {
      throw new IllegalArgumentException("Invalid Move: cannot make diagonal move");
    }  else {
      return true;
    }
  }

}
