package cs3500.marblesolitaire.model.hw02;

/**
 * Represents a state of a slot in a 2D-array. A slot can be one of:
 * VALID_COVERED - on board with piece on it
 * VALID_EMPTY - on board without piece on it
 * INVALID - off of board
 */
public enum SlotState {
  VALID_COVERED, VALID_EMPTY, INVALID
}
