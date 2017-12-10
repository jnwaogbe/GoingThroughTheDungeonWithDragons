package dragondungeongame;

import java.util.Random;

/**
 *
 * @author Shannon
 */
public class Player implements Character {

    public String name;
    public int health = 100;
    public int attackPower = 5;
    public int defense = 5;
    public Random rand = new Random();
    public boolean isAlive = true;
    public boolean friend = false;

    
    public Player(String name) {
        this.name = name;
 
    }
    
    public void greeting(){
        if(health<0){
            health = 0;
        }
        System.out.println( "\n\n" + name + "! Your health is " + health + " \n Your power is " + attackPower + 
                " \n Your defense is " + defense);
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    public void setDeath(){
        isAlive = false;
        health = 0;
        System.out.println("\n\nThe dragon has killed you.");
        
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
    public void takeDamage(int damage){
        health = health - damage;
        if(health < 1){
            isAlive = false;
        }        
    }

} 

