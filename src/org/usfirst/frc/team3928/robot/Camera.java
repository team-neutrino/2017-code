package org.usfirst.frc.team3928.robot;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * This is a camera. Compensation for creating these javadoc comments is the
 * author tag.
 * 
 * @author JamesBeetham
 */
public class Camera
{
	Thread visionThread;
	public Rect rect;
	public Rect rect2;
	public String camName;

	/**
	 * Constructs a new camera.
	 * 
	 * @param camName
	 *            name for this camera
	 */
	public Camera(String camName)
	{
		this.camName = camName;
		visionThread = new Thread(() -> {
			// Start camera
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			// Settings
			camera.setResolution(Constants.CAMERA_XRES, Constants.CAMERA_YRES);
			camera.setExposureManual(30);
			// Access video
			CvSink cvSink = CameraServer.getInstance().getVideo();
			CvSource outputStream = CameraServer.getInstance().putVideo("Threshold", Constants.CAMERA_XRES, Constants.CAMERA_YRES);
			CvSource outputStream2 = CameraServer.getInstance().putVideo("Rectangle", Constants.CAMERA_XRES, Constants.CAMERA_YRES);
			
			Mat rectangle = new Mat();
			MatOfPoint contour = new MatOfPoint(); // needed?
			MatOfInt hull = new MatOfInt();
			MatOfInt temp = new MatOfInt();
			Mat mat = new Mat();
			MatOfPoint contour2 = new MatOfPoint();
			ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>();

			while (!Thread.interrupted())
			{
				if (cvSink.grabFrame(mat) == 0)
				{
					outputStream.notifyError(cvSink.getError());
					continue;
				}

				// Imgproc.cvtColor(mat, mat, Imgproc.COLOR_BGR2HSV);
				Core.inRange(mat,
						new Scalar(Constants.CAMERA_BLUE_MIN, Constants.CAMERA_GREEN_MIN, Constants.CAMERA_RED_MIN),
						new Scalar(Constants.CAMERA_BLUE_MAX, Constants.CAMERA_GREEN_MAX, Constants.CAMERA_RED_MAX),
						mat);
				
				contours.clear();
				contour = new MatOfPoint();
				// mat = threshold;
				Imgproc.findContours(mat, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);

				for (MatOfPoint c : contours)
				{
					if (c.size().area() > contour.size().area())
					{
						contour2 = contour; // Needed?
						contour = c;
					}
				}
				System.out.println("Largest rectangle: " + contour.size().area());
				List<Point> pts = contour.toList();
				double x = 0;
				double y = 0;
				double xMin = Integer.MAX_VALUE;
				double yMin = Integer.MAX_VALUE;

				double x2 = 0;
				double y2 = 0;
				double xMin2 = Integer.MAX_VALUE;
				double yMin2 = Integer.MAX_VALUE;
				for (Point pt : pts)
				{
					if (pt.x > x)
					{
						x2 = x;
						x = pt.x;
					}
					if (pt.x < xMin)
					{
						xMin2 = xMin;
						xMin = pt.x;
					}
					if (pt.y < yMin)
					{
						yMin2 = yMin;
						yMin = pt.y;
					}
					if (pt.y > y)
					{
						y2 = y;
						y = pt.y;
					}
				}

				rect = new Rect();
				rect.height = (int) (x - xMin);
				rect.x = (int) x;
				rect.y = (int) y;
				rect.width = (int) (y - yMin);

				rect2 = new Rect();
				rect2.height = (int) (x - xMin);
				rect2.x = (int) x;
				rect2.y = (int) y;
				rect2.width = (int) (y - yMin);

				cvSink.grabFrame(rectangle);
				Imgproc.rectangle(rectangle, new Point(rect.x, rect.y),
						new Point(rect.x - rect.height, rect.y - rect.width), new Scalar(55, 255, 0, 255));
				outputStream.putFrame(rectangle);
				outputStream2.putFrame(mat);

				System.gc();
			}

		});
		visionThread.setDaemon(true);
		visionThread.start();
	}

}
