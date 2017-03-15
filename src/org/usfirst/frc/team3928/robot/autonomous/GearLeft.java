package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.Constants;
import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

/**
 * AutonMode that drops off the gear and crosses the line when the robot is
 * starting on the left side of the field. Compensation for creating these
 * javadoc comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class GearLeft extends AutonModes
{

    /**
     * Constructs new object.
     * 
     * @param driveInst
     *            Drive object to use
     * @param gear
     *            GearManipulator to use
     * @param cannon
     *            Shooter to use
     */
    public GearLeft(Drive driveInst, GearManipulator gear, BallManager ballManagerInst)
    {
	super(driveInst, gear, ballManagerInst);
    }

    /**
     * Starts on left side of field (against alliance wall), drives forward to
     * rotation point, drives forward to drop off gear, back up, turn, drive
     * into neutral zone. Goes forward, turns, go forward, wait, go back, turn,
     * go forward.
     */
    public void execute()
    {
	DriveInst.DriveDistance(74, 0.5);
	try
	{
	    Thread.sleep(500);
	}
	catch (InterruptedException e)
	{
	    e.printStackTrace();
	}
	DriveInst.TurnDegrees(30, 0.5);
	try
	{
	    Thread.sleep(500);
	}
	catch (InterruptedException e)
	{
	    e.printStackTrace();
	}
	if (DriveInst.getCamera().getIsTracking())
	{
	    DriveInst.DriveToTarget();
	}
	else
	{
	    DriveInst.DriveDistance(30, 0.3);
	}
	GearManipulatorInst.GearDrop(true);
	try
	{
	    Thread.sleep(Constants.AUTON_GEAR_FORWARD_WAIT_TIME);
	}
	catch (InterruptedException e)
	{
	    e.printStackTrace();
	}
	DriveInst.DriveDistance(-30, 0.8);
	GearManipulatorInst.GearDrop(false);
    }

}
