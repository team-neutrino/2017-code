package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.Constants;
import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

public class ShootForty extends AutonModes
{

	public ShootForty(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		super(driveInst, gearManipulatorInst, ballManagerInst);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute()
	{	
		System.out.println("Shoot Forty auton mode");
		try
		{
			DriveInst.DriveDistance(57, 1);
			Thread.sleep(500);
			DriveInst.TurnDegrees(60, .8);
			Thread.sleep(300);
			DriveInst.DriveDistance(36, 1);
			Thread.sleep(2000);
			DriveInst.DriveDistance(-48, 1);
			Thread.sleep(500);
			DriveInst.TurnDegrees(35, 1);
			Thread.sleep(300);
			DriveInst.DriveDistance(20, 1);
			Thread.sleep(300);
			DriveInst.DriveToTarget(Constants.AUTON_SHOOT_START_X, Constants.AUTON_SHOOT_START_Y, Constants.AUTON_SHOOT_TARGET_X, Constants.AUTON_SHOOT_TARGET_Y);
			DriveInst.setLeft(1);
			DriveInst.setRight(1);
			Thread.sleep(500);
			DriveInst.setLeft(0);
			DriveInst.setRight(0);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
