public class QueenBoard {
  private int[][] board;
  public QueenBoard(int size) {
    board = new int[size][size];
    for (int idx = 0; idx < board.length; idx++) {
      for (int x = 0; x < board[idx].length; x++) {
        board[idx][x] = 0;
      }
    }
  }
  private boolean addQueen(int r, int c) {
    if (board[r][c] == 0) {
      board[r][c] = -1;
      for (int idx = 0; idx < board.length; idx++) {
        if (idx != c) {
          board[r][idx] += 1;
        }
      }
      for (int idx = 0; idx < board.length; idx++) {
        if (idx != r) {
          board[idx][c] += 1;
        }
      }
      return true;
    }
    return false;
  }
  private boolean removeQueen(int r, int c) {
    board[r][c] = 0;
    return true;
  }
}
