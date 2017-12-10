package dragondungeongame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
//import javax.swing.Timer;

public class Maze extends JFrame implements ActionListener {

    private final int DEFAULTCHAMBERSIZE = 35;

    //
    private int[][] theMaze;    // the maze, containing chambers
    private JPanel mazePanel;
    private Container cp;
    private long count;
    private MazeListener mazeListener;
    int chamberSize;

    int dx = 0, dy = 0;
    int velx = 0, vely = 0;

    // -------------------------------------------------------------------------
    // inner class MyPanel
    // -------------------------------------------------------------------------
    private class MyPanel extends JPanel implements MouseListener, KeyListener, ActionListener {

        BufferedImage img, img2 = null, east = null, west = null, north = null, south = null;
        Timer t = new Timer(1, this);
        Image front = new ImageIcon("images/Sprites/sprite1.png").getImage();
        Image front1 = new ImageIcon("images/Sprites/sprite2.png").getImage();
        Image front2 = new ImageIcon("images/Sprites/sprite3.png").getImage();
        Image right = new ImageIcon("images/Sprites/sprite4.png").getImage();
        Image right1 = new ImageIcon("images/Sprites/sprite5.png").getImage();
        Image left = new ImageIcon("images/Sprites/sprite6.png").getImage();
        Image left1 = new ImageIcon("images/Sprites/sprite7.png").getImage();
        Image image = front;
        boolean first = false;
        Rectangle r = new Rectangle(35, 35, 40, 40);

        public MyPanel() {
            // where to go now ?

            int noRows = theMaze.length;
            int noColumns = theMaze[0].length;

            chamberSize = DEFAULTCHAMBERSIZE;
            if (Math.max(noRows, noColumns) < 100) {
                chamberSize = DEFAULTCHAMBERSIZE * 2;
            } else if (Math.max(noRows, noColumns) > 200) {
                chamberSize = DEFAULTCHAMBERSIZE / 2;
            }

            t.start();
            setPreferredSize(new Dimension(noColumns * chamberSize, noRows * chamberSize));
            addMouseListener(this);
            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int noRows = theMaze.length;
            int noColumns = theMaze[0].length;
            Color color;

            try {
                img = ImageIO.read(new File("images/DungeonWall1.jpg"));
                img2 = ImageIO.read(new File("images/DungeonWall2.jpg"));

            } catch (IOException ex) {
                Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int r = 0; r < noRows; r++) {
                for (int c = 0; c < noColumns; c++) {
                    int w = theMaze[r][c];
                    int posX = c * chamberSize;
                    int posY = r * chamberSize;

                    if ((w & 0x20) != 0) {
                        color = Color.GREEN;
                    } //g.setColor(Color.green);          // the exit
                    else if ((w & 0x10) != 0) {
                        color = Color.RED;
                    } //g.setColor(Color.red);            // path
                    else {
                        color = Color.ORANGE;
                    }

                    if (color == Color.ORANGE) {
                        g.drawImage(img2, posX, posY, chamberSize, chamberSize, this);

                    } else if (color == Color.GREEN) {
                        g.drawImage(img2, posX, posY, chamberSize, chamberSize, this);
                    } else {
                        g.setColor(color);
                        g.fillRect(posX, posY, chamberSize, chamberSize);
                    }

                    // the walls
                    g.setColor(Color.WHITE);
                    Graphics2D g2 = (Graphics2D) g;

                    int cs = chamberSize - 1;

                    if ((w & 1) == 1) {
                        g2.drawLine(posX, posY, posX + cs, posY);
                    }

                    if ((w & 2) == 2) {
                        g2.drawLine(posX, posY, posX, posY + cs);
                    }

                    if ((w & 4) == 4) {
                        g2.drawLine(posX, posY + cs, posX + cs, posY + cs);
                    }

                    if ((w & 8) == 8) {
                        g2.drawLine(posX + cs, posY, posX + cs, posY + cs);
                    }
                }
            }

            if (image.equals(front)) {
                //dx = chamberSize / 2;
            }
            r.setBounds(dx, dy, 35, 35);

            g.drawImage(image, dx, dy, this);

            //System.out.println("Image pos dx: " + dx + "\nImage pos dy: " + dy);
        }

        public void actionPerformed(ActionEvent e) {
            dx = dx + velx;
            dy = dy + vely;
            repaint();
        }

        public void mouseClicked(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
            // clear old path entries
            int noRows = theMaze.length;
            int noColumns = theMaze[0].length;
            for (int r = 0; r < noRows; r++) {
                for (int c = 0; c < noColumns; c++) {
                    theMaze[r][c] = (byte) (theMaze[r][c] & 0x2f);
                }
            }

            // get mouse position
            int x = e.getX();
            int y = e.getY();
            int col = (int) Math.floor(x / chamberSize);
            int row = (int) Math.floor(y / chamberSize);

            // if a listener is registered: call MazeClicked
            if (mazeListener != null) {
                mazeListener.MazeClicked(row, col);
            } else {
                System.out.println("As long as nothing is registered, a click won't do too much...");
            }
        }

        public void up() {
            vely = -20;
            velx = 0;
//            dx = dx + velx;
//            dy = dx + vely;
        }

        public void down() {
            vely = 20;
            velx = 0;

        }

        public void left() {
            vely = 0;
            velx = -20;

        }

        public void right() {
            vely = 0;
            velx = 20;

        }

        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_UP) {
                if (!checkForWall(dx, dy)) {
                    up();
                }
                image = front2;
            }

            if (key == KeyEvent.VK_DOWN) {
                if ((!checkForWall(dx, dy))) {
                    down();
                }
                image = front1;
            }

            if (key == KeyEvent.VK_LEFT) {
                if ((!checkForWall(dx, dy))) {
                    left();
                }
                image = left;
            }

            if (key == KeyEvent.VK_RIGHT) {
                if ((!checkForWall(dx, dy))) {
                    right();
                }
                image = right;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_UP) {
                image = front1;

            }

            if (key == KeyEvent.VK_DOWN) {
                image = front2;

            }

            if (key == KeyEvent.VK_LEFT) {
                image = left1;
            }

            if (key == KeyEvent.VK_RIGHT) {
                image = right1;

            }

            velx = 0;
            vely = 0;
            dx = r.getBounds().x;
            dy = r.getBounds().y;

            repaint();
        }

        public boolean checkForWall(int x, int y) {
            int noRows = theMaze.length;
            int noColumns = theMaze[0].length;

            for (int r = 0; r < noRows; r++) {
                for (int c = 0; c < noColumns; c++) {
                    if (r == dx && c == dy && (hasNorthWall(r, c) || hasSouthWall(r, c) || hasEastWall(r, c) || hasWestWall(r, c))) {
                        return false;
                    }
                }
            }

            return true;
        }

    }
    // -------------------------------------------------------------------------

    // -------------------------
    // Constructor
    // -------------------------
    public Maze(int r, int c) {
        super("The Maze");
        //t.start();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JButton b1 = new JButton("New Maze");
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        cp.add(b1, BorderLayout.SOUTH);

        generate(r, c);  // generate maze, draw it on panel, pack

        setVisible(true);
    }

    // -----------------------------------------
    // add listener, typically a path generator
    // -----------------------------------------
    public void addMazeListener(MazeListener ml) {
        mazeListener = ml;
    }

    public void showPath(Iterator i) {
        while (i.hasNext()) {
            Coordinate p = (Coordinate) i.next();
            int row = (int) p.row;
            int col = (int) p.column;
            theMaze[row][col] |= (byte) 0x10;
            repaint();
        }
    }

    public int getMazeData(int r, int c) {
        return (theMaze[r][c]);
    }

    public boolean hasNorthWall(int r, int c) {
        return ((getMazeData(r, c) & 1) != 0);
    }

    public boolean hasWestWall(int r, int c) {
        return ((getMazeData(r, c) & 2) != 0);
    }

    public boolean hasSouthWall(int r, int c) {
        return ((getMazeData(r, c) & 4) != 0);
    }

    public boolean hasEastWall(int r, int c) {
        return ((getMazeData(r, c) & 8) != 0);
    }

    public boolean isExit(int r, int c) {
        return ((getMazeData(r, c) & 32) != 0);
    }

    // -------------------------
    // Maze Generation Entry
    // -------------------------
    public boolean generate(int rows, int columns) {
        // initialize: all walls up, path=false => 0x0f
        theMaze = new int[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                theMaze[r][c] = 0x0f;
            }
        }

        // pick a start point
        int startR = (int) Math.floor(Math.random() * rows);
        int startC = (int) Math.floor(Math.random() * rows);
        count = 0;

        // and generate
        boolean done = false;
        try {
            generateRec(startR, startC, 0);
            // set exit point to 0,0
            theMaze[0][0] |= 0x20;      // 0x20: exit
            mazePanel = new MyPanel();      // create and add new panel
            done = true;
        } catch (Exception er) {
            mazePanel = new JPanel();
            mazePanel.setPreferredSize(new Dimension(500, 300));
            mazePanel.add(new Label("Sorry, size is too big: Stack Overflow"));
            done = false;
        } finally {
            // add panel to frame
            if (mazePanel != null) {
                cp.remove(mazePanel);
            }
            cp.add(mazePanel, BorderLayout.CENTER);
            pack();
            repaint();
        }
        return false;
    }

    // -------------------------
    // Recursive Maze Generation
    // -------------------------
    private void generateRec(int r, int c, int direction) {
        // tear down wall towards source direction
        switch (direction) {
            case 1:
                theMaze[r][c] -= 4;
                break;
            case 2:
                theMaze[r][c] -= 8;
                break;
            case 4:
                theMaze[r][c] -= 1;
                break;
            case 8:
                theMaze[r][c] -= 2;
                break;
        }
        count++;        // another chamber processed.

        // where to go now ?
        int noRows = theMaze.length;
        int noColumns = theMaze[0].length;

        // base case 1: all chambers finished
        if (count == noRows * noColumns) {
            return;
        }

        // recursive case: while there are walkable directions: walk
        while (true) {
            // find walkable directions
            boolean dir1, dir2, dir4, dir8;
            dir1 = dir2 = dir4 = dir8 = false;
            if (r > 0 && (theMaze[r - 1][c] == 0x0f)) {
                dir1 = true;
            }
            if (c > 0 && (theMaze[r][c - 1] == 0x0f)) {
                dir2 = true;
            }
            if (r < noRows - 1 && (theMaze[r + 1][c] == 0x0f)) {
                dir4 = true;
            }
            if (c < noColumns - 1 && (theMaze[r][c + 1] == 0x0f)) {
                dir8 = true;
            }

            // base case 2: no walkable directions left
            if ((dir1 | dir2 | dir4 | dir8) == false) {
                break;
            }

            boolean picked = false;
            do {
                int d = (int) Math.floor(Math.random() * 4); // direction 0-3
                switch (d) {
                    case 0:
                        if (dir1) {
                            picked = true;
                            theMaze[r][c] -= 1;
                            generateRec(r - 1, c, 1);
                            dir1 = false;
                            break;
                        }
                    case 1:
                        if (dir2) {
                            picked = true;
                            theMaze[r][c] -= 2;
                            generateRec(r, c - 1, 2);
                            dir2 = false;
                            break;
                        }
                    case 2:
                        if (dir4) {
                            picked = true;
                            theMaze[r][c] -= 4;
                            generateRec(r + 1, c, 4);
                            dir4 = false;
                            break;
                        }
                    case 3:
                        if (dir8) {
                            picked = true;
                            theMaze[r][c] -= 8;
                            generateRec(r, c + 1, 8);
                            dir8 = false;
                            break;
                        }
                }
            } while (!picked);
        }
        // base case2n cont'd: no more walkable directions left
/*
         for (int i = 0; i < theMaze.length; i++) {
         for (int j = 0; j < theMaze[i].length; j++) {
         System.out.print(theMaze[i][j] + " ");
         }
         System.out.println();
         }
         System.out.println("-------------------------------");
         return;
        
        
         */
    }

    // ---------------------------
    // toString: returns maze data
    // ---------------------------
    public String toString() {
        int noRows = theMaze.length;
        int noColumns = theMaze[0].length;

        String s = "";
        for (int r = 0; r < noRows; r++) {
            for (int c = 0; c < noColumns; c++) {
                s = s + theMaze[r][c] + " ";
            }
            s = s + "\n";
        }
        return (s);
    }

    // ---------------------------------
    // Action Performed
    // --------------------------------
    public void actionPerformed(ActionEvent e) {
        int noRows = theMaze.length;
        int noColumns = theMaze[0].length;
        generate(noRows, noColumns);

    }
}
