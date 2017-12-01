/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragondungeongame;

/**
 *
 * @author Shannon
 */
public class Easy extends Dragon{
    
    import java.util.Random;

public class EasyDragon extends Dragon {
    
    Random rand = new Random();

    public EasyDragon(int dlevel, String dname, treasure dtype) {
        super(dlevel, dname, dtype);
        
       
    }
    
    @Override
    public int attack(int opponent){
        
        int power = rand.nextInt(20)+1;
        
        if((power >= opponent)&& power != opponent) {
            
            return 1;
            
        } 
        else {
            
            return 0;
        }
    }
    
    
}
    
}
