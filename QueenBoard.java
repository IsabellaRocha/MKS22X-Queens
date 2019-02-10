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
    if (board[r][c] != 0){
  		return false;
  	}
  	else {
  		board[r][c] = -1;
  		for(int idx = 0; idx < board.length; idx++){
        try {
          if (board[idx][c] != -1){
    				board[idx][c] += 1;
    			}
    		}
        catch (Exception e) {}
        try {
          if (board[r][idx] != -1){
    				board[r][idx] += 1;
    			}
        }
        catch (Exception e) {}
  			try {
  				if (board[r + idx][c + idx] != -1){
  					board[r + idx][c + idx] += 1;
  				}
  			}
        catch (Exception e){}
  			try{
  				if (board[r - idx][c + idx] != -1){
  					board[r - idx][c + idx] += 1;
  				}
  			}
        catch (Exception e){}
  			try{
  				if (board[r + idx][c - idx] != -1){
  					board[r + idx][c - idx] += 1;
  				}
  			}
        catch (Exception e){}
  			try{
  				if (board[r - idx][c - idx] != -1){
  					board[r - idx][c - idx] += 1;
  				}
  			}
        catch (Exception e){}
  		}
  	}
    return true;
  }
  private boolean removeQueen(int r, int c) {
    if (board[r][c] == -1) {
      board[r][c] = 0;
      for(int idx = 0; idx < board.length; idx++){
        try {
          if (board[idx][c] != 0){
    				board[idx][c] -= 1;
    			}
    		}
        catch (Exception e) {}
        try {
          if (board[r][idx] != 0){
    				board[r][idx] -= 1;
    			}
        }
        catch (Exception e) {}
  			try {
  				if (board[r + idx][c + idx] != 0){
  					board[r + idx][c + idx] -= 1;
  				}
  			}
        catch (Exception e){}
  			try{
  				if (board[r - idx][c + idx] != 0){
  					board[r - idx][c + idx] -= 1;
  				}
  			}
        catch (Exception e){}
  			try{
  				if (board[r + idx][c - idx] != 0){
  					board[r + idx][c - idx] -= 1;
  				}
  			}
        catch (Exception e){}
  			try{
  				if (board[r - idx][c - idx] != 0){
  					board[r - idx][c - idx] -= 1;
  				}
  			}
        catch (Exception e){}
  		}
      return true;
    }
    return false;
  }
  private int countQueens() {
    int count = 0;
    for (int idx = 0; idx < board.length; idx++) {
      for (int x = 0; x < board.length; x++) {
        if (board[idx][x] == -1) {
          count++;
        }
      }
    }
    return count;
  }
  public boolean solveHelp(int c) {
    if (c >= board.length) {
      return countQueens() == board.length;
    }
    else {
      for (int r = 0; r < board.length; r++) {
        if (addQueen(r, c)) {
          return solveHelp(c + 1);
        }
        removeQueen(r, c);
      }
    }
    return false;
  }
  public String toString() {
    String output = "";
    for (int idx = 0; idx < board.length; idx++) {
      output += "\n";
      for (int x = 0; x < board[idx].length; x++) {
        if (board[idx][x] != -1) {
          output += board[idx][x] + "  ";
        }
        else {
          output += board[idx][x] + " ";
        }
      }
    }
    return output;
  }
  public static void main(String[] args) {
    QueenBoard trial = new QueenBoard(8);
    trial.addQueen(0, 0);
    trial.addQueen(2, 2);
    trial.addQueen(5, 7);
    trial.removeQueen(5, 7);
    System.out.println(trial);
  }
}
