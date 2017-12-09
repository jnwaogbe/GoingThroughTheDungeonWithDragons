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
public class PlayerTest {
    
Player player;
    
    @Before
    public void setup() {
        player = new Player(10, "player" , 10);
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = player;
        String expResult = "player";
        String result = instance.getName();
    }

    /**
     * Test of getHealth method, of class Player.
     */
    @Test
    public void testGetHealth() {
        System.out.println("getHealth");
        Player instance = player;
        int expResult = 30;
        int result = instance.getHealth();
        assertEquals(expResult, result);
    }


    @Test
    public void testAttack() {
        System.out.println("attack");
        int powermult = 0;
        Player instance = null;
        int expResult = 0;
        int result = instance.attack(powermult);
        assertEquals(expResult, result);
    }

    /**
     * Test of defense method, of class Player.
     */
    @Test
    public void testDefense() {
        System.out.println("defense");
        int attack = 0;
        int guard = 0;
        Player instance = null;
        int expResult = 0;
        int result = instance.defense(attack, guard);
        assertEquals(expResult, result);
    }
    
    //if player won the word game, attack was increased
    @Test
    public void gameWonAttackIncrease(){
    
    }
    
    //if collected item/level passed, defense increases
    @Test
    public void levelUpDefenseIncrease(){
    
    }
    
    //if friend flag set to true, addition to health
    @Test
    public void friendFlagHealthAddition(){
    
    }
    
}
