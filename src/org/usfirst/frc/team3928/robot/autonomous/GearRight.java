package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.Constants;
import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

/**
 * AutonMode that drops off the gear and crosses the line when the robot is
 * starting on the left side of the field.
 * 
 * @author YouKnowWho 
 *
 */
public class GearRight extends AutonModes
{
	/**
	 *Constructs new object.
     * 
     * @param driveInst
     *            Drive object to use
     * @param gear
     *            GearManipulator to use
     * @param cannon
     *            Shooter to use
	 */
    public GearRight(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
    {
    	super(driveInst, gearManipulatorInst, ballManagerInst);
    }

    /**
     * Starts on right side of field (against alliance wall), drives forward to
     * rotation point, does vision tracking or dead reckoned, drives forward 
     * to drop off gear, back up.
     */
    public void execute()
    {
	    try
		{
	    	DriveInst.DriveDistance(45, 0.5);
		    Thread.sleep(500);
		    DriveInst.TurnDegrees(45, 0.6);
		    Thread.sleep(2000);
		    if (DriveInst.getCamera().getIsTracking())
			{
		    	System.out.println("is tracking");
			    DriveInst.DriveToTarget();
			}
			else
			{
				System.out.println("Not Tracking");
			    DriveInst.DriveDistance(30, 0.3);
			}
		    Thread.sleep(100);
			GearManipulatorInst.FloorGearUpAndGearDrop(true);
			Thread.sleep(Constants.AUTON_GEAR_FORWARD_WAIT_TIME);
			DriveInst.DriveDistance(-30, 0.8);
			GearManipulatorInst.FloorGearUpAndGearDrop(false);
		}
		catch (InterruptedException e)
		{
		    e.printStackTrace();
		}
		
    }
}
