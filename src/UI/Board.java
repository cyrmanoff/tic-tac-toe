package UI;
public class Board {
  private char[][] board;
  public Board() {
   char[][] standartSize = {{' ', ' ', ' '}, // Над подумать с размером больше, но ограничены типом short при поиске выигрыша
                            {' ', ' ', ' '},
                            {' ', ' ', ' '}};
   setBoard(standartSize);
  }
  public char[][] getBoard() {
    return board;
  }
  public void setBoard(char[][] board) {
    this.board = board;
  }
  public boolean isFull(){
    boolean isFull = false;
    int count = 0;
    for (char[] chars : getBoard()) {
      for (char ch : chars) {
        if (ch == ' ')
          count++;
      }
    }
    if (count <= 1)
      isFull = true;
    return isFull;
  }
  public boolean fieldAvailable(int index){
    return switch (index) {
      case 1 -> (getBoard()[0][0] == ' ');
      case 2 -> (getBoard()[0][1] == ' ');
      case 3 -> (getBoard()[0][2] == ' ');
      case 4 -> (getBoard()[1][0] == ' ');
      case 5 -> (getBoard()[1][1] == ' ');
      case 6 -> (getBoard()[1][2] == ' ');
      case 7 -> (getBoard()[2][0] == ' ');
      case 8 -> (getBoard()[2][1] == ' ');
      case 9 -> (getBoard()[2][2] == ' ');
      default -> false;
    };
  }
  public void print(){
    for (char[] chars : getBoard()) {
      for (char ch : chars) {
        System.out.print("|" + ch + "|");
      }
      System.out.println();
    }
  }

}
