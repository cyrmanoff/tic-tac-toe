package Logic;

import UI.Board;
import User.AI;
import User.Gamer;
import User.User;
import java.util.Scanner;
public class Game {
  private static void start(Board board, Gamer gamer, AI ai) {
    printRules(board);
    selectCharacter(gamer, ai);
  }
  public static void process() {
    Board board = new Board();
    Gamer gamer = new Gamer();
    AI ai = new AI();
    start(board, gamer, ai);
    while(true){
      if (board.isFull()) {
        System.out.println("Это ничья.");
        break;
      }
      gamer.gamerMove(board);
      if (GameOver(board, gamer.getCharacter())) {
        end(gamer);
        break;
      }
      ai.aiMove(board);
      if (GameOver(board, ai.getCharacter())) {
        end(ai);
        break;
      }
    }
  }
  private static void end(User user){
    user.endOfgame();
  }
  private static boolean GameOver(Board board, char character){
    short check = checkGame(board, character);
    return isWinner(check);
  }
  private static short checkGame(Board board, char character) {
    StringBuilder str = new StringBuilder();
    for (char[] chars : board.getBoard()) {
      for (char ch : chars) {
        if (ch == character)
          str.append(1);
        else
          str.append(0);
      }
    }
    return Short.valueOf(str.toString(), 2);
  }
  private static boolean isWinner(short x) {
    short[] winCombinations = {
        // По строке
        0b000000111,
        0b000111000,
        0b111000000,
        // По колонке
        0b100100100,
        0b010010010,
        0b001001001,
        // По диагонали
        0b100010001,
        0b001010100
    };
    for (int i = 0; i < 8; i++)
      if ((x & winCombinations[i]) == winCombinations[i])
        return true;
    return false;
  }
  public static void selectCharacter(Gamer gamer, AI ai) {
    Scanner scanner = new Scanner(System.in);
    int choice;
    do {
      System.out.println("А теперь выбери свою фигру: 1 - X, 2 - O");
      while(!scanner.hasNextInt()) {
        System.out.println("Все просто. 1 - это крестик. 2 - это нолик:");
        scanner.next();
      }
      choice = scanner.nextInt();
    } while (choice <= 0 || choice >= 3);
    if (choice == 1) {
      gamer.setCharacter('X');
      ai.setCharacter('O');
    } else {
      gamer.setCharacter('O');
      ai.setCharacter('X');
    }
    System.out.println("Отлично, твой выбор - " + gamer.getCharacter());
  }
  public static void printRules(Board board) {
    System.out.println("Игровое поле выглядит вот так:");
    System.out.println("Следовательно.. просто выбираем клетку от 1 до 9.");
    int i = 0;
    for (char[] chars: board.getBoard()) {
      for (char ch: chars) {
        ch = (char) i;
        i++;
        System.out.print("|" + i + "|");
      }
      System.out.println();
    }
  }
}
