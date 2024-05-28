package gui.finance;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.SwingUtilities;
import model.DrawerHeader;

public class FinanceDashBoard extends javax.swing.JFrame {

    private DrawerController drawer;

    public FinanceDashBoard(ResultSet loggedUser) {
        initComponents();
        drawer = Drawer.newDrawer(this)
                .header(new DrawerHeader())
                .enableScroll(true)
                .addChild(new DrawerItem("Dashboard").build())
                .addChild(new DrawerItem("Utility").build())
                .addChild(new DrawerItem("ExtraExpenses").build())
                .addChild(new DrawerItem("Salary").build())
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
                })
                .build();

        Dashboard dashboard = new Dashboard();
        bottomPanel.add(dashboard, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(this);
        repaint();

    }

    public FinanceDashBoard() {
        initComponents();
        drawer = Drawer.newDrawer(this)
                .header(new DrawerHeader())
                .enableScroll(true)
                .addChild(new DrawerItem("Dashboard").build())
                .addChild(new DrawerItem("Utility").build())
                .addChild(new DrawerItem("ExtraExpenses").build())
                .addChild(new DrawerItem("Salary").build())
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
                })
                .build();

        Dashboard dashboard = new Dashboard();
        bottomPanel.add(dashboard, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(this);
        repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        menuButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(935, 630));
        setPreferredSize(new java.awt.Dimension(935, 630));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        background.setLayout(new java.awt.BorderLayout());

        bottomPanel.setLayout(new javax.swing.BoxLayout(bottomPanel, javax.swing.BoxLayout.LINE_AXIS));
        background.add(bottomPanel, java.awt.BorderLayout.CENTER);

        topPanel.setPreferredSize(new java.awt.Dimension(666, 30));

        menuButton.setText("|||");
        menuButton.setBorder(null);
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
                .addGap(0, 905, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        background.add(topPanel, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(background);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        toggleMenu();
    }//GEN-LAST:event_menuButtonActionPerformed

    private void toggleMenu() {
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }

    private void setActiveTab(int tab) { // tab -> clicked tab index
        bottomPanel.removeAll();

        if (tab == 0) {
            Dashboard dashboard = new Dashboard();
            bottomPanel.add(dashboard, BorderLayout.CENTER);
        } else if (tab == 1) {
            Utility utility = new Utility();
            bottomPanel.add(utility, BorderLayout.CENTER);
        } else if (tab == 2) {
            ExtraExpenses extraExpenses = new ExtraExpenses();
            bottomPanel.add(extraExpenses, BorderLayout.CENTER);
        } else if (tab == 3) {
            Salary salary = new Salary();
            bottomPanel.add(salary, BorderLayout.CENTER);
        }

        drawer.hide();

        SwingUtilities.updateComponentTreeUI(this);
        repaint();
    }

    public static void main(String args[]) {
        FlatMacLightLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinanceDashBoard().setVisible(true);
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
