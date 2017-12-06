package dragondungeongame;
/**
 *
 * @author Shannon
 */
public class Dragon implements Character {
    
    private int level;
    private String name;
    private Treasure type;
    private boolean friend;
    private int health;
    private int attack;
    
    public Dragon(int dlevel, String dname, Treasure dtype) {
    
        level = dlevel;
        name = dname;
        type = dtype;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefense() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int attack(int powermult) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int defense(int guard) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public String getDifficulty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void befriend() {
        friend = false;
    }
    
    public boolean isFriend() {
        return friend;
    }

}