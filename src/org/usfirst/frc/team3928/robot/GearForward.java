package org.usfirst.frc.team3928.robot;

/**
 * This subclass of AutonModes drops off a gear and gets across the line. To be
 * used when robot starts in the [TODO: middle?] position. Compensation for
 * creating these javadoc comments is the author tag.
 * 
 * @author James Beetham
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
	public GearForward(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		super(driveInst, gearManipulatorInst, ballManagerInst);
	}

	/**
	 * Goes forward, drop off a gear, go back, rotate, go forward (across line).
	 */
	public void execute()
	{
		
		
		DriveInst.DriveDistance(84, 0.5);
		DriveInst.TurnDegrees(180, 0.5);
		DriveInst.DriveDistance(84, 0.5);
		DriveInst.TurnDegrees(180, 0.5);

		try
		{
			Thread.sleep(Constants.AUTON_GEAR_FORWARD_PICKUP_TIME);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

//		// TODO use overloaded functions
//
//		DriveInst.DriveDist(-42.15, -0.5);
//		DriveInst.BlockUntilComplete();
//
//		DriveInst.TurnDegrees(45);
//		DriveInst.BlockUntilComplete();
//
//		DriveInst.DriveDist(100, .5);
//		DriveInst.BlockUntilComplete();
	}

}
