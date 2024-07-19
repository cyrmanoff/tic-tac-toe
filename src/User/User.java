package User;
public abstract class User implements Action {
  public void endOfgame() {}
  @Override
  public void move(char[][] board, char character, int choice) {
    switch(choice) {
      case 1:
        board[0][0] = character;
        break;
      case 2:
        board[0][1] = character;
        break;
      case 3:
        board[0][2] = character;
        break;
      case 4:
        board[1][0] = character;
        break;
      case 5:
        board[1][1] = character;
        break;
      case 6:
        board[1][2] = character;
        break;
      case 7:
        board[2][0] = character;
        break;
      case 8:
        board[2][1] = character;
        break;
      case 9:
        board[2][2] = character;
        break;
    }
  }
}
