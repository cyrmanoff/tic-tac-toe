import Logic.Game;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String answer;
    do {
      Game.process();
      System.out.println("Сыграем еще раз? (Y/N)");
      while (!scanner.hasNext("N")){
        if (scanner.hasNext("Y"))
          break;
        System.out.println("Только Y или N");
        scanner.next();
      }
      answer = scanner.nextLine();
    } while (answer.equals("Y"));
  }
}