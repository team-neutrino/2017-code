package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.Constants;
import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

public class ShootFortyRed extends AutonModes
{

	public ShootFortyRed(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		super(driveInst, gearManipulatorInst, ballManagerInst);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute()
	{
		System.out.println("Shoot Forty Red auton mode");
		try
		{
			GearManipulatorInst.GearMove(true);
			DriveInst.DriveDistance(59, 1); //added 4
			Thread.sleep(500);
			GearManipulatorInst.GearMove(false);
			DriveInst.TurnDegrees(-80, 1);
			Thread.sleep(500);
			DriveInst.DriveDistance(27, 0.75); // was 1
			DriveInst.setLeft(0.2);
			DriveInst.setRight(0.2);
			Thread.sleep(500);
			DriveInst.setLeft(0);
			DriveInst.setRight(0);
			DriveInst.DriveDistance(-50, 1); 
			BallManagerInst.SpinUpShooter(true);
			GearManipulatorInst.GearMove(true);
			Thread.sleep(2000);
			DriveInst.TurnDegrees(-50, 1); //40
			Thread.sleep(500); //increased sleep was 500
			if (DriveInst.getCamera().getIsTracking())
			{
//				DriveInst.DriveDistance(20, 1);
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
				DriveInst.DriveDistance(30, 1);
				DriveInst.setLeft(1);
				DriveInst.setRight(1);
				BallManagerInst.Shoot(true);
				GearManipulatorInst.GearMove(false);
				Thread.sleep(250);
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
