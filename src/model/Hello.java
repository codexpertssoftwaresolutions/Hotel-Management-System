package model;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class Hello extends JFrame {
    static {
        System.load("C:\\opencv\\build\\java\\x64\\opencv_java490.dll");
    }

    private JLabel barcodeLabel;
    private CameraPanel cameraPanel;
    private VideoCapture camera;

    public Hello() {
        setTitle("Barcode Scanner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cameraPanel = new CameraPanel();
        add(cameraPanel, BorderLayout.CENTER);

        barcodeLabel = new JLabel("Barcode: ");
        add(barcodeLabel, BorderLayout.SOUTH);

        setSize(800, 600);
        setVisible(true);

        camera = new VideoCapture(0);
        if (!camera.isOpened()) {
            System.out.println("Error: Camera not accessible");
            return;
        }

        new Timer(33, e -> updateFrame()).start(); // 30 FPS
    }

    private void updateFrame() {
        Mat frame = new Mat();
        if (camera.read(frame)) {
            BufferedImage image = matToBufferedImage(frame);
            if (image != null) {
                cameraPanel.setImage(image);
                String barcode = readBarcode(image);
                if (barcode != null) {
                    barcodeLabel.setText("Barcode: " + barcode);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Hello());
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
}
