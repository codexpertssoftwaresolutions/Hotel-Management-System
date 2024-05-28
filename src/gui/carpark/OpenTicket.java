package gui.carpark;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import model.MySQL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

public class OpenTicket extends javax.swing.JDialog {

    private static HashMap<String, Integer> vehicleTypeList = new HashMap<>();
    private static HashMap<String, Integer> typePrice = new HashMap<>();

    public OpenTicket(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        arrivalField.setText(arrivalPicker.getSelectedTime().replace(" PM", "").replace(" AM", ""));
        loadVehicleType();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        inputPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        mobileLabel = new javax.swing.JLabel();
        mobileField = new javax.swing.JTextField();
        arrTimeLabel = new javax.swing.JLabel();
        arrivalField = new javax.swing.JTextField();
        spaceLabel = new javax.swing.JLabel();
        spaceField = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox<>();
        feeLabel = new javax.swing.JLabel();
        feeField = new javax.swing.JTextField();
        arrivalPicker = new com.raven.swing.TimePicker();
        buttonPanel = new javax.swing.JPanel();
        placeTicket = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Open a Ticket");

        inputPanel.setLayout(new java.awt.GridLayout(6, 2));

        nameLabel.setText("Customer Name :");
        inputPanel.add(nameLabel);

        nameField.setName(""); // NOI18N
        inputPanel.add(nameField);

        mobileLabel.setText("Mobile No. :");
        inputPanel.add(mobileLabel);
        inputPanel.add(mobileField);

        arrTimeLabel.setText("Arrival Time :");
        inputPanel.add(arrTimeLabel);

        arrivalField.setEditable(false);
        inputPanel.add(arrivalField);

        spaceLabel.setText("Parked Space :");
        inputPanel.add(spaceLabel);
        inputPanel.add(spaceField);

        typeLabel.setText("Vehicle Type :");
        inputPanel.add(typeLabel);

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        typeCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeComboItemStateChanged(evt);
            }
        });
        inputPanel.add(typeCombo);

        feeLabel.setText("Charge Per Hour :");
        inputPanel.add(feeLabel);

        feeField.setEditable(false);
        feeField.setText("0");
        inputPanel.add(feeField);

        arrivalPicker.set24hourMode(true);
        arrivalPicker.setDisplayText(arrivalField);

        buttonPanel.setLayout(new java.awt.BorderLayout());

        placeTicket.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        placeTicket.setText("Place Ticket");
        placeTicket.setMaximumSize(new java.awt.Dimension(96, 50));
        placeTicket.setMinimumSize(new java.awt.Dimension(96, 50));
        placeTicket.setPreferredSize(new java.awt.Dimension(96, 50));
        placeTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeTicketActionPerformed(evt);
            }
        });
        buttonPanel.add(placeTicket, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrivalPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(title)
                .addGap(43, 43, 43)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(arrivalPicker, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void placeTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeTicketActionPerformed

        String name = nameField.getText();
        String mobile = mobileField.getText();
        String space = spaceField.getText();
        String fee = feeField.getText();
        String arrivalTime = arrivalField.getText();
        String typeComboValue = String.valueOf(typeCombo.getSelectedItem());

        if (name.isEmpty()) {
            nameField.grabFocus();
        } else if (mobile.isEmpty()) {
            mobileField.grabFocus();
        } else if (space.isEmpty() || Integer.parseInt(space) > 25 || Integer.parseInt(space) < 1) {
            spaceField.grabFocus();
        } else if (fee.isEmpty()) {
            feeField.grabFocus();
        } else if (typeComboValue == "Select") {
        } else {

            try {
                ResultSet resultSet = MySQL.execute("SELECT * FROM `parking_ticket` WHERE `parked_space`='" + space + "' AND `departure_time` IS NULL");

                if (resultSet.next()) {
                    String Message = "<html><body>"
                            + "<p><b>" + space + "</b> is already booked!</p>"
                            + "</body></html>";

                    JOptionPane.showMessageDialog(
                            null,
                            Message,
                            "Space Unavailable",
                            JOptionPane.ERROR_MESSAGE
                    );

                    spaceField.grabFocus();
                } else {
                    String vehiType = String.valueOf(vehicleTypeList.get(typeComboValue));

                    LocalTime time = LocalTime.parse(arrivalTime, DateTimeFormatter.ofPattern("HH:mm"));
                    LocalDateTime combinedDateTime = LocalDateTime.of(LocalDateTime.now().toLocalDate(), time);

                    String arrtime = combinedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

                    String ticketNumber = now.format(formatter);

                    try {

                        MySQL.execute("INSERT INTO "
                                + "`parking_ticket`(`parking_ticket_id`,`parking_ticket_customer`,`parking_ticket_mobile`,`arrival_time`,`parked_space`,`vehicle_type_id`) "
                                + "VALUES('" + ticketNumber + "','" + name + "','" + mobile + "','" + arrtime + "','" + space + "','" + vehiType + "') ");

                        arrivalPicker.now();
                        nameField.setText("");
                        mobileField.setText("");
                        spaceField.setText("");
                        feeField.setText("");
                        arrivalField.setText(arrivalPicker.getSelectedTime().replace(" PM", "").replace(" AM", ""));
                        typeCombo.setSelectedItem("Select");

                        HashMap<String, Object> parameters = new HashMap<>();

                        parameters.put("Parameter1", name);
                        parameters.put("Parameter2", mobile);
                        parameters.put("Parameter3", typeComboValue);
                        parameters.put("Parameter4", ticketNumber);
                        parameters.put("Parameter5", fee);
                        parameters.put("Parameter6", space);
                        parameters.put("Parameter7", arrtime);

//                String jrxmlFile = "src/gui/carpark/ticket.jrxml";
                        String jasperFile = "src/gui/carpark/ParkingTicket.jasper";

//                    try {
//                        JasperCompileManager.compileReportToFile(jrxmlFile, jasperFile);
//                        System.out.println("Report compiled successfully.");
//                    } catch (JRException e) {
//                        e.printStackTrace();
//                    }
                        try {
                            JasperPrint report = JasperFillManager.fillReport(jasperFile, parameters, new JREmptyDataSource());
                            JasperPrintManager.printReport(report, true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_placeTicketActionPerformed

    private void typeComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeComboItemStateChanged
        setVehicleFee();
    }//GEN-LAST:event_typeComboItemStateChanged

    private void loadVehicleType() {
        try {
            ResultSet resultset = MySQL.execute("SELECT * FROM `vehicle_type`");

            Vector<String> typeVector = new Vector<>();
            typeVector.add("Select");

            while (resultset.next()) {
                typeVector.add(resultset.getString("vehicle_type_name"));
                vehicleTypeList.put(resultset.getString("vehicle_type_name"), resultset.getInt("vehicle_type_id"));
                typePrice.put(resultset.getString("vehicle_type_name"), resultset.getInt("fee"));
            }
            DefaultComboBoxModel model1 = new DefaultComboBoxModel(typeVector);
            typeCombo.setModel(model1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setVehicleFee() {
        String typeComboValue = String.valueOf(typeCombo.getSelectedItem());
        if (typeComboValue == "Select") {
            feeField.setText("0");
        } else {
            String vehiPrice = String.valueOf(typePrice.get(typeComboValue));
            feeField.setText(vehiPrice);
        }
    }

    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OpenTicket dialog = new OpenTicket(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arrTimeLabel;
    private javax.swing.JTextField arrivalField;
    private com.raven.swing.TimePicker arrivalPicker;
    private javax.swing.JPanel background;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JTextField feeField;
    private javax.swing.JLabel feeLabel;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JTextField mobileField;
    private javax.swing.JLabel mobileLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton placeTicket;
    private javax.swing.JTextField spaceField;
    private javax.swing.JLabel spaceLabel;
    private javax.swing.JLabel title;
    private javax.swing.JComboBox<String> typeCombo;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
