package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * Controls how the gear is positioned. Either open or closed, tilted or not
 * tilted. Compensation for creating these javadoc comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class GearManipulator
{

	private Solenoid GearFlapA;
	private Solenoid GearFlapB;
	private Solenoid GearHopperA;
	private Solenoid GearHopperB;
	private Solenoid GearDropA;
	private Solenoid GearDropB;

	private Boolean Tilted;

	/**
	 * Constructs new object.
	 */
	public GearManipulator()
	{
		GearFlapA = new Solenoid(Constants.GEAR_FLAP_SOLENOID_A_CHANNEL);
		GearFlapB = new Solenoid(Constants.GEAR_FLAP_SOLENOID_B_CHANNEL);
		GearHopperA = new Solenoid(Constants.GEAR_HOPPER_SOLENOID_A_CHANNEL);
		GearHopperB = new Solenoid(Constants.GEAR_HOPPER_SOLENOID_B_CHANNEL);
		GearDropA = new Solenoid(Constants.GEAR_DROP_SOLENOID_A_CHANNEL);
		GearDropB = new Solenoid(Constants.GEAR_DROP_SOLENOID_B_CHANNEL);
		GearHopperMove(false);
		GearFlapOpen(false);
		GearDropMove(false);
	}

	/**
	 * Controls whether or not the gear slot is open.
	 * 
	 * @param isOpen
	 *            true to open, false to close
	 */
	public void GearFlapOpen(boolean isOpen)
	{
		if (!Tilted && isOpen)
		{
			GearFlapA.set(isOpen);
			GearFlapB.set(!isOpen);
		}
		else
		{
			GearFlapA.set(!isOpen);
			GearFlapB.set(isOpen);
		}
	}

	/**
	 * Controls whether or not the gear is tilted.
	 * 
	 * @param isTilted
	 *            true to tilt, false to untilt
	 */
	public void GearHopperMove(boolean isTilted)
	{
		// if(isTilted)
		// {
		// Tilted = true;
		// GearHopperA.set(isTilted);
		// GearHopperB.set(!isTilted);
		// }
		// else
		// {
		// Tilted = false;
		// }

		Tilted = isTilted;
		GearHopperA.set(isTilted);
		GearHopperB.set(!isTilted);
	}

	/**
	 * Controls the bottom of the gear manipulator 
	 * 
	 * @param isDroped
	 * 			true to drop, false to not drop 
	 */
	public void GearDropMove(boolean isDroped)
	{
		GearDropA.set(!isDroped);
		GearDropB.set(isDroped);
	}
}
