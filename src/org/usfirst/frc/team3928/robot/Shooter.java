package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 * Object that controls the shooter. Compensation for creating these javadoc
 * comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class Shooter implements Runnable
{

	// TODO: rename variables.
	private SpeedController leftMotor;
	private SpeedController rightMotor;
	private Encoder encoder;
	private Solenoid sol1;
	private boolean ThreadRunning;

	/**
	 * Constructs new shooter. Sets ThreadRunning to false and sets other
	 * variables based on which robot this code is being run on.
	 */
	public Shooter()
	{
		ThreadRunning = false;

		if (Constants.REAL_ROBOT)
		{

		}
		else
		{
			Solenoid sol1 = new Solenoid(Constants.SOLENOID_INTAKE_CHANNEL_1);
			leftMotor = new Victor(Constants.SHOOTER_1_POWER_CHANNEL);
			rightMotor = new Victor(Constants.SHOOTER_2_POWER_CHANNEL);

			encoder = new Encoder(Constants.ENCODER_DRIVE_LEFT_CHANNEL_A, Constants.ENCODER_SHOOTER_CHANNEL_B);
			double distPerRev = Math.PI * Constants.SHOOTER_WHEEL_DIAMETER;
			double distPerPulse = distPerRev / Constants.PULSE_PER_REV;
			encoder.setDistancePerPulse(distPerPulse);
		}
	}

	/**
	 * Activates the shooter and makes the robot start shooting.
	 */
	public void shoot()
	{
		if (!ThreadRunning)
		{
			ThreadRunning = true;
			new Thread(this).start();
		}
	}

	/**
	 * Makes the robot stop shooting.
	 */
	public void stop()
	{
		ThreadRunning = false;
	}

	/**
	 * Makes the robot shoot until ThreadRunning is set to false by stop().
	 */
	@Override
	public void run()
	{
		double power = Constants.SHOOTER_BASE_SPEED;
		sol1.set(true);
		while (ThreadRunning)
		{
			if (encoder.getRate() < Constants.EXPECTED_RATE_SHOOTER)
			{
				power += .01;
			}
			if (encoder.getRate() > Constants.EXPECTED_RATE_SHOOTER)
			{
				power -= .01;
			}

			leftMotor.set(power);
			leftMotor.set(-power);
		}

		sol1.set(false);

		leftMotor.set(0);
		rightMotor.set(0);
	}

}
