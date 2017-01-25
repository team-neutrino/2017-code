package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Drive
{
	
	SpeedController DriveRight1;
	SpeedController DriveRight2;
	SpeedController DriveLeft1;
	SpeedController DriveLeft2;
	
	public Drive()
	{
		if(Constants.REAL_ROBOT)
		{
			
		}
		else
		{
			DriveRight1 = new Victor(Constants.DRIVE_RIGHT_1_CHANNEL);
			DriveRight2 = new Victor(Constants.DRIVE_RIGHT_2_CHANNEL);
			DriveLeft1 = new Victor(Constants.DRIVE_LEFT_1_CHANNEL);
			DriveLeft2 = new Victor(Constants.DRIVE_LEFT_2_CHANNEL);
		}
	}
	
	public void setRight(int speed)
	{
		DriveRight1.set(speed);
		DriveRight2.set(speed);
	}
	
	public void setLeft(int speed)
	{
		DriveLeft1.set(speed);
		DriveLeft2.set(speed);
	}

}
