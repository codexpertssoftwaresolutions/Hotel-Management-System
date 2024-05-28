package gui.hr;

import java.util.List;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;

public class Salary extends javax.swing.JPanel {

    HashMap<String, String> salary_info = new HashMap<>();

    public Salary() {
        initComponents();
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.setDefaultRenderer(Object.class, render);
        jTable1.setAutoCreateRowSorter(true);
        loadDepartment();
    }

    private void loadEmployeeTable(String department) {
        String query = "SELECT * FROM payroll \n"
                + "INNER JOIN employee ON (employee.nic=payroll.employee_nic)\n"
                + "INNER JOIN employee_role ON (employee_role.employee_role_id=employee.employee_role_id) "
                + "INNER JOIN department ON (employee_role.department_id=department.department_id) WHERE `department_name`='" + department + "'";

        try {
            java.sql.ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("payroll_id"));
                vector.add(resultSet.getString("employee_fname") + " " + resultSet.getString("employee_lname"));
                vector.add(resultSet.getString("employee_nic"));
                vector.add(resultSet.getString("basic_salary"));
                vector.add(resultSet.getString("epf"));
                vector.add(resultSet.getString("etf"));
                vector.add(resultSet.getString("taxes"));
                vector.add(resultSet.getString("net_salary"));
                vector.add(resultSet.getString("payment_date"));

                model.addRow(vector);
                jTable1.setModel(model);

            }

        } catch (Exception e) {
            HRDashBoard.log1.warning(e.toString());
        }
    }

//    private void generatePaySheets() {
//        List<Employee> employees = PayrollTableModel.getEmployees();
//        PaysheetGenerator.generatePaysheets(employees);
//    }
    private void loadDepartment() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `department`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {
                vector.add(resultSet.getString("department_name"));
//                departments.put(resultSet.getString("department_name"), resultSet.getInt("department_id"));
                DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
                departmentCombo.setModel(model);
            }

        } catch (Exception e) {
            HRDashBoard.log1.warning(e.toString());
        }
    }

    private void calculatePayroll() {

        String department = String.valueOf(departmentCombo.getSelectedItem());
        List<Employee> employees = DataRetrieval.getEmployeesByDepartment(department);
        SalaryCalculator.calculateSalaries(employees);
        PayrollUpdater.updatePayrollRecords(employees);
        loadEmployeeTable(department);

    }

    private void generatePaySheets() {
        try {
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("Parameter1", String.valueOf(salary_info.get("payroll_id")));
            parameters.put("Parameter2", String.valueOf(salary_info.get("full_name")));
            parameters.put("Parameter3", String.valueOf(salary_info.get("nic")));
            parameters.put("Parameter4", String.valueOf(salary_info.get("basic_salary")));
            parameters.put("Parameter5", String.valueOf(salary_info.get("epf")));
            parameters.put("Parameter6", String.valueOf(salary_info.get("etf")));
            parameters.put("Parameter7", String.valueOf(salary_info.get("taxes")));
            parameters.put("Parameter8", String.valueOf(salary_info.get("net_salary")));
            parameters.put("Parameter9", String.valueOf(salary_info.get("pay_date")));

            JREmptyDataSource datasource = new JREmptyDataSource();
            JasperPrint report = JasperFillManager.fillReport("src/reports/paysheets.jasper", parameters, datasource);
            JasperViewer.viewReport(report, false);
        } catch (Exception e) {
            HRDashBoard.log1.warning(e.toString());
        }
    }

    private void printPaysheets() {
        try {
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("Parameter1", String.valueOf(salary_info.get("payroll_id")));
            parameters.put("Parameter2", String.valueOf(salary_info.get("full_name")));
            parameters.put("Parameter3", String.valueOf(salary_info.get("nic")));
            parameters.put("Parameter4", String.valueOf(salary_info.get("basic_salary")));
            parameters.put("Parameter5", String.valueOf(salary_info.get("epf")));
            parameters.put("Parameter6", String.valueOf(salary_info.get("etf")));
            parameters.put("Parameter7", String.valueOf(salary_info.get("taxes")));
            parameters.put("Parameter8", String.valueOf(salary_info.get("net_salary")));
            parameters.put("Parameter9", String.valueOf(salary_info.get("pay_date")));

            JREmptyDataSource datasource = new JREmptyDataSource();
            JasperPrint jasperPrint = JasperFillManager.fillReport("src/reports/paysheets.jasper", parameters, datasource);
            JasperPrintManager.printReport(jasperPrint, true);
        } catch (Exception e) {
            HRDashBoard.log1.warning(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        departmentCombo = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        calculateSalary = new javax.swing.JButton();
        generatePaysheet = new javax.swing.JButton();
        printPaysheet = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(987, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage Payroll");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(764, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setPreferredSize(new java.awt.Dimension(987, 50));

        jLabel2.setText("Department");

        departmentCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(departmentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(712, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(departmentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setPreferredSize(new java.awt.Dimension(987, 50));

        calculateSalary.setText("Calculate Salary");
        calculateSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateSalaryActionPerformed(evt);
            }
        });

        generatePaysheet.setText("Generate Paysheets");
        generatePaysheet.setEnabled(false);
        generatePaysheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePaysheetActionPerformed(evt);
            }
        });

        printPaysheet.setText("Print Paysheets");
        printPaysheet.setEnabled(false);
        printPaysheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printPaysheetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(calculateSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(generatePaysheet, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(printPaysheet, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(generatePaysheet, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(printPaysheet, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                    .addComponent(calculateSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Payroll_id", "Full Name", "NIC", "Basic Salary", "EPF(8%)", "ETF(12%)", "Taxes", "Net Salary", "Payment Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void printPaysheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printPaysheetActionPerformed
        printPaysheets();

    }//GEN-LAST:event_printPaysheetActionPerformed

    private void calculateSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateSalaryActionPerformed
        calculatePayroll();

    }//GEN-LAST:event_calculateSalaryActionPerformed

    private void generatePaysheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePaysheetActionPerformed


    }//GEN-LAST:event_generatePaysheetActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int row = jTable1.getSelectedRow();
        if (evt.getClickCount() == 2) {
            generatePaysheet.setEnabled(true);
            printPaysheet.setEnabled(true);

            String payroll_id = String.valueOf(jTable1.getValueAt(row, 0));
            String full_name = String.valueOf(jTable1.getValueAt(row, 1));
            String nic = String.valueOf(jTable1.getValueAt(row, 2));
            String basic_salary = String.valueOf(jTable1.getValueAt(row, 3));
            String epf = String.valueOf(jTable1.getValueAt(row, 4));
            String etf = String.valueOf(jTable1.getValueAt(row, 5));
            String taxes = String.valueOf(jTable1.getValueAt(row, 6));
            String net_salary = String.valueOf(jTable1.getValueAt(row, 7));
            String payment_date = String.valueOf(jTable1.getValueAt(row, 8));

            salary_info.put("payroll_id", payroll_id);
            salary_info.put("full_name", full_name);
            salary_info.put("nic", nic);
            salary_info.put("basic_salary", basic_salary);
            salary_info.put("epf", epf);
            salary_info.put("etf", etf);
            salary_info.put("taxes", taxes);
            salary_info.put("net_salary", net_salary);
            salary_info.put("pay_date", payment_date);

            generatePaySheets();

        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calculateSalary;
    private javax.swing.JComboBox<String> departmentCombo;
    private javax.swing.JButton generatePaysheet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton printPaysheet;
    // End of variables declaration//GEN-END:variables
}
