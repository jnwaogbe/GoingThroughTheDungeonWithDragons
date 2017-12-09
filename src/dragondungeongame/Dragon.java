package dragondungeongame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Shannon
 */
public class Dragon implements Character {
    
    public int Difficulty;
    public String name;
    public Treasure tType;
    public int health;
    public int defense;
    public int attackPower;
    public boolean friend, defeated;
    public Random rand = new Random();
    
    public Dragon(String dname) {
    
    //    Difficulty = dDifficulty;
        name = dname;
                
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attackPower;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int attack(int playerDefense) {
              
      
        return 0;
    
    
    }
    
    public void takeDamage(int damage){
        health = health - damage;
    }

    public void getTreasure(){
        
        int treas = rand.nextInt(3);
        String treasu;
        
        switch(treas){
            case 1: 
                treasu = "sleep";
                break;
            case 2: 
                treasu = "treasure";
                break;
            default: 
                treasu = "food";
                break;
            
        }
        
       
        tType = new Treasure(treasu); 
    }
    
    
   
   public boolean greeting(){
       
       Scanner reader =  reader = new Scanner(System.in);
       
       

       System.out.println("\n\nDragon: " + this.name + 
               "\n Health: " + this.health + 
               "\n Power: " + this.attackPower + 
               "\n Defense: " + this.defense
       );
       
       if(this.health > 0){
               System.out.println("Would you like to attack? Hit y for yes and any other key for no.");
       
             
       if("y".equals(reader.nextLine())){
           return true;
       }
       
       else{
           return false;}
       }
       else{
           System.out.println("Congrats! You beat the beast!");
           return true;
       }
   }
    
        
    
    @Override
    public String getDifficulty() {
        
        String Diff = "";
        
        if(Difficulty == 1){
            Diff = "easy";
        }
        else if(Difficulty == 2){
            Diff = "medium";
        }
        else if(Difficulty == 3){
            Diff = "hard";
        }
        else if(Difficulty == 4){
            Diff = "boss";
        }
        
        return Diff;
        }

    public void defeated(){
        if (health == 0){
            System.out.println("The dragon has been defeated!");
        }
    }

    public void befriend(boolean won){
        if (won == true){
            System.out.println("Item obtained");
        }
    }       
        
}


