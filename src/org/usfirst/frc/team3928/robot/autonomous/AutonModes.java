package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

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
	 * 
	 * @param driveInst
	 *            Drive to use
	 * @param gearManipulatorInst
	 *            GearManipulator to use
	 * @param ballManagerInst
	 *            ball manager to use
	 */
	public AutonModes(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		DriveInst = driveInst;
		GearManipulatorInst = gearManipulatorInst;
		BallManagerInst = ballManagerInst;
		GearManipulatorInst.FloorGearDown(false);
	}

	/**
	 * Method that runs after the auton mode after construction.
	 */
	public abstract void execute();
}
