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
public class GearRight extends AutonModes
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
    public GearRight(Drive driveInst, GearManipulator gear, BallManager ballManagerInst)
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
       	System.out.println("GearRightRed");
    	try
    	{
    		DriveInst.DriveDistance(78, 0.7);
    		Thread.sleep(500);
    		DriveInst.TurnDegrees(45, 1);
    		Thread.sleep(500);
    		DriveInst.DriveDistance(-12, 0.7);
    		Thread.sleep(1000);
    		if (DriveInst.getCamera().getIsTracking())
        	{
        		System.out.println("tracking");
        		DriveInst.DriveToTarget(Constants.AUTON_GEAR_START_X, Constants.AUTON_GEAR_START_Y, Constants.AUTON_GEAR_TARGET_X, Constants.AUTON_GEAR_TARGET_Y);       		
        	}
        	else
        	{
        		System.out.println("not tracking");
        		DriveInst.DriveDistance(48, 0.3);
        	}
    		Thread.sleep(500);
    		DriveInst.setLeft(1);
    		DriveInst.setRight(1);
    		Thread.sleep(350);
    		DriveInst.setLeft(0);
    		DriveInst.setRight(0);
    		//Thread.sleep(500);
    		GearManipulatorInst.GearDrop(true);
    		Thread.sleep(500);
    		DriveInst.DriveDistance(-10, 0.7);
    		DriveInst.DriveDistance(-20, 1);
        	GearManipulatorInst.GearDrop(false);
    	}
    	catch (InterruptedException e)
    	{
    		e.printStackTrace();
    	}
    }

}
