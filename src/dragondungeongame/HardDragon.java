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
public class HardDragon extends Dragon{
    
    boolean defeated = false;
    boolean friend = false;
    
    

    public HardDragon( String dname) {
        super(dname);
        this.health = 40;
        this.attackPower = 17;
        this.defense = 17;
        
    }
    
    
       @Override
   public String getDifficulty(){
       
       return "hard";
   
   }
    
    
    @Override
    public int attack(int playerDefense) {
              
     int hit;        
        int attackNum = rand.nextInt(25)+17;
        
        if(attackNum > playerDefense){
            hit = attackNum - playerDefense;
            
        }
        else{
            hit = 0;
        }
        
        return hit;
    
    
    }
}
