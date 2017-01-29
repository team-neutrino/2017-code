package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 * Intake object that takes in the balls. Is planned to get deleted so all this
 * javadoc work was for nothing :(. Compensation for creating these javadoc
 * comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class Intake implements Runnable
{

	private SpeedController leftMotor;
	private SpeedController rightMotor;

	private SpeedController shooterLeftMotor;
	private SpeedController shooterRightMotor;

	private boolean ThreadRunning;

	/**
	 * Constructs new intake object. Sets ThreadRunning to false sets other
	 * variables depending on which robot this code is running on.
	 */
	public Intake()
	{
		ThreadRunning = false;

		if (Constants.REAL_ROBOT)
		{

		}
		else
		{
			shooterLeftMotor = new Victor(Constants.SHOOTER_1_POWER_CHANNEL);
			shooterRightMotor = new Victor(Constants.SHOOTER_2_POWER_CHANNEL);
			leftMotor = new Victor(Constants.INTAKE_1_POWER_CHANNEL);
			rightMotor = new Victor(Constants.INTAKE_2_POWER_CHANNEL);
		}
	}

	/**
	 * Starts the intake if ThreadRunning is false.
	 */
	public void intake()
	{
		if (!ThreadRunning)
		{
			ThreadRunning = true;
			new Thread(this).start();
		}
	}

	/**
	 * Stops the intake by setting ThreadRunning to false.
	 */
	public void stop()
	{
		ThreadRunning = false;
	}

	/**
	 * Activates the intake while threadRunning is true.
	 */
	@Override
	public void run()
	{
		while (ThreadRunning)
		{
			shooterLeftMotor.set(Constants.SHOOTER_FOR_INTAKE_BASE_SPEED);
			shooterRightMotor.set(-Constants.SHOOTER_FOR_INTAKE_BASE_SPEED);
			leftMotor.set(Constants.INTAKE_BASE_SPEED);
			rightMotor.set(-Constants.INTAKE_BASE_SPEED);
		}

		shooterLeftMotor.set(0);
		shooterRightMotor.set(0);
		leftMotor.set(0);
		rightMotor.set(0);
	}
}
