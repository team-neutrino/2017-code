package org.usfirst.frc.team3928.robot;

/**
 * This auton object drops off a gear and gets across the line. All javadocs are
 * courtesy of James, therefore credit for all code is given to James.
 * 
 * @author James Beetham
 *
 */
public class GearForward extends AutonModes
{

    /**
     * Builds new gear forward object that goes forward, drops off a gear, goes
     * back, rotates, goes forward (across line).
     * 
     * @param driveInst
     *            drive instance
     * @param gear
     *            gear manipulator
     * @param shoot
     *            shooter
     */
    public GearForward(Drive driveInst, GearManipulator gear, Shooter shoot)
    {
	super(driveInst, gear, shoot);
    }

    /**
     * Goes forward, drop off a gear, go back, rotate, go forward (across line).
     */
    public void execute()
    {
	DriveInst.DriveDist(84.3, 0.5);
	DriveInst.BlockUntilComplete();

	try
	{
	    Thread.sleep(Constants.GEARFORWARD_PICKUP_TIME);
	}
	catch (InterruptedException e)
	{
	    e.printStackTrace();
	}

	// TODO use overloaded functions
	
	DriveInst.DriveDist(-42.15, -0.5);
	DriveInst.BlockUntilComplete();

	DriveInst.TurnDegrees(45);
	DriveInst.BlockUntilComplete();

	DriveInst.DriveDist(100, .5);
	DriveInst.BlockUntilComplete();
    }

}
