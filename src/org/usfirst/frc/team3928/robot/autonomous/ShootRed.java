package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

public class ShootRed extends AutonModes
{
	public ShootRed(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		super(driveInst, gearManipulatorInst, ballManagerInst);
	}

	@Override
	public void execute()
	{
		try
		{
			BallManagerInst.SpinUpShooter(true);
			DriveInst.DriveDistance(-36, 0.7);
			Thread.sleep(100);
			DriveInst.TurnDegrees(60, 1);
			Thread.sleep(100);
			DriveInst.DriveDistance(30, 0.7);
			Thread.sleep(100);
			DriveInst.setLeft(1);
    		DriveInst.setRight(1);
    		Thread.sleep(350);
    		DriveInst.setLeft(0);
    		DriveInst.setRight(0);
    		Thread.sleep(500);
			BallManagerInst.Shoot(true);
			Thread.sleep(8000);
			DriveInst.DriveDistance(-42, 0.7);
			Thread.sleep(100);
			DriveInst.TurnDegrees(-60, 1);
			Thread.sleep(100);
			DriveInst.DriveDistance(-50, 0.7);
			Thread.sleep(100);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
			
	}

}
