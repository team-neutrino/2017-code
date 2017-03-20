package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

public class GearHopperShoot extends AutonModes {
	
	public GearHopperShoot(Drive driveInst, GearManipulator gear, BallManager ballManagerInst)
	{
		super(driveInst, gear, ballManagerInst);
	}
	public void execute()
	{
		
		
		try
		{
			DriveInst.DriveDistance(74, 1);
			Thread.sleep(1000);
			DriveInst.TurnDegrees(30, 1);
			Thread.sleep(1000);
			DriveInst.DriveDistance(30, 1);
			Thread.sleep(1000);
			DriveInst.DriveDistance(-30, 1);
			Thread.sleep(1000);
			DriveInst.TurnDegrees(-150, 1);
			Thread.sleep(1000);
			DriveInst.DriveDistance(30,1);
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		DriveInst.DriveDistance(-30,1);
		DriveInst.TurnDegrees(-45,1);
		DriveInst.DriveDistance(74,1);

	}


}
