package dragondungeongame;

/**
 *
 * @author Me
 */

import java.util.Random;

public class MediumDragon extends Dragon {
    
    Random rand = new Random();

    public MediumDragon(int dlevel, String dname, Treasure dtype) {
        super(dlevel, dname, dtype);
        
       
    }
    
    @Override
    public int attack(int opponent){
        
        int power = rand.nextInt(35)+1;
        
        if((power >= opponent)&& power != opponent) {
            
            return 1;
            
        } 
        else {
            
            return 0;
        }
    }
    
    
}
