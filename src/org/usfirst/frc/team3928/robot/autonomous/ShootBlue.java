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
			Thread.sleep(100);
			DriveInst.TurnDegrees(-45, 0.5);
			Thread.sleep(100);
			DriveInst.DriveDistance(42, 0.5);
			Thread.sleep(100);
			BallManagerInst.Shoot(true);
			Thread.sleep(8000);
			DriveInst.DriveDistance(-42, 0.5);
			Thread.sleep(100);
			DriveInst.TurnDegrees(45, 0.5);
			Thread.sleep(100);
			DriveInst.DriveDistance(-50, 0.5);
			Thread.sleep(100);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
			
	}

}
