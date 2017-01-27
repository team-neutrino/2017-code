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

public class Camera {
	Thread visionThread;
	public Camera(String camName)
	{
		visionThread = new Thread(() -> {
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(640, 480);
			camera.setExposureManual(30);
			CvSink cvSink = CameraServer.getInstance().getVideo();
			CvSource outputStream = CameraServer.getInstance().putVideo("Threshold", 640, 480);
			Mat rectangle = new Mat();
			MatOfPoint contour = new MatOfPoint();
			MatOfInt hull = new MatOfInt();
			MatOfInt temp = new MatOfInt();
			Mat mat = new Mat();
			ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>(); 
			
			             
			while (!Thread.interrupted()) {
				if (cvSink.grabFrame(mat) == 0) {
					outputStream.notifyError(cvSink.getError());
					continue;
				}
				//Imgproc.cvtColor(mat, mat, Imgproc.COLOR_BGR2HSV);
				Core.inRange(mat, new Scalar(Constants.BMin, Constants.GMin, Constants.RMin), new Scalar(Constants.BMax, Constants.GMax, Constants.RMax),mat);
				Imgproc.findContours(mat, contours, new Mat(), Imgproc.RETR_EXTERNAL,Imgproc.CHAIN_APPROX_SIMPLE);
//				for(int i = 0; i < contours.size(); i++)
//				{
//					Imgproc.convexHull(contours.get(i), temp);
//					if(temp.size().area() > hull.size().area())
//					{
//						hull = temp;
//						contour = contours.get(i);
//					}
//				}
//				
//				Rect rect = Imgproc.boundingRect(hull2Points(hull, contour));
				outputStream.putFrame(mat);
				System.gc();
			}
						
		});
		visionThread.setDaemon(true);
		visionThread.start();
	}

MatOfPoint hull2Points(MatOfInt hull, MatOfPoint contour) {
    List<Integer> indexes = hull.toList();
    List<Point> points = new ArrayList<>();
    MatOfPoint point= new MatOfPoint();
    for(Integer index:indexes) {
        points.add(contour.toList().get(index));
    }
    point.fromList(points);
    return point;
}
}
