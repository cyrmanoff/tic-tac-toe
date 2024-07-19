package User;

import UI.Board;
import java.util.Scanner;
public class Gamer extends User {
  private char character; //'X';
  public char getCharacter() {
    return character;
  }
  public void setCharacter(char character) {
    this.character = character;
  }
  @Override
  public void endOfgame() {
    super.endOfgame();
    System.out.println("Бендер будет недоволен.. Ты победил!");
  }
  public void gamerMove(Board board) {
    int choice;
    while(true) {
      choice = getChoice();
      if (board.fieldAvailable(choice))
        break;
      else
        System.out.println("Поле занято. Выбери другое:");
    }
    move(board.getBoard(), getCharacter(), choice);
    board.print();
  }
  private static int getChoice() {
    Scanner scanner = new Scanner(System.in);
    int choice;
    do {
      System.out.println("Твой ход. Выбери клетку (1-9): ");
      while(!scanner.hasNextInt()) {
        System.out.println("Это не число, однако. Попробуй еще раз:");
        scanner.next();
      }
      choice = scanner.nextInt();
    } while (choice <= 0 || choice >= 10);
    return choice;
  }
}
