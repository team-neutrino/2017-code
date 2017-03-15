package org.usfirst.frc.team3928.robot.subsytems;

import org.usfirst.frc.team3928.robot.Constants;

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

	private Boolean Moved;

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
		GearMove(false);
		GearFlap(false);
		GearDrop(false);
	}

	/**
	 * Controls whether or not the gear slot is open.
	 * 
	 * @param isOpen
	 *            true to open, false default to close
	 */
	public void GearFlap(boolean isOpen)
	{
		if (Moved && isOpen)
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
	 *            true to move, false default to down
	 */
	public void GearMove(boolean isMoved)
	{
		Moved = isMoved;
		GearHopperA.set(!isMoved);
		GearHopperB.set(isMoved);
	}

	/**
	 * Controls the bottom of the gear manipulator 
	 * 
	 * @param isDropped
	 * 			true to drop, false default to not drop 
	 */
	public void GearDrop(boolean isDropped)
	{
		if(Moved && isDropped)
		{
			GearDropA.set(isDropped);
			GearDropB.set(!isDropped);
			
		}
		else
		{
			GearDropA.set(!isDropped);
			GearDropB.set(isDropped);
		}

	}
}
