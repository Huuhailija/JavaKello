
import java.awt.AWTException;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Timer;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Teemu
 */
public class Frame extends javax.swing.JFrame {

    
    Image image = Toolkit.getDefaultToolkit().getImage("Images/heart.png");
    
    /**
     * Creates new form Frame
     */
    public Frame() {
        windowTransparency();
        initComponents();
               
        new Timer(1000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Date date = new Date();
                DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
                DateFormat dft = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.getDefault());
                clockLabel.setText(df.format(date) + " " + dft.format(date)); 

            }
        }).start();
        
        if (SystemTray.isSupported()) {
            final PopupMenu popup = new PopupMenu();
            final TrayIcon trayIcon = new TrayIcon(image, "treyicon");
            final SystemTray tray = SystemTray.getSystemTray();
            
            //Create menuitems.
            MenuItem exit = new MenuItem("Exit");
            MenuItem timeFormat = new MenuItem("Set time format");
            
            // Add them to popups.
            popup.add(timeFormat);
            popup.add(exit);
            
            trayIcon.setPopupMenu(popup);
            
            // Make exit actionListener.
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    SystemTray.getSystemTray().remove(trayIcon);
                    System.exit(0);
                }
            });
            
            List<String> optionList = new ArrayList<String>();
            optionList.add("US");
            optionList.add("UK");
            optionList.add("FRANCE");
            optionList.add("JAPAN");
            Object[] options = optionList.toArray();
            
            
            timeFormat.addActionListener((ActionEvent e) -> {
                Object value = JOptionPane.showInputDialog(null, "Country",
                        "Select display format.",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                
                int index = optionList.indexOf(value);
                System.out.println(index);
                switch (index) {
                    case 0:
                        Locale.setDefault(Locale.US);
                        break;
                    case 1:
                        Locale.setDefault(Locale.UK);
                        break;
                    case 2:
                        Locale.setDefault(Locale.FRANCE);
                        break;
                    case 3:
                        Locale.setDefault(Locale.JAPAN);
                        break;
                    default:
                        break;
                }
                
            });
            
                        
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                
            }
                    
        }
        
        
        
        
    
    }
                
    public void windowTransparency(){
        
        // determinate if gpu supports transparency.
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        
        // if not, exit
        
        if(!device.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT)) {
            dispose();
        }
        
        Frame.setDefaultLookAndFeelDecorated(true);
       
        // Make window transparent.
        setUndecorated(true);
        setBackground(new Color(0,0,0,0));
        // get display screen info and coordinates for setting location.
        Rectangle box = device.getDefaultConfiguration().getBounds();
        int x = (int) box.getMaxX() - 400;
        int y = (int) box.getMaxY() - 125;
        setLocation(x,y);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clockLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jFrame");

        clockLabel.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clockLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {                
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clockLabel;
    // End of variables declaration//GEN-END:variables
}
