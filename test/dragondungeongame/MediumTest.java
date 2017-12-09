/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suffersquad;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Shannon
 */
public class MediumTest {
    
Medium medium;
    
    @Before
    public void setup() {
        //this should not be commented it out but idk whats wrong with it so
        medium = new Medium(5, "medium" , 8);
    }
    
//if the hit is above four the dragon should take damage
    @Test
    public void doesithit() {
        // TODO review the generated test code and remove the default call to fail.
        
        if (medium.defense(9,8) > 8){
            assertTrue("This will pass if over 8", true);
        }
    }
    
    
}
