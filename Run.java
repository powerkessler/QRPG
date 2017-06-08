import java.util.*;
public class run {
  
  Keys keyInput;
  Game gameWindow;
  Timer timer;
  TimerTask task;
  ArrayList<Character> characters;
  ArrayList<Mob> mobs;
  
  public static void main(String[] args0){
    new Run();
  }
  
  public Run(){
  characters = new ArrayList<Character>();
  mobs = new ArrayList<Mob>();
  Charcter c1 = new Character(32, 32, "x24j", gameWindow, true); //w,h,name,pass,controllable
  initWindow();
  //timer = new Timer();
  //timer.schedule(TimerTask task, long delay);
  }
  
  void initWindow(){
    gameWindow = new Game(this);
  }
  
}
