package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

public class ShootBlue extends AutonModes
{
	public ShootBlue(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		super(driveInst, gearManipulatorInst, ballManagerInst);
	}

	@Override
	public void execute()
	{
		try
		{
			BallManagerInst.SpinUpShooter(true);
			DriveInst.DriveDistance(-36, 0.5);
			Thread.sleep(1000);
			DriveInst.TurnDegrees(-45, 0.5);
			Thread.sleep(1000);
			DriveInst.DriveDistance(36, 0.5);
			Thread.sleep(1000);
			BallManagerInst.Shoot(true);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
			
	}

}
