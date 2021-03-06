import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze {
  private char[][] maze;
  private boolean animate;
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
  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {}
   }
   public void setAnimate(boolean b){
     animate = b;
   }
   public void clearTerminal(){
    //erase terminal, go to top left of screen.
    System.out.println("\033[2J\033[1;1H");
  }
  public String toString() {
    String ans = "";
    for (int x = 0; x < maze.length; x++) {
      for (int i = 0; i < maze[0].length; i++) {
        ans += maze[x][i];
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
    return -2;
  }
  public int solve(int row, int col) {
    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(20);
    }
    for (int x = -1; x < 2; x++) {
      for (int i = -1; i < 2; i++) {
        if (x+i == -1 || x+i == 1) {
          if (maze[row+x][col+i] == 'E') {
            return 1;
          }
          if (maze[row+x][col+i] == ' ') {
            maze[row+x][col+i] = '@';
            int rec = solve(row+x,col+i);
            if (rec != -1) {
              return rec+1;
            }
            else {
              maze[row+x][col+i] = '.';
            }
          }
        }
      }
    }
    return -1;
  }
}
