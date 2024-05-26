package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class DepartmentSelection extends javax.swing.JFrame {

    public DepartmentSelection() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        barSection = new javax.swing.JButton();
        hrManagement = new javax.swing.JButton();
        financeSection1 = new javax.swing.JButton();
        hallManagement = new javax.swing.JButton();
        carParking = new javax.swing.JButton();
        roomManagement = new javax.swing.JButton();
        foodAndBeverage = new javax.swing.JButton();
        gymSection = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        markAttendance = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Management System");
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        barSection.setBackground(new java.awt.Color(0, 220, 75));
        barSection.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        barSection.setForeground(new java.awt.Color(255, 255, 255));
        barSection.setText("Bar Section");
        barSection.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barSection.setMaximumSize(new java.awt.Dimension(175, 30));
        barSection.setMinimumSize(new java.awt.Dimension(175, 30));
        barSection.setPreferredSize(new java.awt.Dimension(175, 30));
        barSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barSectionActionPerformed(evt);
            }
        });

        hrManagement.setBackground(new java.awt.Color(0, 163, 255));
        hrManagement.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hrManagement.setForeground(new java.awt.Color(255, 255, 255));
        hrManagement.setText("HR Management");
        hrManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hrManagement.setMaximumSize(new java.awt.Dimension(175, 30));
        hrManagement.setMinimumSize(new java.awt.Dimension(175, 30));
        hrManagement.setPreferredSize(new java.awt.Dimension(175, 30));
        hrManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrManagementActionPerformed(evt);
            }
        });

        financeSection1.setBackground(new java.awt.Color(255, 92, 0));
        financeSection1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        financeSection1.setForeground(new java.awt.Color(255, 255, 255));
        financeSection1.setText("Finance Section");
        financeSection1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        financeSection1.setMaximumSize(new java.awt.Dimension(175, 30));
        financeSection1.setMinimumSize(new java.awt.Dimension(175, 30));
        financeSection1.setPreferredSize(new java.awt.Dimension(175, 30));
        financeSection1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financeSection1ActionPerformed(evt);
            }
        });

        hallManagement.setBackground(new java.awt.Color(163, 60, 244));
        hallManagement.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hallManagement.setForeground(new java.awt.Color(255, 255, 255));
        hallManagement.setText("Hall Management");
        hallManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hallManagement.setMaximumSize(new java.awt.Dimension(175, 30));
        hallManagement.setMinimumSize(new java.awt.Dimension(175, 30));
        hallManagement.setPreferredSize(new java.awt.Dimension(175, 30));
        hallManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hallManagementActionPerformed(evt);
            }
        });

        carParking.setBackground(new java.awt.Color(20, 176, 197));
        carParking.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        carParking.setForeground(new java.awt.Color(255, 255, 255));
        carParking.setText("Car Parking");
        carParking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        carParking.setMaximumSize(new java.awt.Dimension(175, 30));
        carParking.setMinimumSize(new java.awt.Dimension(175, 30));
        carParking.setPreferredSize(new java.awt.Dimension(175, 30));
        carParking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carParkingActionPerformed(evt);
            }
        });

        roomManagement.setBackground(new java.awt.Color(112, 0, 255));
        roomManagement.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        roomManagement.setForeground(new java.awt.Color(255, 255, 255));
        roomManagement.setText("Room Management ");
        roomManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomManagement.setMaximumSize(new java.awt.Dimension(175, 30));
        roomManagement.setMinimumSize(new java.awt.Dimension(175, 30));
        roomManagement.setPreferredSize(new java.awt.Dimension(175, 30));
        roomManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomManagementActionPerformed(evt);
            }
        });

        foodAndBeverage.setBackground(new java.awt.Color(255, 86, 208));
        foodAndBeverage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        foodAndBeverage.setForeground(new java.awt.Color(255, 255, 255));
        foodAndBeverage.setText("Food and Beverage ");
        foodAndBeverage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        foodAndBeverage.setMaximumSize(new java.awt.Dimension(175, 30));
        foodAndBeverage.setMinimumSize(new java.awt.Dimension(175, 30));
        foodAndBeverage.setPreferredSize(new java.awt.Dimension(175, 30));
        foodAndBeverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodAndBeverageActionPerformed(evt);
            }
        });

        gymSection.setBackground(new java.awt.Color(255, 153, 0));
        gymSection.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gymSection.setForeground(new java.awt.Color(255, 255, 255));
        gymSection.setText("Gym Section");
        gymSection.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gymSection.setMaximumSize(new java.awt.Dimension(175, 30));
        gymSection.setMinimumSize(new java.awt.Dimension(175, 30));
        gymSection.setPreferredSize(new java.awt.Dimension(175, 30));
        gymSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gymSectionActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Select Your Department");

        markAttendance.setBackground(new java.awt.Color(255, 0, 46));
        markAttendance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        markAttendance.setForeground(new java.awt.Color(255, 255, 255));
        markAttendance.setText("Mark Attendance");
        markAttendance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        markAttendance.setMaximumSize(new java.awt.Dimension(175, 30));
        markAttendance.setMinimumSize(new java.awt.Dimension(175, 30));
        markAttendance.setPreferredSize(new java.awt.Dimension(175, 30));
        markAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markAttendanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hrManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(financeSection1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(foodAndBeverage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hallManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(carParking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(markAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gymSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(title)
                .addGap(50, 50, 50)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hrManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(financeSection1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hallManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barSection, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carParking, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gymSection, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foodAndBeverage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(markAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void barSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barSectionActionPerformed
        gotoLogIn("bar");
    }//GEN-LAST:event_barSectionActionPerformed

    private void hrManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrManagementActionPerformed
        gotoLogIn("hr");
    }//GEN-LAST:event_hrManagementActionPerformed

    private void financeSection1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financeSection1ActionPerformed
        gotoLogIn("finance");
    }//GEN-LAST:event_financeSection1ActionPerformed

    private void hallManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hallManagementActionPerformed
        gotoLogIn("hall");
    }//GEN-LAST:event_hallManagementActionPerformed

    private void carParkingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carParkingActionPerformed
        gotoLogIn("carpark");
    }//GEN-LAST:event_carParkingActionPerformed

    private void roomManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomManagementActionPerformed
        gotoLogIn("room");
    }//GEN-LAST:event_roomManagementActionPerformed

    private void foodAndBeverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodAndBeverageActionPerformed
        gotoLogIn("food");
    }//GEN-LAST:event_foodAndBeverageActionPerformed

    private void gymSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gymSectionActionPerformed
        gotoLogIn("gym");
    }//GEN-LAST:event_gymSectionActionPerformed

    private void markAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markAttendanceActionPerformed
        MarkAttendance markAttendance =  new MarkAttendance();
        markAttendance.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_markAttendanceActionPerformed

    private void gotoLogIn(String department) {
        Login login = new Login(department);
        login.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentSelection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton barSection;
    private javax.swing.JButton carParking;
    private javax.swing.JButton financeSection1;
    private javax.swing.JButton foodAndBeverage;
    private javax.swing.JButton gymSection;
    private javax.swing.JButton hallManagement;
    private javax.swing.JButton hrManagement;
    private javax.swing.JButton markAttendance;
    private javax.swing.JButton roomManagement;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
