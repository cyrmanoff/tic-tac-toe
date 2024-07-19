package User;

import UI.Board;
import java.util.Random;
public class AI extends User {
  private char character;
  public String getName() {
    return "Бендер. Универсальный сгибатель.";
  }
  public char getCharacter() {
    return character;
  }
  public void setCharacter(char character) {
    this.character = character;
  }
  public void aiMove(Board board) {
    int choice;
    do {
      choice = new Random().nextInt(9) + 1;
    } while (!board.fieldAvailable(choice));
    System.out.println("Бендер выбрал - " + choice);
    move(board.getBoard(), getCharacter(), choice);
    board.print();
  }
  @Override
  public void endOfgame() {
    super.endOfgame();
    System.out.println("Победил - " + getName());
  }
}
