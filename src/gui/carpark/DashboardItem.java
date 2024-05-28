package gui.carpark;

import java.awt.Color;

public class DashboardItem extends javax.swing.JPanel {

    public DashboardItem(String title, String value,Color color) {
        initComponents();
        this.titleLabel.setText(title);
        this.valueLabel.setText(value);
        this.setBackground(color);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("jLabel1");
        titleLabel.setPreferredSize(new java.awt.Dimension(37, 100));
        titleLabel.setRequestFocusEnabled(false);
        add(titleLabel, java.awt.BorderLayout.PAGE_START);

        valueLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        valueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valueLabel.setText("jLabel2");
        add(valueLabel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
