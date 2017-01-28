package org.usfirst.frc.team3928.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Drive implements Runnable
{

	private SpeedController DriveRight1;
	private SpeedController DriveRight2;
	private SpeedController DriveLeft1;
	private SpeedController DriveLeft2;

	private Encoder EncoderRight;
	private Encoder EncoderLeft;
	private CANTalon t;
	private double RunnableDistance;
	private double RunnableSpeed;
	
	private boolean ThreadRunning;

	public Drive()
	{
		ThreadRunning = false;
		
		if (Constants.REAL_ROBOT)
		{
			
		} else
		{
			t = new CANTalon(Constants.DRIVE_RIGHT_1_CHANNEL);
		//	DriveRight1 = new Victor(Constants.DRIVE_RIGHT_1_CHANNEL);
			DriveRight2 = new Victor(Constants.DRIVE_RIGHT_2_CHANNEL);
			DriveLeft1 = new Victor(Constants.DRIVE_LEFT_1_CHANNEL);
			DriveLeft2 = new Victor(Constants.DRIVE_LEFT_2_CHANNEL);

//			EncoderRight = new Encoder(Constants.ENCODER_DRIVE_RIGHT_CHANNEL_A, Constants.ENCODER_DRIVE_RIGHT_CHANNEL_B);
//			EncoderLeft = new Encoder(Constants.ENCODER_DRIVE_LEFT_CHANNEL_A, Constants.ENCODER_DRIVE_LEFT_CHANNEL_B);
//			double distPerRev = Math.PI * Constants.DRIVE_WHEEL_DIAMETER;
//			double distPerPulse = distPerRev / Constants.PULSE_PER_REV;
//			
//			EncoderRight.setDistancePerPulse(distPerPulse);
//			EncoderLeft.setDistancePerPulse(distPerPulse);		
		}
	}

	public void setRight(double speed)
	{
		t.set(speed);
		DriveRight2.set(speed);
	}

	public void setLeft(double speed)
	{
		DriveLeft1.set(speed);
		DriveLeft2.set(speed);
	}

	public void driveDist(double distance, double speed)
	{
		RunnableDistance = distance;
		RunnableSpeed = speed;
		if(!ThreadRunning)
		{
			ThreadRunning = true;
			new Thread(this).start();
		}
		else
		{
			System.out.println("Drive Distance Thread Already Running");
		}	

	}

	@Override
	public void run()
	{	
		EncoderRight.reset();
		EncoderLeft.reset();
		
		setRight(RunnableSpeed);
		setLeft(RunnableSpeed);
		
		while(EncoderRight.getDistance() < RunnableDistance && 
			  EncoderLeft.getDistance() < RunnableDistance)
		{
			if(EncoderRight.getDistance() >= RunnableDistance)
			{
				setRight(0);
			}
			if(EncoderRight.getDistance() >= RunnableDistance)
			{
				setRight(0);
			}
		}
		
		setRight(0);
		setLeft(0);
		
		ThreadRunning = false;
	}

}
