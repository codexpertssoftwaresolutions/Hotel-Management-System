package gui.hr;

import java.util.Vector;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class ActiveEmployees extends javax.swing.JFrame {
    
    private AddNewAdministrator addnew;
    
    public void setAddnew(AddNewAdministrator addnew) {
        this.addnew = addnew;
    }
    
    public ActiveEmployees() {
        initComponents();
        loadEmployeeTable();
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);        
        jTable1.setDefaultRenderer(Object.class, render);
        jTable1.setAutoCreateRowSorter(true);
    }
    
    private void loadEmployeeTable() {
        String query = "SELECT * FROM `employee` \n"
                + "INNER JOIN `employee_role` ON (employee.employee_role_id=employee_role.employee_role_id)\n"
                + "INNER JOIN  `department` ON (employee_role.department_id=department.department_id) \n"
                + "INNER JOIN `position` ON (employee_role.position_id=`position`.position_id)\n"
                + "INNER JOIN `status` ON (employee.status_id=`status`.status_id) WHERE `status`.`status`='Active'; ";
        
        try {
            java.sql.ResultSet resultSet = MySQL.execute(query);
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("nic"));
                vector.add(resultSet.getString("employee_fname"));
                vector.add(resultSet.getString("employee_lname"));
//                vector.add(resultSet.getString("employee_address"));
                vector.add(resultSet.getString("employee_email"));
                vector.add(resultSet.getString("employee_mobile"));
                vector.add(resultSet.getString("position.position_name"));
                vector.add(resultSet.getString("department.department_name"));
//                vector.add(resultSet.getString("employee.employee_join_date"));
//                vector.add(resultSet.getString("employee_role.basic_salary"));
                vector.add(resultSet.getString("status.status"));
                
                model.addRow(vector);
                jTable1.setModel(model);
                
            }
            
        } catch (Exception e) {
            HRDashBoard.log1.warning(e.toString());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 480));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIC", "First Name", "Last Name", "Email", "Mobile", "Position", "Department", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(35);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.PAGE_END);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Active Employees");

        jButton1.setText("Print all Active Employees");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("()");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        
        if (evt.getClickCount() == 2) {
            String nic = String.valueOf(jTable1.getValueAt(row, 0));
            String fname = String.valueOf(jTable1.getValueAt(row, 1));
            String lname = String.valueOf(jTable1.getValueAt(row, 2));
//            String address = String.valueOf(jTable1.getValueAt(row, 3));
            String mobile = String.valueOf(jTable1.getValueAt(row, 4));
            String email = String.valueOf(jTable1.getValueAt(row, 3));
            String position = String.valueOf(jTable1.getValueAt(row, 5));
            String department = String.valueOf(jTable1.getValueAt(row, 6));
//            String joined_date = String.valueOf(jTable1.getValueAt(row, 8));
//            String salary = String.valueOf(jTable1.getValueAt(row, 9));
            String status = String.valueOf(jTable1.getValueAt(row, 7));
            
            if (addnew != null) {
                addnew.setFullName(fname + " " + lname);
                addnew.setEmail(email);
                addnew.setPosition(position);
                addnew.setDepartment(department);
                addnew.setNic(nic);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(ActiveEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActiveEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActiveEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActiveEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActiveEmployees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
