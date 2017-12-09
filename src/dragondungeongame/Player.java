package dragondungeongame;

import java.util.Random;

/**
 *
 * @author Shannon
 */
public class Player implements Character {

    public String name;
    public int health = 60;
    public int attackPower = 5;
    public int defense = 5;
    public Random rand = new Random();
    public boolean isAlive = true;

    
    public Player(String name) {
        this.name = name;
 
    }
    
    public void greeting(){
        System.out.println( "\n\n" + name + "! Your health is " + health + " \n Your power is " + attackPower + 
                " \n Your defense is " + defense);
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAttack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDefense() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int attack(int Defense) {
        int hit;        
        int attackNum = rand.nextInt(this.attackPower+10)+this.attackPower;
        
        if(attackNum > Defense){
            hit = attackNum - Defense;
            
        }
        else{
            hit = 0;
        }
        
        return hit;
    
    
    }

    @Override
    public String getDifficulty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


       


    @Override
    public void takeDamage(int damage){
        health = health - damage;
        if(health < 1){
            isAlive = false;
        }

        
    }

    

    
    

    
}
