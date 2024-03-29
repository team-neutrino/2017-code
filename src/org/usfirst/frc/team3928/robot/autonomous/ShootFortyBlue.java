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
			GearManipulatorInst.GearMove(true);
			DriveInst.DriveDistance(60, 1); //added 4, changed to 60 
			Thread.sleep(500);
			DriveInst.TurnDegrees(85, 1);
			Thread.sleep(500);
			DriveInst.DriveDistance(36, 0.75); //was 1
			DriveInst.setLeft(0.2); // used to not be here, we don't want to bounce
			DriveInst.setRight(0.2);
			Thread.sleep(2000);
			DriveInst.setLeft(0);
			DriveInst.setRight(0);
			DriveInst.DriveDistance(-50, 1);
			BallManagerInst.SpinUpShooter(true);
			Thread.sleep(300);
			DriveInst.TurnDegrees(70, 1); //40
			Thread.sleep(1000); //increased sleep was 500
			//DriveInst.DriveDistance(30, 1);
			if (DriveInst.getCamera().getIsTracking())
			{
//				Thread.sleep(500);
//				DriveInst.DriveToTarget(Constants.AUTON_SHOOT_START_X, Constants.AUTON_SHOOT_START_Y,
//						Constants.AUTON_SHOOT_TARGET_X, Constants.AUTON_SHOOT_TARGET_Y);
//				DriveInst.setLeft(1);
//				DriveInst.setRight(1);
//				BallManagerInst.Shoot(true);
//				Thread.sleep(500);
//				DriveInst.setLeft(0);
//				DriveInst.setRight(0);
			}
			else
			{
				DriveInst.DriveDistance(45, 1);
				Thread.sleep(1000);
				DriveInst.setLeft(1);
				DriveInst.setRight(1);
				BallManagerInst.Shoot(true);
				Thread.sleep(500);
				DriveInst.setLeft(0);
				DriveInst.setRight(0);
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
