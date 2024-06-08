package utils;

import Form.Menu;
import Form.SignIn;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import org.opencv.core.*;
import org.opencv.imgproc.*;
import org.opencv.objdetect.*;
import org.opencv.videoio.*;

public class Camera {

    private int cameraNumber; // The index number of camera on the device
    private String data = ""; // The message from the QR code
    private boolean canScan = true; // Check if the camera should scan the QR code or not
    private long lastScanTime = 0;
    private boolean canStart = true;

    public Camera(int cameraNumber) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        this.cameraNumber = cameraNumber;
    }
    
    public void setCanStart(boolean canStart) {
        this.canStart = canStart;
    }

    // This method converts a Mat object to a BufferedImage object
    public BufferedImage matToBufferedImage(Mat m) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (m.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = m.channels() * m.cols() * m.rows();
        byte[] b = new byte[bufferSize];
        m.get(0, 0, b); // get all the pixels
        BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(b, 0, targetPixels, 0, b.length);
        return image;
    }
    
    public void scanAndDecode(Menu menuForm, int type) {
        canStart = true;
        QRCodeDetector qrCodeDetector = new QRCodeDetector();
        VideoCapture videoCapture = new VideoCapture(cameraNumber);
        // Check if the webcam is opened
        if (!videoCapture.isOpened()) {
            System.out.println("Cannot open the webcam");
            return;
        }

        // Create a Mat object to store the frame
        Mat frame = new Mat();
        // Define your desired frame size
        Size frameSize = new Size(400, 300);
        while (canStart) {
            // Read a frame from the webcam
            videoCapture.read(frame);

            // Check if the frame is empty
            if (frame.empty()) {
                System.out.println("Cannot read the frame");
                break;
            }

            // Convert the frame to grayscale
            Mat gray = new Mat();
            Imgproc.cvtColor(frame, gray, Imgproc.COLOR_BGR2GRAY);

            // Detect and decode the QR code in the frame
            Mat points = new Mat();
            data = qrCodeDetector.detectAndDecode(gray, points);
            // Check if the QR code is detected
            if (!data.isEmpty() && canScan) {
                // Draw a polygon around the QR code
                int n = points.rows();
                for (int i = 0; i < n; i++) {
                    Imgproc.line(frame, new Point(points.get(i, 0)), new Point(points.get((i + 1) % n, 0)), new Scalar(0, 255, 0), 4);
                }
                menuForm.check(data, type);
                canScan = false;
                lastScanTime = System.currentTimeMillis();
            }

            // Outside of your scanning logic, possibly in a looping structure or a timer
            long currentTime = System.currentTimeMillis();
            if (!canScan && (currentTime - lastScanTime) >= 3000) {
                canScan = true; // Re-enable scanning after 3 seconds
            }

            // Resize the frame to the desired size
            Mat resizedFrame = new Mat();
            Imgproc.resize(frame, resizedFrame, frameSize);

            // Convert the Mat object to a BufferedImage object
            BufferedImage image = matToBufferedImage(resizedFrame);

            menuForm.setImage(image, type);
        }

        // Release the resources
        videoCapture.release();
    }

    public void scanAndDecode(SignIn signInForm) {
        QRCodeDetector qrCodeDetector = new QRCodeDetector();
        VideoCapture videoCapture = new VideoCapture(cameraNumber);
        // Check if the webcam is opened
        if (!videoCapture.isOpened()) {
            System.out.println("Cannot open the webcam");
            return;
        }

        // Create a Mat object to store the frame
        Mat frame = new Mat();
        // Define your desired frame size
        Size frameSize = new Size(400, 300);
        while (canStart) {
            // Read a frame from the webcam
            videoCapture.read(frame);

            // Check if the frame is empty
            if (frame.empty()) {
                System.out.println("Cannot read the frame");
                break;
            }

            // Convert the frame to grayscale
            Mat gray = new Mat();
            Imgproc.cvtColor(frame, gray, Imgproc.COLOR_BGR2GRAY);

            // Detect and decode the QR code in the frame
            Mat points = new Mat();
            data = qrCodeDetector.detectAndDecode(gray, points);

            // Check if the QR code is detected
            if (!data.isEmpty() && canScan) {
                // Draw a polygon around the QR code
                int n = points.rows();
                for (int i = 0; i < n; i++) {
                    Imgproc.line(frame, new Point(points.get(i, 0)), new Point(points.get((i + 1) % n, 0)), new Scalar(0, 255, 0), 4);
                }
                signInForm.check(data);
                canScan = false;
                lastScanTime = System.currentTimeMillis();
            }

            // Outside of your scanning logic, possibly in a looping structure or a timer
            long currentTime = System.currentTimeMillis();
            if (!canScan && (currentTime - lastScanTime) >= 3000) {
                canScan = true; // Re-enable scanning after 3 seconds
            }

            // Resize the frame to the desired size
            Mat resizedFrame = new Mat();
            Imgproc.resize(frame, resizedFrame, frameSize);

            // Convert the Mat object to a BufferedImage object
            BufferedImage image = matToBufferedImage(resizedFrame);

            signInForm.setImage(image);
        }

        // Release the resources
        videoCapture.release();
    }

}
