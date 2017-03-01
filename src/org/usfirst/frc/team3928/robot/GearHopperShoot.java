package org.usfirst.frc.team3928.robot;

public class GearHopperShoot extends AutonModes {
	
	public GearHopperShoot(Drive driveInst, GearManipulator gear, BallManager ballManagerInst)
	{
		super(driveInst, gear, ballManagerInst);
	}
	public void execute()
	{
		DriveInst.DriveDistance(74, 1);

		DriveInst.TurnDegrees(30, 1);

		DriveInst.DriveDistance(30, 1);

		DriveInst.DriveDistance(-30, 1);
		
		DriveInst.TurnDegrees(-150, 1);
		
		DriveInst.DriveDistance(30,1);
		
		try
		{
			Thread.sleep(500);
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
