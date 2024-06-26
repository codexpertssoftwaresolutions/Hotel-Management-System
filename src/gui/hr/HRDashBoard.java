package gui.hr;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javaswingdev.drawer.Drawer;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.util.logging.SimpleFormatter;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.util.logging.Logger;
import model.DrawerHeader;
import java.util.logging.FileHandler;

public class HRDashBoard extends javax.swing.JFrame {

    private DrawerController drawer;
    public static Logger log1;
    public static FileHandler handler1;
    
    
    static {
        try {
            log1 = Logger.getLogger("log1");
            handler1 = new FileHandler("Hrlog.txt",true);
            handler1.setFormatter(new SimpleFormatter());
            log1.addHandler(handler1);
        } catch (Exception e) {
        e.printStackTrace();
        }
    
    }

    public HRDashBoard(ResultSet loggedUser) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        drawer = Drawer.newDrawer(this)
                .header(new DrawerHeader())
                .enableScroll(true)
                .addChild(new DrawerItem("Dashboard").build())
                .addChild(new DrawerItem("Manage Employees").build())
                .addChild(new DrawerItem("Manage Payroll").build())
                .addChild(new DrawerItem("Manage Attendance").build())
                .addChild(new DrawerItem("Manage Administrators").build())
                .addFooter(new DrawerItem("Log out").build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int i, DrawerItem di) {
                        if (i != 4) { // logout index
                            setActiveTab(i);
                        } else {
                            System.out.println("Log out");
                        }
                    }
                }).build();

        Dashboard dashboard = new Dashboard();
        bottomPanel.add(dashboard, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(this);
        repaint();
    }

    public HRDashBoard() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        drawer = Drawer.newDrawer(this)
                .header(new DrawerHeader())
                .enableScroll(true)
                .addChild(new DrawerItem("Dashboard").build())
                .addChild(new DrawerItem("Manage Employees").build())
                .addChild(new DrawerItem("Manage Payroll").build())
                .addChild(new DrawerItem("Manage Attendance").build())
                .addChild(new DrawerItem("Manage Administrators").build())
                .addFooter(new DrawerItem("Log out").build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int i, DrawerItem di) {
                        if (i != 6) { // logout index
                            setActiveTab(i);
                        } else {
                            System.out.println("Log out");
                        }
                    }
                }).build();

        Dashboard dashboard = new Dashboard();
        bottomPanel.add(dashboard, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(this);
        repaint();
    }

    private void setActiveTab(int tab) { // tab -> clicked tab index
        bottomPanel.removeAll();

        if (tab == 0) {
            Dashboard dashboard = new Dashboard();
            bottomPanel.add(dashboard, BorderLayout.CENTER);
        } else if (tab == 1) {
            Employees employees = new Employees();
            bottomPanel.add(employees, BorderLayout.CENTER);
        } else if (tab == 2) {
            Salary salary = new Salary();
            bottomPanel.add(salary, BorderLayout.CENTER);
        } else if (tab == 3) {
            Attendance attendance = new Attendance();
            bottomPanel.add(attendance, BorderLayout.CENTER);
        } else if (tab == 4) {
            Administrators admin = new Administrators();
            bottomPanel.add(admin, BorderLayout.CENTER);
        }

        drawer.hide();

        SwingUtilities.updateComponentTreeUI(this);
        repaint();
    }

    private void toggleMenu() {
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        menuButton = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        background.setLayout(new java.awt.BorderLayout());

        topPanel.setPreferredSize(new java.awt.Dimension(666, 30));

        menuButton.setText("|||");
        menuButton.setBorder(null);
        menuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        menuButton.setPreferredSize(new java.awt.Dimension(50, 50));
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 540, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        background.add(topPanel, java.awt.BorderLayout.PAGE_START);

        bottomPanel.setLayout(new javax.swing.BoxLayout(bottomPanel, javax.swing.BoxLayout.LINE_AXIS));
        background.add(bottomPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(background);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        toggleMenu();
    }//GEN-LAST:event_menuButtonActionPerformed

    public static void main(String args[]) {
        FlatMacLightLaf.setup();
//        UIManager.put("Button.arc", 150);
        UIManager.put("TextComponent.arc", 999);
        UIManager.put("Component.arc", 999);
        UIManager.put("Component.arrowType", "triangle");
        UIManager.put("TextComponent.innerFocusWidth", 1);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HRDashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton menuButton;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
