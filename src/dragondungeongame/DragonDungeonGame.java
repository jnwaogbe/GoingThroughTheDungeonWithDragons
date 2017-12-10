
package dragondungeongame;

import java.awt.Point;
import java.util.LinkedList;

public class DragonDungeonGame implements MazeListener {
    
    static boolean finalWin = false;       
    Maze maze;

    public DragonDungeonGame() {
        // a 30 rows x 50 columns maze
        maze = new Maze(30, 50);

        // register object of class Main to the maze
        maze.addMazeListener(this);
    }

    public LinkedList myRecursion(int row, int col) {
        LinkedList<Point> ll = new LinkedList();
        for (int i = 10; i < 20; i++) {
            ll.addFirst(new Point(i, i));
        }
        return(ll);
    }

    public void MazeClicked(int row, int col) {
        System.out.println("You clicked " + row + " " + col + ". ");
        //System.out.println("The data at this position is: " + maze.getMazeData(row, col));
        PathFinder p = new PathFinder(maze);
        int dir = 0;
        LinkedList ll = p.findSolution(row, col);
        maze.showPath(ll.iterator());
    }
    
     public static void main(String[] args) {
        // new DragonDungeonGame();
            
         Player Jessica = new Player("Jessica");
        
         
         while(Jessica.isAlive && !finalWin){
             
             EasyDragon ed = new EasyDragon("Shannon");
             
             while(ed.health > 0){
                 if(ed.greeting()){
                   Jessica.greeting();
                   int damage = Jessica.attack(ed.defense);
                   ed.takeDamage(damage);
                   ed.defeated();
                   if(ed.defeated){
                       break;
                   }
                   int dragdamage = ed.attack(Jessica.defense);
                   Jessica.takeDamage(dragdamage);
                   if(!Jessica.isAlive){
                       break;
                   }
                   ed.greeting();
               }

                else{
                     Jessica.setDeath();
                     break;
                 }
             }
             
             
             
             if(!Jessica.isAlive){
                       break;
                   }

                 ed.getTreasure();
                 ed.tType.PowerUp(Jessica, ed);
                 Jessica.greeting();
                 
                 WordGame wg = new WordGame("easy");
                 boolean eFriend = wg.Game();
                 ed.befriend(eFriend, Jessica);
                                
                 Jessica.greeting();
                 
               
                        
             MediumDragon md = new MediumDragon("Alan");
             while(md.health > 0){
                                                
                 if(md.greeting()){
                   Jessica.greeting();
                   int damage = Jessica.attack(md.defense);
                   md.takeDamage(damage);
                   md.defeated();
                   if(md.defeated){
                       break;
                   }
                   int dragdamage = md.attack(Jessica.defense);
                   Jessica.takeDamage(dragdamage);
                   if(!Jessica.isAlive){
                       break;
                   }
               }
                 else{
                     Jessica.setDeath();
                     break;
                 }
             }
             
             if(!Jessica.isAlive){
                       break;
                   }
             
                 md.getTreasure();
                 md.tType.PowerUp(Jessica, md);
                 Jessica.greeting();
                 

                 WordGame wg2 = new WordGame("medium");
                 boolean mFriend = wg2.Game();
                 md.befriend(mFriend, Jessica);
                                   
                 Jessica.greeting();
                 
             
                HardDragon hd = new HardDragon("Rita");
                while(hd.health > 0){
                 
                                
                 if(hd.greeting()){
                   Jessica.greeting();
                   int damage = Jessica.attack(hd.defense);
                   hd.takeDamage(damage);
                   hd.defeated();
                   if(hd.defeated){
                       break;
                   }
                   int dragdamage = hd.attack(Jessica.defense);
                   Jessica.takeDamage(dragdamage);
                   if(!Jessica.isAlive){
                       break;
                   }
               }
                   else{
                     Jessica.setDeath();
                     break;
                 }
             }
             
             if(!Jessica.isAlive){
                       break;
                   }
             
                 hd.getTreasure();
                 hd.tType.PowerUp(Jessica, hd);
                 Jessica.greeting();
                 

                 WordGame wg3= new WordGame("hard");
                 boolean hFriend = wg3.Game();
                 hd.befriend(hFriend, Jessica);
                          
                 Jessica.greeting();
                 
             
        if(ed.friend||md.friend||hd.friend){
             BossDragon bd = new BossDragon("Software Design", 1);
             while(bd.health > 0){
                                            
                 if(bd.greeting()&&bd.health>0){
                   Jessica.greeting();
                   int damage = Jessica.attack(bd.defense);
                   bd.takeDamage(damage);
                   bd.defeated();
                   if(bd.defeated){
                       break;
                   }
                   int dragdamage = bd.attack(Jessica.defense);
                   Jessica.takeDamage(dragdamage);
                   if(!Jessica.isAlive){
                       break;
                   }
               }
                else{
                     Jessica.setDeath();
                     break;
                 }       
             }
           finalWin = bd.defeated;
        }
          
        else{
            System.out.println("\nYou are not worthy to fight me, the BO$$ dragon.");
            Jessica.setDeath();
        }
      
        
        if(!Jessica.isAlive){
                       break;
                   }
              
          
             }
             
         if(finalWin){
             System.out.println("Congrats! YOu have defeated the Bo$$ Dragon!!!");
         }
         
         if(Jessica.health <1){
             
             System.out.println("You have lost");
             
         }
         else{
             System.out.println("Congrast! You have won!");
         }
     } 

}
