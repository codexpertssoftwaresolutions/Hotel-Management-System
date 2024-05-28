package gui.carpark;

public class SpaceView extends javax.swing.JPanel {

    public SpaceView(String ticketNumber,String parkedSpace,String vehicleType) {
        initComponents();
        this.vehicleType.setText(vehicleType);
        this.ticketNumber.setText(ticketNumber);
        this.parkedSpace.setText(parkedSpace);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parkedSpace = new javax.swing.JLabel();
        ticketNumber = new javax.swing.JLabel();
        vehicleType = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        setLayout(new java.awt.BorderLayout());

        parkedSpace.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        parkedSpace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parkedSpace.setText("Parked Space");
        add(parkedSpace, java.awt.BorderLayout.CENTER);

        ticketNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ticketNumber.setText("Ticket Number");
        add(ticketNumber, java.awt.BorderLayout.PAGE_END);

        vehicleType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vehicleType.setText("Vehicle Type");
        add(vehicleType, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel parkedSpace;
    private javax.swing.JLabel ticketNumber;
    private javax.swing.JLabel vehicleType;
    // End of variables declaration//GEN-END:variables
}
