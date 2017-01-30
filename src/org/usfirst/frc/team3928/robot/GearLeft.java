package org.usfirst.frc.team3928.robot;

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
	 * @param driveInst Drive object to use
	 * @param gear GearManipulator to use
	 * @param cannon Shooter to use
	 */
	public GearLeft(Drive driveInst, GearManipulator gear, Shooter cannon)
	{
		super(driveInst, gear, cannon);
	}

	/**
	 * Starts on left side of field (against alliance wall), drives forward to
	 * rotation point, drives forward to drop off gear, back up, turn, drive
	 * into neutral zone. Goes forward, turns, go forward, wait, go back, turn,
	 * go forward.
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
			Thread.sleep(Constants.AUTON_GEAR_FORWARD_PICKUP_TIME);
		} catch (InterruptedException e)
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
