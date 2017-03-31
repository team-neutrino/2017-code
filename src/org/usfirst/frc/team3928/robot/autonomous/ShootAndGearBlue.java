package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.Constants;
import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

public class ShootAndGearBlue extends AutonModes
{
	public ShootAndGearBlue(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
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
			Thread.sleep(5000);
			BallManagerInst.Shoot(false);
			BallManagerInst.SpinUpShooter(false);
			
			DriveInst.DriveDistance(-42, 1);
			Thread.sleep(100);
			DriveInst.TurnDegrees(180, 1);
			Thread.sleep(100);
			DriveInst.DriveDistance(15, 1);
			Thread.sleep(100);

			DriveInst.DriveToTarget();
			Thread.sleep(100);
			DriveInst.setLeft(1);
			DriveInst.setRight(1);
			Thread.sleep(200);
			DriveInst.setLeft(0);
			DriveInst.setRight(0);
			Thread.sleep(Constants.AUTON_GEAR_FORWARD_WAIT_TIME);

			Thread.sleep(100);
			GearManipulatorInst.GearDrop(true);
			Thread.sleep(100);
			DriveInst.DriveDistance(-20, 0.35);
			GearManipulatorInst.GearDrop(false);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

}
