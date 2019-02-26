import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze {
  public static void main(String[] args) {
    char[][] field = new char[1][1];
    try {
      field =
    }
  }
  public static char[][] open(String file) throws FileNotFoundException{
    File f = new File(file);
    Scanner s = new Scanner(f);
    int count = 0;
    while (s.hasNext()) {
      count++;
    }
    s = new Scanner(f);
    String t = s.nextLine();
    char[][] field = new char[count][t.length()];
    s = new Scanner(f);
    count = 0;
    while (s.hasNext()) {
      t = s.nextLine();
      for (int x = 0; x < t.length(); x++) {
        field[count][x] = t.charAt(x);
      }
      count++;
    }
    return field;
  }
}
