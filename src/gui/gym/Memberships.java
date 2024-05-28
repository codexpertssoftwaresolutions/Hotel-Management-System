package gui.gym;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import model.TableActionCellEditor;
import model.TableActionCellRender;
import model.TableActionEvent;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Memberships extends javax.swing.JPanel {

    HashMap<String, String> gymPackageMap = new HashMap<>();
    HashMap<String, String> membershipTypeMap = new HashMap<>();
    HashMap<String, String> statusMap = new HashMap<>();

    public Memberships() {
        initComponents();
        loadTable();
        setTableAction();
        loadGymPackages();
        loadMembershipTypes();
        loadStatus();
    }

    private void loadGymPackages() {

        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `gym_package`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultset.next()) {
                vector.add(resultset.getString("gym_package_name"));
                gymPackageMap.put(resultset.getString("gym_package_name"), resultset.getString("gym_package_id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadMembershipTypes() {

        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `gym_membership_type`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultset.next()) {
                vector.add(resultset.getString("gym_membership_type_name"));
                membershipTypeMap.put(resultset.getString("gym_membership_type_name"), resultset.getString("gym_membership_type_id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadStatus() {

        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `status`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultset.next()) {
                vector.add(resultset.getString("status"));
                statusMap.put(resultset.getString("status"), resultset.getString("status_id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox3.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadTable() {

        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `gym_membership`"
                    + "INNER JOIN `customer` ON `customer`.`customer_nic`=`gym_membership`.`customer_nic`"
                    + "INNER JOIN `gym_package` ON `gym_package`.`gym_package_id`=`gym_membership`.`gym_package_id`"
                    + "INNER JOIN `gym_membership_type` ON `gym_membership_type`.`gym_membership_type_id`=`gym_membership`.`gym_membership_type_id`"
                    + "INNER JOIN `status` ON `status`.`status_id`=`gym_membership`.`status_id`");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultset.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultset.getString("customer.customer_nic"));
                vector.add(resultset.getString("gym_package.gym_package_name"));
                vector.add(resultset.getString("gym_membershi_start"));
                vector.add(resultset.getString("gym_membership_end"));
                vector.add(resultset.getString("gym_membership_type.gym_membership_type_name"));
                vector.add(resultset.getString("status.status"));
                model.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void reset() {
        jTextField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
    }

    private void setTableAction() {
        TableActionEvent event = new TableActionEvent() {

            @Override
            public void onEdit(int row) { // row -> clicked row index
                System.out.println(row);
            }

            @Override
            public void onView(int row) {
                System.out.println(row);
            }
        };
        jTable1.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.GridLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Membership Panel");

        jLabel2.setText("Customer Nic");

        jLabel3.setText("Gym Package");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Start Date");

        jLabel5.setText("End Date");

        jLabel6.setText("Membership Type");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Status");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Add Membership");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jButton1))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        add(jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Customer NIC", "Gym Package", "Meb Start Date", "Meb End Date", "Membership Type", "Status", "#"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String NIC = jTextField1.getText();
        String gymPackType = String.valueOf(jComboBox1.getSelectedItem());
        String gymPackID = gymPackageMap.get(gymPackType);
        String membershipType = String.valueOf(jComboBox2.getSelectedItem());
        String membershipID = membershipTypeMap.get(membershipType);
        String statusType = String.valueOf(jComboBox3.getSelectedItem());
        String statusID = statusMap.get(statusType);
        String fromDate = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());
        String toDate = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser2.getDate());

        if (NIC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter NIC number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (gymPackType.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select package type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (membershipType.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select membership type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (statusType.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select status type", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                ResultSet resultset = MySQL.execute("SELECT * FROM `customer` "
                        + "WHERE `customer_nic`='" + NIC + "'");

                if (resultset.next()) {
                    MySQL.execute("INSERT INTO `gym_membership` "
                            + "(`customer_nic`,`gym_package_id`,`gym_membershi_start`,`gym_membership_end`,`gym_membership_type_id`,`status_id`) "
                            + "VALUES ('" + NIC + "','" + gymPackID + "','" + fromDate + "','" + toDate + "','" + membershipID + "','" + statusID + "')");
                    loadTable();
                    reset();
                    JOptionPane.showMessageDialog(this, "Membership Added", "Success", JOptionPane.INFORMATION_MESSAGE);

                    String path = "src/gui/gym/hotelmanagementgym.jasper";

                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("Parameter1", NIC);
                    parameters.put("Parameter2", fromDate);
                    parameters.put("Parameter3", toDate);
                    parameters.put("Parameter4", gymPackType);
                    parameters.put("Parameter5", membershipType);
                    parameters.put("Parameter6", statusType);

                    JREmptyDataSource datasource = new JREmptyDataSource();

                    JasperPrint jasperPrint = JasperFillManager.fillReport(path, parameters, datasource);

                    JasperViewer.viewReport(jasperPrint, false);

                } else {
                    JOptionPane.showMessageDialog(this, "Customer NIC is not registered", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
