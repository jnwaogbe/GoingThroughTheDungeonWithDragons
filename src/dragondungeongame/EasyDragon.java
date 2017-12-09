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
public class EasyDragon extends Dragon{
    
    
    
    

    public EasyDragon( String dname) {
        super(dname);
        this.health = 10;
        this.attackPower = 5;
        this.defense = 6;
        
    }
    
    
    
     
    @Override
   public String getDifficulty(){
       
       return "easy";
   
   }
   
 
   
  
    
    @Override
    public int attack(int playerDefense) {
              
     int hit;        
        int attackNum = rand.nextInt(10)+5;
        
        if(attackNum > playerDefense){
            hit = attackNum - playerDefense;
            
        }
        else{
            hit = 0;
        }
        
        return hit;
    
    
    }
}
