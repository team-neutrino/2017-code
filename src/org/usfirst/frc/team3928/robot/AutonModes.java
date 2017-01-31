package org.usfirst.frc.team3928.robot;

/**
 * Abstract object for autonomous modes. Compensation for creating these javadoc
 * comments is the author tag.
 * 
 * @author JamesBeetham
 */
public abstract class AutonModes
{
	protected Drive DriveInst;
	protected GearManipulator Gear;
	protected BallManager Cannon;

	/**
	 * Constructs a new AutonMode with given parameters.
	 * @param driveInst Drive to use
	 * @param gear GearManipulator to use
	 * @param cannon Shooter to use
	 */
	public AutonModes(Drive driveInst, GearManipulator gear, BallManager cannon)
	{
		DriveInst = driveInst;
		Gear = gear;
		Cannon = cannon;
		Gear.Open(true);
		Gear.Tilt(false);
	}

	/**
	 * Method that runs after the auton mode after construction.
	 */
	public abstract void execute();
	
}
