package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.Constants;
import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

public class GearRight extends AutonModes
{
    public GearRight(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
    {
    	super(driveInst, gearManipulatorInst, ballManagerInst);
    }

    public void execute()
    {
    	System.out.println("Gear Right!");
	    try
		{
	    	DriveInst.DriveDistance(65, 0.5);
		    Thread.sleep(500);
		    DriveInst.TurnDegrees(-50, 0.6);
		    Thread.sleep(2000);
		    if (DriveInst.getCamera().getIsTracking())
			{
		    	System.out.println("Tracking");
			    DriveInst.DriveToTarget();
			}
			else
			{
				System.out.println("we ain't got no tracin' foo");
			    DriveInst.DriveDistance(30, 0.3);
			}
		    Thread.sleep(100);
			GearManipulatorInst.GearDrop(true);
			Thread.sleep(Constants.AUTON_GEAR_FORWARD_WAIT_TIME);
			DriveInst.DriveDistance(-30, 0.8);
			GearManipulatorInst.GearDrop(false);
		}
		catch (InterruptedException e)
		{
		    e.printStackTrace();
		}
		
    }
}
