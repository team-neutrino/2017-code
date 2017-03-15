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
