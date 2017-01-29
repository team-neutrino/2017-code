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
	protected Shooter Cannon;

	/**
	 * Constructs a new AutonMode with given parameters.
	 * @param driveInst Drive to use
	 * @param gear GearManipulator to use
	 * @param cannon Shooter to use
	 */
	public AutonModes(Drive driveInst, GearManipulator gear, Shooter cannon)
	{
		DriveInst = driveInst;
		Gear = gear;
		Cannon = cannon;
		Gear.open(true);
		Gear.tilt(false);
	}

	/**
	 * Method that runs after the auton mode after construction.
	 */
	public abstract void execute();
	
}
