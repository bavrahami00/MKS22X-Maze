import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze {
  private char[][] maze;
  public char[][] open(String file) throws FileNotFoundException{
    File f = new File(file);
    Scanner s = new Scanner(f);
    int count = 0;
    while (s.hasNext()) {
      count++;
    }
    s = new Scanner(f);
    String t = s.nextLine();
    char[][] maze = new char[count][t.length()];
    s = new Scanner(f);
    count = 0;
    while (s.hasNext()) {
      t = s.nextLine();
      for (int x = 0; x < t.length(); x++) {
        maze[count][x] = t.charAt(x);
      }
      count++;
    }
    return maze;
  }
  public void toString() {
    String ans = "";
    for (int i = 0; i < maze[0].length; i++) {
      for (int x = 0; x < maze.length; x++) {
        ans += maze[x][i];
      }
      ans += "\n";
    }
    return ans;
  }
}
