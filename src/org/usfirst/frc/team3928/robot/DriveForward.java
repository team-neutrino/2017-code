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
	}
}
