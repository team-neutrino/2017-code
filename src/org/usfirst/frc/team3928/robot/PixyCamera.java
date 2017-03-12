package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.SerialPort;

public class PixyCamera implements Runnable{

	private SerialPort CameraConnection;
	private int X;
	private int Y;
	private int Width;
	private int Height;
	private boolean IsTracking;
	private long LastTargetTrackTime;

	public PixyCamera()
	{
		CameraConnection = new SerialPort(115200, SerialPort.Port.kMXP);
		CameraConnection.setReadBufferSize(100);

		new Thread(this).start();
	}

	public int getX()
	{
		return X;
	}

	public int getY()
	{
		return Y;
	}

	public int getWidth()
	{
		return Width;
	}

	public int getHeight()
	{
		return Height;
	}

	public boolean getIsTracking()
	{
		return IsTracking;
	}

	private boolean checkForSinkFrame()
	{
		byte[] dataReceived = CameraConnection.read(1);
		if(dataReceived[0] != (byte)0x55)
		{
			return false;
		}
		dataReceived = CameraConnection.read(1);
		if(dataReceived[0] != (byte)0xAA)
		{
			return false;
		}
		dataReceived = CameraConnection.read(1);
		if(dataReceived[0] != (byte)0x55)
		{
			return false;
		}
		dataReceived = CameraConnection.read(1);
		if(dataReceived[0] != (byte)0xAA)
		{
			return false;
		}

		return true;

	}

	private void parsePackage()
	{
		byte[] data1 = CameraConnection.read(12);
		int checksum1 = ((data1[1] & 0xFF) << 8) | (data1[0] & 0xFF);
		int signature1 = ((data1[3] & 0xFF) << 8) | (data1[2] & 0xFF);
		int x1 = ((data1[5] & 0xFF) << 8) | (data1[4] & 0xFF);
		int y1 = ((data1[7] & 0xFF) << 8) | (data1[6] & 0xFF);
		int width1 = ((data1[9] & 0xFF) << 8) | (data1[8] & 0xFF);
		int height1 = ((data1[11] & 0xFF) << 8) | (data1[10] & 0xFF);

		int calculatedChecksum1 = signature1 + x1 + y1 + width1 + height1;
		
		CameraConnection.read(2);
		
		byte[] data2 = CameraConnection.read(12);
		int checksum2 = ((data2[1] & 0xFF) << 8) | (data2[0] & 0xFF);
		int signature2 = ((data2[3] & 0xFF) << 8) | (data2[2] & 0xFF);
		int x2 = ((data2[5] & 0xFF) << 8) | (data2[4] & 0xFF);
		int y2 = ((data2[7] & 0xFF) << 8) | (data2[6] & 0xFF);
		int width2 = ((data2[9] & 0xFF) << 8) | (data2[8] & 0xFF);
		int height2 = ((data2[11] & 0xFF) << 8) | (data2[10] & 0xFF);
		
		int calculatedChecksum2 = signature2 + x2 + y2 + width2 + height2;

		if (calculatedChecksum1 == checksum1 && calculatedChecksum2 == checksum2)
		{
			LastTargetTrackTime = System.currentTimeMillis();
			X = (x1 + x2) / 2;
		}
		
	}

	public void run() 
	{
		while (true)
		{
			if(CameraConnection.getBytesReceived() > 15)
			{
				if(checkForSinkFrame())
				{
					parsePackage();
				}
			}
			else
			{
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
			if (System.currentTimeMillis() - LastTargetTrackTime < 100)
			{
				IsTracking = true;
			}
			else
			{
				IsTracking = false;
			}

		}

	}

}
