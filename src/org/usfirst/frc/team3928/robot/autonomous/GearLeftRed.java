package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.Constants;
import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

/**
 * AutonMode that drops off the gear and crosses the line when the robot is
 * starting on the left side of the field.
 * 
 * @author JamesBeetham
 */
public class GearLeftRed extends AutonModes
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
    public GearLeftRed(Drive driveInst, GearManipulator gear, BallManager ballManagerInst)
    {
    	super(driveInst, gear, ballManagerInst);
    }

    /**
     * Starts on left side of field (against alliance wall), drives forward to
     * rotation point, does vision tracking or dead reckoned, drives forward 
     * to drop off gear, back up.
     */
    public void execute()
    {
    	System.out.println("GearLeftRed");
    	try
    	{
    		DriveInst.DriveDistance(60, 0.5);
    		Thread.sleep(1000);
    		DriveInst.TurnDegrees(-50, 0.5);
    		Thread.sleep(1000);
    		
    		if (DriveInst.getCamera().getIsTracking())
        	{
        		System.out.println("tracking");
        		DriveInst.DriveToTarget();
        	}
        	else
        	{
        		System.out.println("not tracking");
        		DriveInst.DriveDistance(52, 0.3);
        	}
    		
    		Thread.sleep(1000);
    		GearManipulatorInst.FloorGearUpAndGearDrop(true);
    		Thread.sleep(Constants.AUTON_GEAR_FORWARD_WAIT_TIME);
    		DriveInst.DriveDistance(-10, 0.3);
    		DriveInst.DriveDistance(-20, 0.8);
        	GearManipulatorInst.FloorGearUpAndGearDrop(false);
    	}
    	catch (InterruptedException e)
    	{
    		e.printStackTrace();
    	}
    }

}
