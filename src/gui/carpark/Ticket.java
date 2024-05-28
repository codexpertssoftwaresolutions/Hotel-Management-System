package gui.carpark;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class Ticket extends javax.swing.JPanel {

    private javax.swing.JFrame mainFrame;

    public Ticket(javax.swing.JFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        loadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ticketDetailsTable = new javax.swing.JTable();
        topPanel = new javax.swing.JPanel();
        addTicket = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        sortPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(670, 444));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(670, 444));
        setLayout(new java.awt.BorderLayout());

        ticketDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ticket No.", "Vehicle Type", "Fee", "Sold Count", "Income (Rs.)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ticketDetailsTable.setRowHeight(40);
        jScrollPane1.setViewportView(ticketDetailsTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        topPanel.setMinimumSize(new java.awt.Dimension(10, 150));

        addTicket.setBackground(new java.awt.Color(51, 255, 102));
        addTicket.setForeground(new java.awt.Color(255, 255, 255));
        addTicket.setText("Add Ticket");
        addTicket.setMaximumSize(new java.awt.Dimension(93, 30));
        addTicket.setMinimumSize(new java.awt.Dimension(93, 30));
        addTicket.setPreferredSize(new java.awt.Dimension(93, 30));
        addTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTicketActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Ticket Management");

        sortPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(105, 100));
        sortPanel.add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(105, 100));
        sortPanel.add(jPanel2, java.awt.BorderLayout.LINE_END);
        sortPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(sortPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(topPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void addTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTicketActionPerformed
        AddTicket addTicket = new AddTicket(mainFrame, true);
        addTicket.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loadTable();
            }

        });
        addTicket.setVisible(true);
    }//GEN-LAST:event_addTicketActionPerformed

    private void loadTable() {
        String query = "SELECT"
                + " `vehicle_type_id`,"
                + " `vehicle_type_name`,"
                + " `fee`,"
                + " (SELECT COUNT(parking_ticket_id)"
                + " FROM `parking_ticket`"
                + " WHERE `parking_ticket`.`vehicle_type_id`=`vehicle_type`.`vehicle_type_id`) AS `sold_count`"
                + " FROM `vehicle_type`";

        try {
            ResultSet resultset = MySQL.execute(query);

            DefaultTableModel model = (DefaultTableModel) ticketDetailsTable.getModel();

            model.setRowCount(0);

            while (resultset.next()) {
                int fee = resultset.getInt("fee");
                int souldCount = resultset.getInt("sold_count");
                
                Vector row = new Vector();
                row.add(resultset.getString("vehicle_type_id"));
                row.add(resultset.getString("vehicle_type_name"));
                row.add(fee);
                row.add(souldCount);
                row.add(fee*souldCount);
                model.addRow(row);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTicket;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel sortPanel;
    private javax.swing.JTable ticketDetailsTable;
    private javax.swing.JLabel title;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
