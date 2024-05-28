package gui.finance;

import java.util.Vector;
import model.MySQL;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.TableActionCellEditor;
import model.TableActionCellRender;
import model.TableActionEvent;

public class Utility extends javax.swing.JPanel {

    HashMap<String, String> paymentMap = new HashMap<>();
    HashMap<String, String> utilityMap = new HashMap<>();

    public Utility() {
        initComponents();
        setTableAction();
        loadTable();
        loadUtilityTypes();
        loadPaymentTypes();
    }

    private void loadUtilityTypes() {

        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `utility_payment_type`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultset.next()) {
                vector.add(resultset.getString("utility_payment_type_name"));
                utilityMap.put(resultset.getString("utility_payment_type_name"), resultset.getString("utility_payment_type_id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadPaymentTypes() {

        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `payment_method`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultset.next()) {
                vector.add(resultset.getString("method"));
                paymentMap.put(resultset.getString("method"), resultset.getString("payment_method_id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadTable() {

        try {

            ResultSet resultset = MySQL.execute("SELECT * FROM `utility_payment`"
                    + "INNER JOIN `utility_payment_type` ON `utility_payment_type`.`utility_payment_type_id`=`utility_payment`.`utility_payment_id`"
                    + "INNER JOIN `payment_method` ON `payment_method`.`payment_method_id`=`utility_payment`.`payment_method_id`");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultset.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultset.getString("utility_payment_amout"));
                vector.add(resultset.getString("utility_payment_date"));
                vector.add(resultset.getString("utility_payment_type.utility_payment_type_name"));
                vector.add(resultset.getString("payment_method.method"));
                model.addRow(vector);
            }
            
            System.out.println("Total Rows Loaded: " + model.getRowCount());
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private void reset(){
        jTextField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);   
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
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));

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
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.GridLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Utility");

        jLabel2.setText("Amount");

        jLabel3.setText("Utility Type");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Payment Method");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Record Payment");
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
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        add(jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Amount", "Date", "Utility Type", "Payment Method", "#"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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

        String amount = jTextField1.getText();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = now.format(formatter);
        String utilityType = String.valueOf(jComboBox1.getSelectedItem());
        String utilityId = utilityMap.get(utilityType);
        String paymentType = String.valueOf(jComboBox2.getSelectedItem());
        String paymentId = paymentMap.get(paymentType);

        try {

            MySQL.execute("INSERT INTO `utility_payment` "
                    + "(`utility_payment_amout`,`utility_payment_date`,`utility_payment_type_id`,`payment_method_id`) "
                    + "VALUES ('" + amount + "','" + dateTime + "','" + utilityId + "','" + paymentId + "')");
            
            loadTable();
            reset();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
