package gui.hr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class Attendance extends javax.swing.JPanel {

   

    public Attendance() {
        initComponents();
        jTextField1.grabFocus();
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.setDefaultRenderer(Object.class, render);
        jTable1.setAutoCreateRowSorter(true);
    }

    private void reset() {
        jTextField1.setText("");
        jTextField1.grabFocus();
        jLabel2.setText("Name");
        jLabel3.setText("Email");
        jLabel4.setText("Date");

    }

    private void loadAttendanceTable() {
        String query = "SELECT * FROM `attendance`";

        try {
            java.sql.ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("attendance_id"));
                vector.add(resultSet.getString("employee_nic"));
                vector.add(resultSet.getString("check_in_time"));
                vector.add(resultSet.getString("check_out_time"));

                model.addRow(vector);
                jTable1.setModel(model);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadUserDetails(String employee_code, String date) {

        try {
            java.sql.ResultSet rs = MySQL.execute("SELECT * FROM `employee` WHERE `nic`='" + employee_code + "'");

            if (rs.next()) {
                String fname = rs.getString("employee_fname");
                String lname = rs.getString("employee_lname");
                String email = rs.getString("employee_email");
                rs.getString("employee_fname");

                jLabel2.setText(fname + " " + lname);
                jLabel3.setText(email);
                jLabel4.setText(date);

            }
        } catch (Exception e) {
            HRDashBoard.log1.warning(e.toString());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(300, 385));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setMargin(new java.awt.Insets(2, 15, 2, 15));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel2.setText("Name");

        jLabel3.setText("Email");

        jLabel4.setText("Date");

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(58, 58, 58)
                .addComponent(jButton1)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Attend_id", "Employee NIC", "Check-in", "Check-out"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage Attendance");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 562, Short.MAX_VALUE)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

        String employeecode = jTextField1.getText();
        Date d = new Date();
        SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm:ss");
        String format_date = sdf_date.format(d);
        String format_time = sdf_time.format(d);
        String date_time = format_date + " " + format_time;
        loadUserDetails(employeecode, format_date);

        try {
            if (employeecode.length() == 12) {
                java.sql.ResultSet rs2 = MySQL.execute("SELECT * FROM `employee` WHERE `nic`='" + employeecode + "'");

                if (rs2.next()) {
                    java.sql.ResultSet rs = MySQL.execute("SELECT `check_in_time` FROM `attendance` WHERE `employee_nic`='" + employeecode + "'");

                    //checks if there is a checkintime
                    if (rs.next()) {//mark leave
                        //check whether it is the same day
                        java.sql.ResultSet rs3 = MySQL.execute("SELECT `check_in_time` FROM `attendance` WHERE `employee_nic`='" + employeecode + "' AND `check_in_time` LIKE '" + format_date + "%'");

                        if (rs3.next()) {//same day
                            MySQL.execute("UPDATE `attendance` SET `check_out_time`='" + date_time + "' WHERE `employee_nic`='" + employeecode + "'");
                            MySQL.execute("UPDATE `employee` SET `working_status_id`='2' WHERE `employee_nic`='" + employeecode + "'");
                            reset();
                            loadAttendanceTable();

                        } else {//Not the same day(next day)
                            MySQL.execute("INSERT INTO `attendance`(`employee_nic`,`check_in_time`) VALUES('" + employeecode + "','" + date_time + "')");
                            MySQL.execute("UPDATE `employee` SET `working_status_id`='1' WHERE `employee_nic`='" + employeecode + "'");
                            reset();
                            loadAttendanceTable();
                        }

                    } else {//mark attendance for a new collague

                        MySQL.execute("INSERT INTO `attendance`(`employee_nic`,`check_in_time`) VALUES('" + employeecode + "','" + date_time + "')");
                        MySQL.execute("UPDATE `employee` SET `working_status_id`='1' WHERE `employee_nic`='" + employeecode + "'");
                        reset();
                        loadAttendanceTable();

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Passcode", "Invalid", JOptionPane.WARNING_MESSAGE);

                }

            }

        } catch (Exception e) {
            HRDashBoard.log1.warning(e.toString());
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
