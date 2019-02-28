import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze {
  private char[][] maze;
  public Maze(String file) throws FileNotFoundException{
    open(file);
  }
  public void open(String file) throws FileNotFoundException{
    File f = new File(file);
    Scanner s = new Scanner(f);
    int count = 0;
    while (s.hasNext()) {
      count++;
      s.nextLine();
    }
    s = new Scanner(f);
    String t = s.nextLine();
    maze = new char[count][t.length()];
    for (int x = 0; x < t.length(); x++) {
      maze[0][x] = t.charAt(x);
    }
    count = 1;
    while (s.hasNext()) {
      t = s.nextLine();
      for (int x = 0; x < t.length(); x++) {
        maze[count][x] = t.charAt(x);
      }
      count++;
    }
  }
  public String toString() {
    String ans = "";
    for (int i = 0; i < maze[0].length; i++) {
      for (int x = 0; x < maze.length; x++) {
        ans += maze[i][x];
      }
      ans += "\n";
    }
    return ans;
  }
  public int solve() {
    for (int x = 0; x < maze.length; x++) {
      for (int i = 0; i < maze[0].length; i++) {
        if (maze[x][i] == 'S') {
          maze[x][i] = '@';
          return solve(x,i);
        }
      }
    }
  }
}
