package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.Constants;
import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

/**
 * This auton mode goes to the middle peg. 
 * 
 * @author YouKnowWho 
 *
 */
public class GearForward extends AutonModes
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
	public GearForward(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		super(driveInst, gearManipulatorInst, ballManagerInst);
	}

	/**
	 * This method executes the gear forward auton mode. It goes forward and 
	 * drops of the gear. 
	 */
	public void execute()
	{
		System.out.println("GearForward");
		try
		{
			GearManipulatorInst.FloorGearDown(false);
			DriveInst.DriveDistance(76, 0.5);
			Thread.sleep(1000);
    		DriveInst.setLeft(.6);
    		DriveInst.setRight(.6);
    		Thread.sleep(350);
    		DriveInst.setLeft(0);
    		DriveInst.setRight(0);
			Thread.sleep(500);
			GearManipulatorInst.GearDrop(true);
			Thread.sleep(Constants.AUTON_GEAR_FORWARD_WAIT_TIME);
    		DriveInst.DriveDistance(-10, 0.45);
    		DriveInst.DriveDistance(-20, 1);
        	GearManipulatorInst.GearDrop(false);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
}
