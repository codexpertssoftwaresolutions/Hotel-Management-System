package gui;

import gui.food.FoodAndBeverageDashBoard;
import gui.gym.GymSectionDashBoard;
import gui.finance.FinanceDashBoard;
import gui.bar.BarSectionDashBoard;
import gui.hall.HallManagementDashBoard;
import gui.room.RoomManagementDashBoard;
import gui.hr.HRDashBoard;
import gui.carpark.CarParkDashBoard;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import model.MySQL;
import java.sql.ResultSet;
import java.util.HashMap;
import raven.toast.Notifications;

public class Login extends javax.swing.JFrame {

    private String department;

    public Login(String departmentt) {
        initComponents();
        this.department = departmentt;
    }

    public Login() {
        this.department = "";
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userNameInputField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rememberPwCheck = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        logInBtn = new javax.swing.JButton();
        passwordInputField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Frontdesk 1.png"))); // NOI18N
        jLabel1.setFocusable(false);
        jLabel1.setOpaque(true);
        jPanel2.add(jLabel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Log In");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Welcome back!");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Username");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Password");

        rememberPwCheck.setForeground(new java.awt.Color(0, 0, 0));
        rememberPwCheck.setText("Remember Password");
        rememberPwCheck.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Froget Password?");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        logInBtn.setBackground(new java.awt.Color(0, 153, 153));
        logInBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logInBtn.setForeground(new java.awt.Color(255, 255, 255));
        logInBtn.setText("Log In");
        logInBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logInBtn.setFocusPainted(false);
        logInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(logInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(328, 328, 328))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(userNameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(passwordInputField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(rememberPwCheck)
                            .addGap(119, 119, 119)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rememberPwCheck)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addComponent(logInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInBtnActionPerformed

        if (department.isEmpty()) {
            DepartmentSelection departmentSelection = new DepartmentSelection();
            departmentSelection.setVisible(true);
            this.dispose();
            return;
        }

        String userName, password;
        userName = userNameInputField.getText();
        password = String.valueOf(passwordInputField.getPassword());

        if (userName.isEmpty()) {
            userNameInputField.grabFocus();
            System.out.println(department);
//            Notifications.getInstance().show(Notifications.Type.ERROR, "Please Enter Your Username");
        } else if (password.isEmpty()) {
            passwordInputField.grabFocus();
//            Notifications.getInstance().show(Notifications.Type.ERROR, "Please Enter Your Password");
        } else {
            try {

                HashMap<String, Integer> stusSubList = new HashMap<>();

                ResultSet resultset = MySQL.execute("SELECT * FROM `admin` WHERE `username`='" + userName + "' AND `password`='" + password + "'");
                if (resultset.next()) {

//                    if (rememberPwCheck.isSelected()) {
//                        
//                    } else {
//                        
//                    }
                    switch (department) {
                        case "hr":
                            gotoDashBoard(new HRDashBoard(resultset));
                            break;
                        case "finance":
                            gotoDashBoard(new FinanceDashBoard(resultset));
                            break;
                        case "hall":
                            gotoDashBoard(new HallManagementDashBoard(resultset));
                            break;
                        case "bar":
                            gotoDashBoard(new BarSectionDashBoard(resultset));
                            break;
                        case "room":
                            gotoDashBoard(new RoomManagementDashBoard(resultset));
                            break;
                        case "food":
                            gotoDashBoard(new FoodAndBeverageDashBoard(resultset));
                            break;
                        case "carpark":
                            gotoDashBoard(new CarParkDashBoard(resultset));
                            break;
                        case "gym":
                            gotoDashBoard(new GymSectionDashBoard(resultset));
                            break;
                        default:
                            gotoDashBoard(new DepartmentSelection());
                    }

                } else {
//                    Notifications.getInstance().show(Notifications.Type.ERROR, "Invalid Username or Password");
                    userNameInputField.grabFocus();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_logInBtnActionPerformed

    private void gotoDashBoard(javax.swing.JFrame Dashboard) {
        Dashboard.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton logInBtn;
    private javax.swing.JPasswordField passwordInputField;
    private javax.swing.JCheckBox rememberPwCheck;
    private javax.swing.JTextField userNameInputField;
    // End of variables declaration//GEN-END:variables
}
