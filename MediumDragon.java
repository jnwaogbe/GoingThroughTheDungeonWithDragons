package dragondungeongame;

/**
 *
 * @author Me
 */

import java.util.Random;

public class MediumDragon extends Dragon {
    
    boolean defeated = false;
    boolean friend = false;
    
    Random rand = new Random();

    public MediumDragon(String dname) {
        super(dname);
        this.health = 25;
        this.attackPower = 10;
        this.defense = 10;
        
       
    }
    
       @Override
   public String getDifficulty(){
       
       return "medium";
   
   }
    
    
    @Override
    public int attack(int playerDefense) {
              
     int hit;        
        int attackNum = rand.nextInt(17)+10;
        
        if(attackNum > playerDefense){
            hit = attackNum - playerDefense;
            
        }
        else{
            hit = 0;
        }
        
        return hit;
    
    
    }
}
    
    

