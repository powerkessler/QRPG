import java.util.*;
public class run {
  
  KeyInput keyInput;
  Window gameWindow;
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
  initKeyInput();
  initWindow();
  //timer = new Timer();
  //timer.schedule(TimerTask task, long delay);
  }
  
  void initKeyInput(){
    keyInput = new KeyInput(this);
  }
  
  void initWindow(){
    gameWindow = new Window(this);
  }
  
}
