/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragondungeongame;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Shannon
 */
public class HardTest {
    
Hard hard;
    
    @Before
    public void setup() {
        hard = new Hard(6, "hard" , 12);
    }
    
//if the hit is above four the dragon should take damage
    @Test
    public void doesithit() {
        // TODO review the generated test code and remove the default call to fail.
        
        if (hard.defense(13,12) > 12){
            assertTrue("This will pass if over 12", true);
        }
    }
    
    
}
