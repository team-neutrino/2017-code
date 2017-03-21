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
			if(DriveInst.getCamera().getIsTracking())
			{
				System.out.println("Tracking");
				DriveInst.DriveToTarget();
				Thread.sleep(1000);
				DriveInst.DriveDistance(4, 0.3);
				Thread.sleep(Constants.AUTON_GEAR_FORWARD_WAIT_TIME);
			}
			else
			{
				System.out.println("not tracking");
				DriveInst.DriveDistance(76, 0.35);
			}
			
			Thread.sleep(1000);
			GearManipulatorInst.FloorGearDownAndGearDrop(true);
			Thread.sleep(1000);
			DriveInst.DriveDistance(-20, 0.35);
			GearManipulatorInst.FloorGearDownAndGearDrop(false);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
}
