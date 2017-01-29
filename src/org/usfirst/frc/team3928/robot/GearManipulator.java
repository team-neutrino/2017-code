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

	/*
	 * TODO private / public on variables member variables capitalized fix
	 * capitalizations of functions 2 sol instances per physical sol
	 */

	Solenoid sol1;
	Solenoid sol2;
	Solenoid flap1;
	Solenoid flap2;

	/**
	 * Constructs new object.
	 */
	public GearManipulator()
	{
		sol1 = new Solenoid(Constants.SOLENOID_CHANNEL_1);
		flap1 = new Solenoid(Constants.SOLENOID_FLAP_CHANNEL);
		open(true);
		tilt(false);
		// set sol2 and flap2
	}

	/**
	 * Controls whether or not the gear slot is open.
	 * 
	 * @param isOpen
	 *            true to open, false to close
	 */
	public void open(boolean isOpen)
	{
		flap1.set(isOpen);
		flap2.set(!isOpen);
	}

	/**
	 * Controls whether or not the gear is tilted.
	 * 
	 * @param isTilted
	 *            true to tilt, false to untilt
	 */
	public void tilt(boolean isTilted)
	{
		sol1.set(isTilted);
		sol2.set(!isTilted);
	}

}
