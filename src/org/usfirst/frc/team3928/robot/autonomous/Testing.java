package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

public class Testing extends AutonModes
{
	public Testing(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		super(driveInst, gearManipulatorInst, ballManagerInst);
	}
	
	/**
	 * This method has the robot drive forward for one second.
	 */
	public void execute()
	{
		DriveInst.TurnDegrees(-45, 1);
	}

}
