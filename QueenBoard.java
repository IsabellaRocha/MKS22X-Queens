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
          if (solveHelp(c + 1)) {
            return true;
          }
          else {
            removeQueen(r, c);
          }
        }
      }
    }
    return false;
  }
  public boolean solve() {
    for (int idx = 0; idx < board.length; idx++) {
      for (int x = 0; x < board.length; x++) {
        if (board[idx][x] != 0) {
          throw new IllegalStateException("Not a clear board");
        }
      }
    }
    return solveHelp(0);
  }
  public int countSolutions() {
    for (int idx = 0; idx < board.length; idx++) {
      for (int x = 0; x < board.length; x++) {
        if (board[idx][x] != 0) {
          throw new IllegalStateException("Not a clear board");
        }
      }
    }
    return solHelp(0);
  }
  public int solHelp(int c) {
    if (c == board.length) {
      return 1;
    }
    int count = 0;
    for (int r = 0; r < board.length; r++) {
      if (addQueen(r, c)) {
        count += solHelp(c + 1);
        removeQueen(r, c);
      }
    }
    return count;
  }
  public String toString() {
    String output = "";
    for (int idx = 0; idx < board.length; idx++) {
      output += "\n";
      for (int x = 0; x < board[idx].length; x++) {
        if (board[idx][x] != -1) {
          output += "_ ";
        }
        else {
          output += "Q ";
        }
      }
    }
    return output;
  }
  public static void main(String[] args) {
    QueenBoard trial = new QueenBoard(8);
    QueenBoard q = new QueenBoard(3);
    QueenBoard a = new QueenBoard(10);
    QueenBoard b = new QueenBoard(9);
    QueenBoard c = new QueenBoard(5);
    QueenBoard d = new QueenBoard(4);
  //  trial.addQueen(0, 0);
  //  trial.addQueen(2, 2);
  //  trial.addQueen(5, 7);
  //  trial.removeQueen(5, 7);
//    trial.solve();
//    System.out.println(trial);
    System.out.println(trial.countSolutions());
//    q.solve();
//    System.out.println(q);
    System.out.println(q.countSolutions());
    System.out.println(a.countSolutions());
    System.out.println(b.countSolutions());
    System.out.println(c.countSolutions());
    c.solve();
    System.out.println(c);
    System.out.println(d.countSolutions());
    d.solve();
    System.out.println(d);
    System.out.println(trial);
  }
}
