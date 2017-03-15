package org.usfirst.frc.team3928.robot;

public class DriveForward extends AutonModes
{
	public DriveForward(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		super(driveInst, gearManipulatorInst, ballManagerInst);
	}

	public void execute()
	{
		//DriveInst.DriveDistance(120, 0.8);
		DriveInst.DriveToTarget();
		GearManipulatorInst.GearDrop(true);
		
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DriveInst.DriveDistance(-20, 0.35);
		GearManipulatorInst.GearDrop(false);
	}
}
