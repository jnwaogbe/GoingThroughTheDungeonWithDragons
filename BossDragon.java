/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragondungeongame;

/**
 *
 * @author Me
 */
public class BossDragon extends Dragon{
    
    boolean defeated = false;
    boolean defeatable = false;

    public BossDragon( String dname) {
        super(dname);
        this.health = 75;
        this.attackPower = 30;
        this.defense = 25;
    }
    
       @Override
   public String getDifficulty(){
       
       return "boss";
   
   }
    
    
    
    @Override
    public int attack(int playerDefense) {
              
     int hit;        
        int attackNum = rand.nextInt(50)+30;
        
        if(attackNum > playerDefense){
            hit = attackNum - playerDefense;
            
        }
        else{
            hit = 0;
        }
        
        return hit;
    
    
    }
}
