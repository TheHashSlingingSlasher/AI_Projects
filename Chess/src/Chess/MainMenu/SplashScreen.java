/*
 * Name: Alec Farfan, Jiwon Yoo, Luis Pena, Wenbo Yang
 * Date: 03/27/15
 * Purpose: Chess Splash Page
 */

package Chess.MainMenu;

// Import libraries
import Chess.Serializable.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class SplashScreen extends JPanel{
   private int cnt = 0;
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.black);
        this.setVisible(true);
        Color a = new Color(109,53,26);
        Color b = new Color(240,220,130);
        
        g.setFont( new Font( "Serif", Font.BOLD, 100));
        g.setColor(new Color(220,220,220));
        g.drawString("CHESS", 300,100);
        
        g.setFont( new Font( "Serif", Font.BOLD, 30));
        g.setColor(new Color(220,220,220));
        g.drawString("Press Enter ...", 375,550);
                
        int y = 120;
        for(int i=0;i<8;i++){
            int l = 45, w = 45, x = 291;
            for(int j=0;j<4;j++){
                g.setColor(a);
                g.fillRect(x,y,l,w);
                //timer
                g.setColor(b);
                g.fillRect(x+l,y,l,w);
                x += l*2;
            }
            y += l+1;
            Color temp = a;
            a = b;
            b = temp;
        }
        
         KeyListener listener = new KeyListener() {
            @Override
                public void keyTyped(KeyEvent ke) {
            }
            @Override
                public void keyPressed(KeyEvent ke) {
                cnt ++;
                if (ke.getKeyCode() == KeyEvent.VK_ENTER && cnt == 1) {
                    //StartInterface screen = new StartInterface();
                    //LoginInterface screen = new LoginInterface();
                    JDialog select_game = new JDialog();
                    select_game.setLayout(new FlowLayout());
                    select_game.setTitle("Select Gametype");
                    select_game.setMinimumSize(new java.awt.Dimension(420, 220));
                    select_game.setPreferredSize(new java.awt.Dimension(420, 220));
                    select_game.setResizable(false);
                    
                    JLabel pvp_label = new JLabel();
                    JLabel pvc_label = new JLabel();
                    pvp_label.setText("Player vs Player");
                    pvp_label.setFont(new Font("Arial",Font.ITALIC,26));
                    pvc_label.setText("Player vs Computer");
                    pvc_label.setFont(new Font("sans-serif",Font.ITALIC,26));
                    
                    
                    final JButton pvp = new JButton();
                    final JButton pvc = new JButton();
                    pvp.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        pvp.setForeground(new Color(109,53,26));
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        pvp.setForeground(Color.BLACK);
                    }
                    });
                    pvp.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            LoginInterface login = new LoginInterface(0);
                            login.isOnePlayer(false);
                            login.setLocationRelativeTo(null);
                            login.setVisible(true);
                        }
                    });
                    
                    pvc.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        pvc.setForeground(new Color(109,53,26));
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        pvc.setForeground(Color.BLACK);
                    }
                    });
                    pvc.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            LoginInterface login = new LoginInterface(1);
                            login.isOnePlayer(true);
                            login.setLocationRelativeTo(null);
                            login.setVisible(true);
                        }
                    });
                    
                    
                    pvp.add(pvp_label);
                    pvc.add(pvc_label);
                    
                    pvp.setPreferredSize(new java.awt.Dimension(400,75));
                    pvc.setPreferredSize(new java.awt.Dimension(400,75));
                    select_game.add(pvp);
                    select_game.add(pvc);
                    select_game.setVisible(true);
                    select_game.setLocationRelativeTo(null);
                    
                } else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE)
                    System.exit(0);
            }
            @Override
                public void keyReleased(KeyEvent ke) {
                }
            };
         
            addKeyListener(listener);
            setFocusable(true);
            requestFocusInWindow();
    }
    
    public static void main(String[] args) {
        // vars used for serialization
        GameStateSerializable record = new GameStateSerializable();
        CreateDataFile data = new CreateDataFile();
        ReadDataFile read_data = new ReadDataFile();
        
        // if option_data file DNE, create initial option_data file
        File gamestateData = new File("gamestate_data.txt");
        
        if(!gamestateData.exists()) {
            data.openFile(record);
            data.addRecords(record);
            data.closeFile();
        } else {
            // read data from a file
            read_data.openFile(record);
            record = read_data.readRecords(record);
            read_data.closeFile();
        }
        
        JFrame plane = new JFrame("Chess Game");
        plane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - plane.getWidth()) / 8);
        int y = (int) ((dimension.getHeight() - plane.getHeight()) / 8);
        plane.setLocation(x, y);
        
        SplashScreen pallet = new SplashScreen();
        plane.add(pallet);
        plane.setSize(950,590);
        plane.setResizable(false);
        plane.setVisible(true);
    }
}
