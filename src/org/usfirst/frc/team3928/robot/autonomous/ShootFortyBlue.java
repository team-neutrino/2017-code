package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.Constants;
import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

public class ShootFortyBlue extends AutonModes
{

	public ShootFortyBlue(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		super(driveInst, gearManipulatorInst, ballManagerInst);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute()
	{
		System.out.println("Shoot Forty Blue auton mode");
		try
		{
			
			DriveInst.DriveDistance(66, 1);
			Thread.sleep(300);
			DriveInst.TurnDegrees(75, 1);
			Thread.sleep(300);
			DriveInst.DriveDistance(36, 1);
			Thread.sleep(2000);
			DriveInst.DriveDistance(-50, 1);
			BallManagerInst.SpinUpShooter(true);
			Thread.sleep(300);
			DriveInst.TurnDegrees(40, 1);
			Thread.sleep(300);
			if (DriveInst.getCamera().getIsTracking())
			{
				DriveInst.DriveDistance(20, 1);
				Thread.sleep(500);
				DriveInst.DriveToTarget(Constants.AUTON_SHOOT_START_X, Constants.AUTON_SHOOT_START_Y,
						Constants.AUTON_SHOOT_TARGET_X, Constants.AUTON_SHOOT_TARGET_Y);
				DriveInst.setLeft(1);
				DriveInst.setRight(1);
				BallManagerInst.Shoot(true);
				Thread.sleep(500);
				DriveInst.setLeft(0);
				DriveInst.setRight(0);
			}
			else
			{
				DriveInst.DriveDistance(60, 1);
			}
			
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//DriveInst.DriveArc(350, 70, 0.5);
//		try
//		{
//			DriveInst.TurnDegrees(80, 1);
//			Thread.sleep(1000);
//			DriveInst.TurnDegrees(-80, 1);
//		}
//		catch (InterruptedException e)
//		{
//			e.printStackTrace();
//		}
	}

}
