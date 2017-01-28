package org.usfirst.frc.team3928.robot;

public class GearLeft extends AutonModes
{

    public GearLeft(Drive driveInst, GearManipulator gear, Shooter shoot)
    {
	super(driveInst, gear, shoot);
    }

    /**
     * Starts on left side of field (against alliance wall), drives forward to rotation point, drives forward to drop off gear, back up, turn, drive into neutral zone. Goes forward, turns, go
     * forward, wait, go back, turn, go forward.
     */
    public void execute()
    {

	// TODO use overloaded function

	DriveInst.DriveDist(10, .5);
	DriveInst.BlockUntilComplete();

	DriveInst.TurnDegrees(90);
	DriveInst.BlockUntilComplete();

	DriveInst.DriveDist(2, .5);
	DriveInst.BlockUntilComplete();
	
	try
	{
	    Thread.sleep(Constants.GEARFORWARD_PICKUP_TIME);
	}
	catch (InterruptedException e)
	{
	    e.printStackTrace();
	}
	
	DriveInst.DriveDist(2, -.5);
	DriveInst.BlockUntilComplete();
	
	DriveInst.TurnDegrees(90);
	DriveInst.BlockUntilComplete();

	DriveInst.DriveDist(10, .5);
	DriveInst.BlockUntilComplete();
    }

}
