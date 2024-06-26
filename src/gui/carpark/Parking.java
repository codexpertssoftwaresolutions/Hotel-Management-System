package gui.carpark;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import model.TableActionCellEditor;
import model.TableActionCellRender;
import model.TableActionEvent;

public class Parking extends javax.swing.JPanel {

    private javax.swing.JFrame mainFrame;

    public Parking(javax.swing.JFrame mainFrame) {
        initComponents();
        setTableAction();
        this.mainFrame = mainFrame;
        loadTable();
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
        parkingDetailsTable.getColumnModel().getColumn(9).setCellRenderer(new TableActionCellRender());
        parkingDetailsTable.getColumnModel().getColumn(9).setCellEditor(new TableActionCellEditor(event));

        // parkingDetailsTable - > table variable name
        // 3 -> action button column index
        // onEdit -> when click pencil icon
        // onView -> when click eye icon
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        parkingDetailsTable = new javax.swing.JTable();
        topPanel = new javax.swing.JPanel();
        closeTicket = new javax.swing.JButton();
        openTicket = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        sortPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        parkingDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ticket No.", "Customer Name", "Mobile", "Vehicle Type", "Arrival Time", "Departure Time", "Parked Space", "Spent Hours", "Fee (Rs.)", "#"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        parkingDetailsTable.setRowHeight(40);
        jScrollPane1.setViewportView(parkingDetailsTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        topPanel.setMinimumSize(new java.awt.Dimension(10, 150));
        topPanel.setPreferredSize(new java.awt.Dimension(10, 150));

        closeTicket.setBackground(new java.awt.Color(255, 102, 51));
        closeTicket.setForeground(new java.awt.Color(255, 255, 255));
        closeTicket.setText("Close Ticket");
        closeTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeTicketActionPerformed(evt);
            }
        });

        openTicket.setBackground(new java.awt.Color(51, 255, 102));
        openTicket.setForeground(new java.awt.Color(255, 255, 255));
        openTicket.setText("Open Ticket");
        openTicket.setMaximumSize(new java.awt.Dimension(93, 30));
        openTicket.setMinimumSize(new java.awt.Dimension(93, 30));
        openTicket.setPreferredSize(new java.awt.Dimension(93, 30));
        openTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTicketActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Parking Management");

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
                .addComponent(closeTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(openTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(sortPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(topPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void openTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTicketActionPerformed
        OpenTicket ot = new OpenTicket(mainFrame, true);
        ot.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loadTable();
            }

        });
        ot.setVisible(true);
    }//GEN-LAST:event_openTicketActionPerformed

    private void closeTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeTicketActionPerformed
        CloseTicket ct = new CloseTicket(mainFrame, true);
        ct.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loadTable();
            }

        });
        ct.setVisible(true);
    }//GEN-LAST:event_closeTicketActionPerformed

    private void loadTable() {
        String query = "SELECT * FROM `parking_ticket`"
                + " INNER JOIN `vehicle_type` ON `vehicle_type`.`vehicle_type_id`=`parking_ticket`.`vehicle_type_id`"
                + " ORDER BY `parking_ticket_id` DESC";

        try {
            ResultSet resultset = MySQL.execute(query);

            DefaultTableModel model = (DefaultTableModel) parkingDetailsTable.getModel();

            model.setRowCount(0);

            while (resultset.next()) {

                String arrivalTime = resultset.getString("arrival_time");
                String departureTime = resultset.getString("departure_time");

                if (departureTime == null) {

                    Vector row = new Vector();
                    row.add(resultset.getString("parking_ticket_id"));
                    row.add(resultset.getString("parking_ticket_customer"));
                    row.add(resultset.getString("parking_ticket_mobile"));
                    row.add(resultset.getString("vehicle_type_name"));
                    row.add(arrivalTime);
                    row.add("-");
                    row.add(resultset.getString("parked_space"));
                    row.add("-");
                    row.add("-");
                    model.addRow(row);

                } else {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime arrTime = LocalDateTime.parse(arrivalTime, formatter);
                    LocalDateTime depTime = LocalDateTime.parse(departureTime, formatter);

                    Duration duration = Duration.between(arrTime, depTime);
                    int spentHours = (int) duration.toHours();

                    if (spentHours == 0) {
                        spentHours = 1;
                    }

                    String total = String.valueOf(resultset.getInt("fee") * spentHours);

                    Vector row = new Vector();
                    row.add(resultset.getString("parking_ticket_id"));
                    row.add(resultset.getString("parking_ticket_customer"));
                    row.add(resultset.getString("parking_ticket_mobile"));
                    row.add(resultset.getString("vehicle_type_name"));
                    row.add(arrivalTime);
                    row.add(departureTime);
                    row.add(resultset.getString("parked_space"));
                    row.add(spentHours);
                    row.add(total);
                    model.addRow(row);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeTicket;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openTicket;
    private javax.swing.JTable parkingDetailsTable;
    private javax.swing.JPanel sortPanel;
    private javax.swing.JLabel title;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
