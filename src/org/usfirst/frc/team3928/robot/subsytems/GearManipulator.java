package org.usfirst.frc.team3928.robot.subsytems;

import org.usfirst.frc.team3928.robot.Constants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;

/**
 * Controls how the gear is positioned. Either open or closed, tilted or not
 * tilted. Compensation for creating these javadoc comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class GearManipulator
{
	private Solenoid GearHopperA;
	private Solenoid GearHopperB;
	private Solenoid GearDropA;
	private Solenoid GearDropB;
	private Solenoid FloorGearDownA;
	private Solenoid FloorGearDownB;

	private SpeedController FloorGearMotor;

	private boolean LastFloorGearManipulatorState;

	/**
	 * Constructs new object.
	 */
	public GearManipulator()
	{
		GearHopperA = new Solenoid(Constants.GEAR_HOPPER_SOLENOID_A_CHANNEL);
		GearHopperB = new Solenoid(Constants.GEAR_HOPPER_SOLENOID_B_CHANNEL);
		GearDropA = new Solenoid(Constants.GEAR_DROP_SOLENOID_A_CHANNEL);
		GearDropB = new Solenoid(Constants.GEAR_DROP_SOLENOID_B_CHANNEL);
		FloorGearDownA = new Solenoid(Constants.FLOOR_GEAR_DOWN_SOLENOID_A_CHANNEL);
		FloorGearDownB = new Solenoid(Constants.FLOOR_GEAR_DOWN_SOLENOID_B_CHANNEL);

		if (Constants.REAL_ROBOT)
		{
			FloorGearMotor = new CANTalon(Constants.FLOOR_GEAR_INTAKE_CHANNEL);
		}
		else
		{
			FloorGearMotor = new Victor(Constants.FLOOR_GEAR_INTAKE_CHANNEL);
		}

		GearMove(false);
		GearDrop(false);
		FloorGearDown(false);
	}

	/**
	 * Controls whether or not the gear slot is open.
	 * 
	 * @param isOpen
	 *            true to open, false default to close
	 */
	public void GearMove(boolean isMoved)
	{
		GearHopperA.set(isMoved);
		GearHopperB.set(!isMoved);
	}
	
	public void GearDrop(boolean isDropped)
	{
		GearDropA.set(isDropped);
		GearDropB.set(!isDropped);
	}
	
	public void FloorGearDown(boolean isDown)
	{
		FloorGearDownA.set(!isDown);
		FloorGearDownB.set(isDown);
		
		boolean didStateJustChange = false;
		if (isDown && !LastFloorGearManipulatorState)
		{
			LastFloorGearManipulatorState = true;
			didStateJustChange = true;
		}

		if (!isDown && LastFloorGearManipulatorState)
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
						if (!LastFloorGearManipulatorState)
						{
							FloorGearIntake(true);
						}
						
						Timer.delay(0.005);
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
