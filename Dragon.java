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


import java.util.Random;

public class Dragon {
    
    public int level;
    public String name;
    public treasure type;
    private int state = 0;
    Random rand = new Random();
    
    public Dragon(int dlevel, String dname, treasure dtype){
        
        level = dlevel;
        name = dname;
        type = dtype;
    }
    
    public void greeting(){
        System.out.println("Beware Traveller! I am the guardian of what you seek. My name is " + name + " .");
        
    }
    
    public int attack(int opponent){
        
       int power = 0;
       return power;
        
    }
    
    public void sleep(){
        
        state = 0;
                
    }
    
    public void waken(){
        state = 1;
    }
    
    
    
}
