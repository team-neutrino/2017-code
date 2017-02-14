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
	protected GearManipulator GearManipulatorInst;
	protected BallManager BallManagerInst;

	/**
	 * Constructs a new AutonMode with given parameters.
	 * @param driveInst Drive to use
	 * @param gear GearManipulator to use
	 * @param cannon Shooter to use
	 */
	public AutonModes(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		DriveInst = driveInst;
		GearManipulatorInst = gearManipulatorInst;
		BallManagerInst = ballManagerInst;
		GearManipulatorInst.GearFlapOpen(true);
		GearManipulatorInst.GearHopperMove(false);
	}

	/**
	 * Method that runs after the auton mode after construction.
	 */
	public abstract void execute();
	
}
