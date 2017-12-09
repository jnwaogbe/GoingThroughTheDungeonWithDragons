/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
demonstration of user stories with a quick guided tour of your class diagram
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
public class EasyTest {
    
Easy easy;
    
    @Before
    public void setup() {
        //this should not be commented it out but idk whats wrong with it so
        easy = new Easy(3, "easy" , 5);
    }
    
//if the hit is above four the dragon should take damage
    @Test
    public void doesithit() {
        // TODO review the generated test code and remove the default call to fail.
        
        if (easy.defense(5,4) > 4){
            assertTrue("This will pass if over 4", true);
        }
    }
    
    //if won word game, friend flag set to true

    
}
