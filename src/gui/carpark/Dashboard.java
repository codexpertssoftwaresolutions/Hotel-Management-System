package gui.carpark;

import java.awt.Color;
import java.sql.ResultSet;
import model.MySQL;

public class Dashboard extends javax.swing.JPanel {

    public Dashboard() {
        initComponents();
        loadDetails();
    }

    private void loadDetails() {

        String query = "SELECT COUNT(parking_ticket_id) AS `sold_count`,"
                + " SUM(`fee`) AS `income` FROM `parking_ticket`"
                + " INNER JOIN `vehicle_type` ON `parking_ticket`.`vehicle_type_id`=`vehicle_type`.`vehicle_type_id`"
                + " WHERE departure_time";

        String query2 = "SELECT COUNT(parking_ticket_id) AS `parked_count`"
                + " FROM `parking_ticket` WHERE `departure_time` IS NULL";

        try {
            ResultSet resultset = MySQL.execute(query);

            if (resultset.next()) {

                DashboardItem dashboardItem = new DashboardItem("Total Sold Tickets", resultset.getString("sold_count"), Color.yellow);
                dataViewPanel.add(dashboardItem);
                DashboardItem dashboardItem1 = new DashboardItem("Total Income (Rs.)", resultset.getString("income"), Color.CYAN);
                dataViewPanel.add(dashboardItem1);
            }

        } catch (Exception ex) {

        }

        try {
            ResultSet resultset = MySQL.execute(query2);

            if (resultset.next()) {

                DashboardItem dashboardItem = new DashboardItem("Total Sold Tickets", resultset.getString("parked_count"), Color.PINK);
                dataViewPanel.add(dashboardItem);

            }

        } catch (Exception ex) {

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        areaPanel = new javax.swing.JPanel();
        dataViewPanel = new javax.swing.JPanel();

        jLabel5.setText("jLabel5");

        setLayout(new java.awt.BorderLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Dashboard");
        add(title, java.awt.BorderLayout.PAGE_START);

        dataViewPanel.setLayout(new java.awt.GridLayout(1, 3, 50, 0));

        javax.swing.GroupLayout areaPanelLayout = new javax.swing.GroupLayout(areaPanel);
        areaPanel.setLayout(areaPanelLayout);
        areaPanelLayout.setHorizontalGroup(
            areaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );
        areaPanelLayout.setVerticalGroup(
            areaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(areaPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(dataViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        add(areaPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaPanel;
    private javax.swing.JPanel dataViewPanel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
