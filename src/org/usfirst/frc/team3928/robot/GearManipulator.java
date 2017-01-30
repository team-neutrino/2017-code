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


	Solenoid Sol1;
	Solenoid Sol2;
	Solenoid Flap1;
	Solenoid Flap2;

	/**
	 * Constructs new object.
	 */
	public GearManipulator()
	{
		Sol1 = new Solenoid(Constants.GEAR_SOLENOID_A_CHANNEL);
		Flap1 = new Solenoid(Constants.GEAR_SOLENOID_FLAP_A_CHANNEL);
		Sol2 = new Solenoid(Constants.GEAR_SOLENOID_B_CHANNEL_1);
		Flap2 = new Solenoid(Constants.GEAR_SOLENOID_FLAP_B_CHANNEL);
		Open(true);
		Tilt(false);
		// set sol2 and flap2
	}

	/**
	 * Controls whether or not the gear slot is open.
	 * 
	 * @param isOpen
	 *            true to open, false to close
	 */
	public void Open(boolean isOpen)
	{
		Flap1.set(isOpen);
		Flap2.set(!isOpen);
	}

	/**
	 * Controls whether or not the gear is tilted.
	 * 
	 * @param isTilted
	 *            true to tilt, false to untilt
	 */
	public void Tilt(boolean isTilted)
	{
		Sol1.set(isTilted);
		Sol2.set(!isTilted);
	}

}
