package gui.carpark;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import model.MySQL;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

public class CloseTicket extends javax.swing.JDialog {

    static {
        System.load("C:\\opencv\\build\\java\\x64\\opencv_java490.dll");
    }

    private CameraPanel cameraPanel;
    private VideoCapture camera;

    public CloseTicket(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        cameraPanel = new CameraPanel();
        cameraPanel.setSize(cameraView.getSize().width, cameraView.getSize().height);
        cameraView.add(cameraPanel, BorderLayout.CENTER);

        camera = new VideoCapture(0);
        if (!camera.isOpened()) {
            System.out.println("Error: Camera not accessible");
            return;
        }

        new Timer(33, e -> updateFrame()).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        botttomPanel = new javax.swing.JPanel();
        cameraView = new javax.swing.JPanel();
        detailsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ticketLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        spaceLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        arrivalLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        departureLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rateLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spentLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        paidButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        background.setLayout(new java.awt.BorderLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Close a Ticket");
        background.add(title, java.awt.BorderLayout.PAGE_START);

        cameraView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout cameraViewLayout = new javax.swing.GroupLayout(cameraView);
        cameraView.setLayout(cameraViewLayout);
        cameraViewLayout.setHorizontalGroup(
            cameraViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );
        cameraViewLayout.setVerticalGroup(
            cameraViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        detailsPanel.setLayout(new java.awt.GridLayout(9, 2));

        jLabel1.setText("Ticket No :");
        detailsPanel.add(jLabel1);

        ticketLabel.setText("...");
        detailsPanel.add(ticketLabel);

        jLabel10.setText("Customer Name :");
        detailsPanel.add(jLabel10);

        nameLabel.setText("...");
        detailsPanel.add(nameLabel);

        jLabel17.setText("Vehicle Type");
        detailsPanel.add(jLabel17);

        typeLabel.setText("...");
        detailsPanel.add(typeLabel);

        jLabel15.setText("Parked Space");
        detailsPanel.add(jLabel15);

        spaceLabel.setText("...");
        detailsPanel.add(spaceLabel);

        jLabel13.setText("Arrival Time :");
        detailsPanel.add(jLabel13);

        arrivalLabel.setText("...");
        detailsPanel.add(arrivalLabel);

        jLabel11.setText("Departure Time :");
        detailsPanel.add(jLabel11);

        departureLabel.setText("...");
        detailsPanel.add(departureLabel);

        jLabel8.setText("Charge Per Hour :");
        detailsPanel.add(jLabel8);

        rateLabel.setText("...");
        detailsPanel.add(rateLabel);

        jLabel6.setText("Spent Hours :");
        detailsPanel.add(jLabel6);

        spentLabel.setText("...");
        detailsPanel.add(spentLabel);

        jLabel4.setText("Total Charge :");
        detailsPanel.add(jLabel4);

        totalLabel.setText("...");
        detailsPanel.add(totalLabel);

        buttonPanel.setLayout(new java.awt.BorderLayout());

        paidButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        paidButton.setText("Paid");
        paidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(paidButton, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout botttomPanelLayout = new javax.swing.GroupLayout(botttomPanel);
        botttomPanel.setLayout(botttomPanelLayout);
        botttomPanelLayout.setHorizontalGroup(
            botttomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botttomPanelLayout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addComponent(cameraView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
            .addGroup(botttomPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(detailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(botttomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        botttomPanelLayout.setVerticalGroup(
            botttomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botttomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cameraView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
        );

        background.add(botttomPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(background);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void paidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidButtonActionPerformed
        String departureTime, ticketNumber;

        ticketNumber = ticketLabel.getText();
        departureTime = departureLabel.getText();

        try {

            MySQL.execute("UPDATE `parking_ticket`"
                    + " SET `departure_time`='" + departureTime + "' WHERE `parking_ticket_id`='" + ticketNumber + "'");

            String Message = "<html><body>"
                    + "<p><b>" + ticketNumber + "</b> Payment Updated</p>"
                    + "</body></html>";

            JOptionPane.showMessageDialog(null, Message,"Payment Status" , JOptionPane.INFORMATION_MESSAGE);

            reset();
            
//            if (option == JOptionPane.OK_OPTION) {
//
//            } else if (option == JOptionPane.CANCEL_OPTION) {
//
//            }
//                HashMap<String, Object> parameters = new HashMap<>();
            //                parameters.put("Parameter1", name);
//                parameters.put("Parameter2", mobile);
//                parameters.put("Parameter3", typeComboValue);
//                parameters.put("Parameter4", ticketNum);
//                parameters.put("Parameter5", fee);
//                parameters.put("Parameter6", space);
//                parameters.put("Parameter7", arrtime);
//                String jrxmlFile = "src/gui/carpark/ticket.jrxml";
//                String jasperFile = "src/gui/carpark/ParkingTicket.jasper";
//                    try {
//                        JasperCompileManager.compileReportToFile(jrxmlFile, jasperFile);
//                        System.out.println("Report compiled successfully.");
//                    } catch (JRException e) {
//                        e.printStackTrace();
//                    }
//                try {
//                    JasperPrint report = JasperFillManager.fillReport(jasperFile, parameters, new JREmptyDataSource());
////                        JRTableModelDataSource datasource = new JRTableModelDataSource(jTable1.getModel());
//                    JasperPrintManager.printReport(report, true);
////                        JasperViewer.viewReport(report, false);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_paidButtonActionPerformed

    private void reset() {
        ticketLabel.setText("...");
        nameLabel.setText("...");
        spaceLabel.setText("...");
        arrivalLabel.setText("...");
        departureLabel.setText("...");
        typeLabel.setText("...");
        rateLabel.setText("...");
        spentLabel.setText("...");
        totalLabel.setText("...");
    }

    private void setData(String barcode) {

        ticketLabel.setText("Processing...");

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `parking_ticket`"
                    + " INNER JOIN `vehicle_type` ON `parking_ticket`.`vehicle_type_id`=`vehicle_type`.`vehicle_type_id`"
                    + " WHERE `parking_ticket_id`='" + barcode + "' ");

            if (resultSet.next()) {

                String name, type, mobile, space, arrivalTime, departureTime, total;

                name = resultSet.getString("parking_ticket_customer");
                mobile = resultSet.getString("parking_ticket_mobile");
                space = resultSet.getString("parked_space");
                arrivalTime = resultSet.getString("arrival_time");
                type = resultSet.getString("vehicle_type_name");
                int fee = resultSet.getInt("fee");

                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                departureTime = format.format(date);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime arrTime = LocalDateTime.parse(arrivalTime, formatter);
                LocalDateTime depTime = LocalDateTime.parse(departureTime, formatter);

                Duration duration = Duration.between(arrTime, depTime);
                int spentHours = (int) duration.toHours();

                if (spentHours == 0) {
                    spentHours = 1;
                }
                
                total = String.valueOf(fee * spentHours);

                ticketLabel.setText(barcode);
                nameLabel.setText(name);
                spaceLabel.setText(space);
                arrivalLabel.setText(arrivalTime);
                departureLabel.setText(departureTime);
                typeLabel.setText(type);
                rateLabel.setText(String.valueOf(fee));
                spentLabel.setText(String.valueOf(spentHours));
                totalLabel.setText(total);

            } else {
                ticketLabel.setText("Invalid Barcode");
            }

        } catch (Exception ex) {
            ticketLabel.setText("Invalid Barcode");
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CloseTicket dialog = new CloseTicket(new javax.swing.JFrame(), true);
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

    private class CameraPanel extends JPanel {

        private BufferedImage image;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
            }
        }

        public void setImage(BufferedImage image) {
            this.image = image;
            repaint();
        }
    }

    private void updateFrame() {
        Mat frame = new Mat();
        if (camera.read(frame)) {
            BufferedImage image = matToBufferedImage(frame);
            if (image != null) {
                cameraPanel.setImage(image);
                String barcode = readBarcode(image);
                if (barcode != null) {
                    setData(barcode);
                }
            }
        }
    }

    private BufferedImage matToBufferedImage(Mat frame) {
        int width = frame.width();
        int height = frame.height();
        int channels = frame.channels();

        byte[] sourcePixels = new byte[width * height * channels];
        frame.get(0, 0, sourcePixels);

        BufferedImage image;
        if (frame.channels() == 1) {
            image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        } else {
            image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        }

        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(sourcePixels, 0, targetPixels, 0, sourcePixels.length);

        return image;
    }

    private String readBarcode(BufferedImage image) {
        try {
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arrivalLabel;
    private javax.swing.JPanel background;
    private javax.swing.JPanel botttomPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel cameraView;
    private javax.swing.JLabel departureLabel;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton paidButton;
    private javax.swing.JLabel rateLabel;
    private javax.swing.JLabel spaceLabel;
    private javax.swing.JLabel spentLabel;
    private javax.swing.JLabel ticketLabel;
    private javax.swing.JLabel title;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
