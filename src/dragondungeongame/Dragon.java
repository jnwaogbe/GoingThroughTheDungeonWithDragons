package dragondungeongame;
/**
 *
 * @author Shannon
 */
public class Dragon implements Character {
    
    int level;
    String name;
    Treasure type;
    
    public Dragon(int dlevel, String dname, Treasure dtype) {
    
        level = dlevel;
        name = dname;
        type = dtype;
    }

    @Override
    public String name(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String difficulty(String level) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int health(int ihealth) {
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
    
}
