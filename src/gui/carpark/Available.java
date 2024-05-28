package gui.carpark;

import java.sql.ResultSet;
import java.util.HashMap;
import model.MySQL;

public class Available extends javax.swing.JPanel {

    public Available() {
        initComponents();
        loadSpaces();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        designPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        topPanel.setMaximumSize(new java.awt.Dimension(32767, 3276740));
        topPanel.setPreferredSize(new java.awt.Dimension(100, 40));
        topPanel.setLayout(new java.awt.BorderLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Available Space");
        topPanel.add(title, java.awt.BorderLayout.CENTER);

        add(topPanel, java.awt.BorderLayout.PAGE_START);

        designPanel.setLayout(new java.awt.GridLayout(5, 5, 10, 10));
        add(designPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void loadSpaces() {
        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `parking_ticket`"
                    + " INNER JOIN `vehicle_type` ON `parking_ticket`.`vehicle_type_id`=`vehicle_type`.`vehicle_type_id`"
                    + " WHERE `departure_time` IS NULL ORDER BY `parked_space` ASC");

            HashMap<Integer, SpaceView> spaceMap = new HashMap<>();

            while (resultSet.next()) {
                String ticketNumber = resultSet.getString("parking_ticket_id");
                int space = resultSet.getInt("parked_space");
                String type = resultSet.getString("vehicle_type_name");

                SpaceView spaceView = new SpaceView(ticketNumber, String.valueOf(space), type);
                spaceMap.put(space, spaceView);
            }

            int currentSpace = 1;
            while (currentSpace < 26) {

                if (spaceMap.containsKey(currentSpace)) {
                    SpaceView spaceView = spaceMap.get(currentSpace);
                    designPanel.add(spaceView);
                } else {
                    SpaceView spaceView = new SpaceView("-", String.valueOf(currentSpace), "-");
                    designPanel.add(spaceView);
                }

                currentSpace++;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel designPanel;
    private javax.swing.JLabel title;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
