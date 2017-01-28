package org.usfirst.frc.team3928.robot;

public class GearForward extends AutonModes{

	@Override
	public void run() 
	{
		Drive DriveInst = new Drive();
		
		//open flap TODO
		DriveInst.driveDist(84.3, 0.5);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		DriveInst.driveDist(-42.15, -0.5);
		//DriveInst.setLeft();
	}
	
	
}
