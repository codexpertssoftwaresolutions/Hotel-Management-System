package gui.carpark;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.MySQL;

public class AddTicket extends javax.swing.JDialog {

    public AddTicket(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        inputArea = new javax.swing.JPanel();
        typeField = new javax.swing.JTextField();
        feeField = new javax.swing.JTextField();
        lableArea = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        addTicket = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Add a Ticket");

        inputArea.setLayout(new java.awt.GridLayout(2, 2, 0, 20));
        inputArea.add(typeField);
        inputArea.add(feeField);

        lableArea.setLayout(new java.awt.GridLayout(2, 2, 0, 20));

        jLabel1.setText("Vehicle Type :");
        lableArea.add(jLabel1);

        jLabel2.setText("Fee :");
        lableArea.add(jLabel2);

        bottomPanel.setLayout(new java.awt.BorderLayout());

        addTicket.setText("Add Ticket");
        addTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTicketActionPerformed(evt);
            }
        });
        bottomPanel.add(addTicket, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lableArea, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputArea, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputArea, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(lableArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void addTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTicketActionPerformed

        String type = typeField.getText();
        String fee = feeField.getText();

        if (type.isEmpty()) {
            typeField.grabFocus();
        } else if (fee.isEmpty()) {
            feeField.grabFocus();
        } else {
            String query = "INSERT INTO `vehicle_type`(`vehicle_type_name`,`fee`) VALUES('" + type + "','" + fee + "')";
            try {
                ResultSet resultset = MySQL.execute(query);

                if (resultset.next()) {

                    String Message = "<html><body>"
                            + "<p>Operation Successful!</p>"
                            + "</body></html>";

                    JOptionPane.showMessageDialog(
                            null,
                            Message,
                            "Space Unavailable",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    
                    typeField.setText("");
                    feeField.setText("");

                } else {
                    String Message = "<html><body>"
                            + "<p>Something went wrong try again!</p>"
                            + "</body></html>";

                    JOptionPane.showMessageDialog(
                            null,
                            Message,
                            "Space Unavailable",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            } catch (Exception ex) {
                String Message = "<html><body>"
                        + "<p>Something went wrong try again!</p>"
                        + "</body></html>";

                JOptionPane.showMessageDialog(
                        null,
                        Message,
                        "Space Unavailable",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        }
    }//GEN-LAST:event_addTicketActionPerformed

    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddTicket dialog = new AddTicket(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton addTicket;
    private javax.swing.JPanel background;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JTextField feeField;
    private javax.swing.JPanel inputArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel lableArea;
    private javax.swing.JLabel title;
    private javax.swing.JTextField typeField;
    // End of variables declaration//GEN-END:variables
}
