package gui.hr;

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import model.MySQL;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Employees extends javax.swing.JPanel {

    public HashMap<String, String> tableSelection = new HashMap<>();

    public Employees() {
        initComponents();
        loadDepartment();
        loadEmployeeTable();
        jButton2.setEnabled(false);
        jTextField2.putClientProperty("JComponent.roundRect", true);
        jButton1.putClientProperty("JButton.buttonType", "roundRect");
        jButton2.putClientProperty("JButton.buttonType", "roundRect");
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.setDefaultRenderer(Object.class, render);
        jTable1.setAutoCreateRowSorter(true);

    }

    public void callreload() {
        reset();
    }

    private void reset() {
        jButton2.setEnabled(false);
        jTable1.clearSelection();

    }

    private void loadDepartment() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `department`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {
                vector.add(resultSet.getString("department_name"));
                DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
                jComboBox3.setModel(model);
            }

        } catch (Exception e) {
            HRDashBoard.log1.warning(e.toString());
        }
    }

    private void loadEmployeeTable() {
        String query = "SELECT * FROM `employee` "
                + "INNER JOIN `employee_role` ON (employee.employee_role_id=employee_role.employee_role_id) "
                + "INNER JOIN  `department` ON (employee_role.department_id=department.department_id) "
                + "INNER JOIN `position` ON (employee_role.position_id=`position`.position_id) "
                + "INNER JOIN `status` ON (employee.status_id=`status`.status_id) ";

        String nic = jTextField2.getText();
        String department = String.valueOf(jComboBox3.getSelectedItem());

        if (nic.isEmpty() && department.equals("Select")) {//0-0
            query += "";

        } else if (!nic.isEmpty() && department.equals("Select")) {//0-0
            query += "WHERE `nic` LIKE '" + nic + "%'";

        } else if (nic.isEmpty() && !department.equals("Select")) {//0-0
            query += "WHERE `department_name` = '" + department + "'";

        } else if (!nic.isEmpty() && !department.equals("Select")) {//1-0
            query += "WHERE `nic` LIKE '" + nic + "%' AND `department_name`='" + department + "'";

        }

        try {
            java.sql.ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("nic"));
                vector.add(resultSet.getString("employee_fname"));
                vector.add(resultSet.getString("employee_lname"));
                vector.add(resultSet.getString("employee_address"));
                vector.add(resultSet.getString("employee_mobile"));
                vector.add(resultSet.getString("employee_email"));
                vector.add(resultSet.getString("position.position_name"));
                vector.add(resultSet.getString("department.department_name"));
                vector.add(resultSet.getString("employee.employee_join_date"));
                vector.add(resultSet.getString("employee_role.basic_salary"));
                vector.add(resultSet.getString("status.status"));

                model.addRow(vector);
                jTable1.setModel(model);

            }

        } catch (Exception e) {
            HRDashBoard.log1.warning(e.toString());
        }
    }

    private int hashMapLoaded(int row, int n) {
        String nic = String.valueOf(jTable1.getValueAt(row, 0));
        String fname = String.valueOf(jTable1.getValueAt(row, 1));
        String lname = String.valueOf(jTable1.getValueAt(row, 2));
        String address = String.valueOf(jTable1.getValueAt(row, 3));
        String mobile = String.valueOf(jTable1.getValueAt(row, 4));
        String email = String.valueOf(jTable1.getValueAt(row, 5));
        String position = String.valueOf(jTable1.getValueAt(row, 6));
        String department = String.valueOf(jTable1.getValueAt(row, 7));
        String joined_date = String.valueOf(jTable1.getValueAt(row, 8));
        String salary = String.valueOf(jTable1.getValueAt(row, 9));
        String status = String.valueOf(jTable1.getValueAt(row, 10));

        tableSelection.put("nic", nic);
        tableSelection.put("fname", fname);
        tableSelection.put("lname", lname);
        tableSelection.put("address", address);
        tableSelection.put("mobile", mobile);
        tableSelection.put("email", email);
        tableSelection.put("position", position);
        tableSelection.put("depart", department);
        tableSelection.put("join_date", joined_date);
        tableSelection.put("salary", salary);
        tableSelection.put("status", status);

        if (n == 2) {//edit employee
            AddNewEmployee ade = new AddNewEmployee(tableSelection);
            ade.setVisible(true);
            ade.setE(this);
        } else {//single click to got ot Resign
            Resignation resign = new Resignation(tableSelection);
            resign.setVisible(true);
        }

        return n;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(799, 115));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage Employees");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
        jPanel2.setPreferredSize(new java.awt.Dimension(1680, 50));
        jPanel2.setLayout(new java.awt.GridLayout(1, 14, 50, 40));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField2.setMargin(new java.awt.Insets(2, 30, 2, 6));
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField2MouseExited(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField2);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox3.setPreferredSize(new java.awt.Dimension(72, 15));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox3);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton1.setText("New Employee");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton2.setText("Resign Employee");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setText("Reload");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(64, 64, 64))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jLabel2.setText("Double Click to Update to Field");
        jPanel1.add(jLabel2, java.awt.BorderLayout.LINE_END);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIC", "First Name", "Last Name", "Address", "Mobile", "Email", "Position", "Department", "Hired date", "Basic Salary", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        jTextField2.setText("");

    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        jTextField2.setText("Search by Name");
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseEntered

    private void jTextField2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        AddNewEmployee n_employee = new AddNewEmployee();
        n_employee.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int count = 1;
        int row = jTable1.getSelectedRow();
        hashMapLoaded(row, count);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int count = evt.getClickCount();
        int button = evt.getButton();

        int row = jTable1.getSelectedRow();

        if (button == 1 && count == 1) {
            jButton2.setEnabled(true);

        } else if (count == 2) {
            hashMapLoaded(row, count);

        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        loadEmployeeTable();

    }//GEN-LAST:event_jTextField2KeyReleased

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        // TODO add your handling code here:
        loadEmployeeTable();
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
        loadEmployeeTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
