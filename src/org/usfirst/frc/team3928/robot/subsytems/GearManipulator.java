package org.usfirst.frc.team3928.robot.subsytems;

import org.usfirst.frc.team3928.robot.Constants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

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
	private Solenoid FloorAndGearDropA;
	private Solenoid FloorAndGearDropB;

	private SpeedController FloorGearMotor;

	private boolean Moved;
	private boolean LastFloorGearManipulatorState;

	/**
	 * Constructs new object.
	 */
	public GearManipulator()
	{
		GearFlapA = new Solenoid(Constants.GEAR_FLAP_SOLENOID_A_CHANNEL);
		GearFlapB = new Solenoid(Constants.GEAR_FLAP_SOLENOID_B_CHANNEL);
		GearHopperA = new Solenoid(Constants.GEAR_HOPPER_SOLENOID_A_CHANNEL);
		GearHopperB = new Solenoid(Constants.GEAR_HOPPER_SOLENOID_B_CHANNEL);
		FloorAndGearDropA = new Solenoid(Constants.FLOOR_GEAR_UP_AND_GEAR_DROP_SOLENOID_A_CHANNEL);
		FloorAndGearDropB = new Solenoid(Constants.FLOOR_GEAR_UP_AND_GEAR_DROP_SOLENOID_B_CHANNEL);

		if (Constants.REAL_ROBOT)
		{
			FloorGearMotor = new CANTalon(Constants.FLOOR_GEAR_INTAKE_CHANNEL);
		}
		else
		{
			FloorGearMotor = new Victor(Constants.FLOOR_GEAR_INTAKE_CHANNEL);
		}

		GearMove(false);
		GearFlap(false);
		FloorGearDownAndGearDrop(false);
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
	 *            true to drop, false default to not drop
	 */
	public void FloorGearDownAndGearDrop(boolean isUpAndDropped)
	{
		if (Moved && isUpAndDropped)
		{
			FloorAndGearDropA.set(isUpAndDropped);
			FloorAndGearDropB.set(!isUpAndDropped);

		}
		else
		{
			FloorAndGearDropA.set(!isUpAndDropped);
			FloorAndGearDropB.set(isUpAndDropped);
		}

		boolean didStateJustChange = false;
		if (isUpAndDropped && !LastFloorGearManipulatorState)
		{
			LastFloorGearManipulatorState = true;
			didStateJustChange = true;
		}

		if (!isUpAndDropped && LastFloorGearManipulatorState)
		{
			LastFloorGearManipulatorState = false;
			didStateJustChange = true;
		}

		if (didStateJustChange)
		{
			new Thread(new Runnable()
			{
				public void run()
				{
					long startTime = System.currentTimeMillis();
					while (System.currentTimeMillis() - startTime < 1000)
					{
						if (LastFloorGearManipulatorState)
						{
							FloorGearOuttake(true);
						}
						else
						{
							FloorGearIntake(true);
						}
						try
						{
							Thread.sleep(1);
						}
						catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					FloorGearIntake(false);
				}
			}).start();
		}

	}

	/**
	 * Controls the motor on the intake of the floor gear manipulator
	 * 
	 * @param isIntaking
	 *            true to turn motor, false to do nothing
	 * 
	 */
	public void FloorGearIntake(boolean isIntaking)
	{
		if (isIntaking)
		{
			FloorGearMotor.set(Constants.FLOOR_GEAR_INTAKE_SPEED);
		}
		else
		{
			FloorGearMotor.set(0);
		}
	}

	/**
	 * Makes the floor gear manipulator outtake the gear
	 * 
	 * @param isOuttaking
	 *            true to outtake, false to do nothing
	 */
	public void FloorGearOuttake(boolean isOuttaking)
	{
		if (isOuttaking)
		{
			FloorGearMotor.set(Constants.FLOOR_GEAR_OUTTAKE_SPEED);
		}
		else
		{
			FloorGearMotor.set(0);
		}
	}
}
