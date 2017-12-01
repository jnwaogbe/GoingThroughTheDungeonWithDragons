package dragondungeongame;

import java.util.Random;

/**
 *
 * @author Shannon
 * BO$$
 */
public class BossDragon extends Dragon{
    
    Random rand = new Random();

    public BossDragon(int dlevel, String dname, Treasure dtype) {
        super(dlevel, dname, dtype);
        
       //what
    }
    
    @Override
    public int attack(int opponent){
        
        int power = rand.nextInt(75)+1;
        
        if((power >= opponent)&& power != opponent) {
            
            return 0;
            
        } 
        else if(power + 10 <= opponent){
            return 1;
        }
        else {            
            return 0;
        }
    }
    
    


}
