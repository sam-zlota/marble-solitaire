package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * An implementation of the MarbleSolitaireController interface. It supports interactive playing
 * of a given game of Marble Solitaire from user input and displays to the console.
 */

public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final Appendable out;
  private final Scanner scan;

  /**
   * Constructs a MarbleSolitaireControllerImpl with the given Appendable and Scanner.
   *
   * @param in  a Readable to read from.
   * @param out an Appendable to output to.
   * @throws IllegalArgumentException if either in or out is null
   */
  public MarbleSolitaireControllerImpl(Readable in, Appendable out)
      throws IllegalArgumentException {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable cannot be null");
    }
    this.out = out;
    scan = new Scanner(in);
  }

  private void print(String... toPrint) throws IllegalStateException {
    try {
      for (String str : toPrint) {
        out.append(str + "\n");
      }
    } catch (IOException e) {
      throw new IllegalStateException("Cannot write to Appendable");
    }
  }

  @Override
  public void playGame(MarbleSolitaireModel model)
      throws IllegalArgumentException, IllegalStateException {

    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }

    boolean allValsEntered = false;
    boolean gameQuit = false;

    int fromRow = 0;
    int fromCol = 0;
    int toRow = 0;
    int toCol = 0;

    print(model.getGameState(), "Score: " + model.getScore(), "Enter a move: ");
    //while game is still in play
    while (!model.isGameOver() && !gameQuit) {

      //retrieve user input until they have inputted all four values
      while (!allValsEntered && !gameQuit) {
        String next = "";
        int nextVal = 0;

        //try to get next token
        try {
          next = scan.next();
        } catch (NoSuchElementException nse) {
          //throw error if nothing to read
          throw new IllegalStateException("Readable ran out of input");
        }

        //check if game was quit
        //will throw error if next was not a positive integer or not q or not q
        if (next.equalsIgnoreCase("q")) {
          gameQuit = true;
          print("Game quit!", "State of game when quit:", model.getGameState(),
              "Score: " + model.getScore());
        } else {
          //if game not quit
          //try to assign nextVal
          try {
            nextVal = Integer.parseInt(next);
            if (nextVal <= 0) {
              throw new NumberFormatException();
            }
            //if input was valid
            //determine which parameter for move is next to be assigned and assign it
            if (fromRow != 0) {
              if (fromCol != 0) {
                if (toRow != 0) {
                  toCol = nextVal;
                  allValsEntered = true;
                } else {
                  toRow = nextVal;
                }
              } else {
                fromCol = nextVal;
              }
            } else {
              fromRow = nextVal;
            }
          } catch (NumberFormatException nfe) {
            print("\"" + next + "\" is invalid. " + "Re-enter value.");
          }
        }
      }

      //exit inner while loop
      //after all values have been entered
      //then try to make move
      if (allValsEntered) {
        try {
          // try to make move
          model.move(fromRow - 1, fromCol - 1, toRow - 1, toCol - 1);
          if (model.isGameOver()) {
            print("Game over!", model.getGameState(), "Score: " + model.getScore());
          } else {
            print(model.getGameState(), "Score: " + model.getScore(), "Enter a move: ");
          }
        } catch (IllegalArgumentException iae) {
          //move was invalid determined by model
          print(String.format("Invalid move. Play again. (%s, %s) ---> (%s, %s) %s",
              fromRow, fromCol, toRow, toCol, iae.getMessage().substring(14)));
        }
        //reset values
        fromRow = 0;
        fromCol = 0;
        toRow = 0;
        toCol = 0;
        allValsEntered = false;
      }
    }
  }
}




