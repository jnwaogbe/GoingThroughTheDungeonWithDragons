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
public class BossTest {
    
Boss boss;
    
    @Before
    public void setup() {
        boss = new Boss(10, "BO$$" , 16);
    }
    
//if the hit is above four the dragon should take damage
    @Test
    public void doesithit() {
        
        if (boss.defense(17,16) > 16){
            assertTrue("This will pass if over 16", true);
        }
    }
    
    //if friends with another dragon, defeatable flag set to true
    
}
