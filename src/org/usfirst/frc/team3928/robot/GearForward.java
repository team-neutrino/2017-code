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
	 * @throws InterruptedException 
	 */
	public void execute()
	{
		DriveInst.DriveDistance(76, 0.35);
		
		try
		{
			Thread.sleep(Constants.AUTON_GEAR_FORWARD_WAIT_TIME);
			GearManipulatorInst.GearDrop(true);
			Thread.sleep(444);
			GearManipulatorInst.GearDrop(false);
			Thread.sleep(444);
			GearManipulatorInst.GearDrop(true);
			Thread.sleep(444);
			GearManipulatorInst.GearDrop(false);
			Thread.sleep(444);
			GearManipulatorInst.GearDrop(true);
			Thread.sleep(444);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		DriveInst.DriveDistance(-24, 0.25);
		GearManipulatorInst.GearDrop(false);
	}

}
