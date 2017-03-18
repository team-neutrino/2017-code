package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

public class DriveForward extends AutonModes
{
	/**
	 * This constructs the class with a copy of drive, gear 
	 * manipulator, and ball manager.
	 * 
	 * @param driveInst
	 * 		An instance of the drive class
	 * 
	 * @param gearManipulatorInst
	 * 		An instance of the gear manipulator
	 *  
	 * @param ballManagerInst
	 * 		An instance ball manager 
	 * 
	 */
	public DriveForward(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		super(driveInst, gearManipulatorInst, ballManagerInst);
	}
	
	/**
	 * This method has the robot drive forward for one second.
	 */
	public void execute()
	{
		try
		{
			DriveInst.setRight(0.4);
			DriveInst.setLeft(0.4);
			Thread.sleep(1000);
			DriveInst.setRight(0);
			DriveInst.setLeft(0);;
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
