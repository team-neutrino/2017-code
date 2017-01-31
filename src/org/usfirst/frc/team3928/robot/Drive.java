package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 * Object which drives the robot. Compensation for creating these javadoc
 * comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class Drive
{
	// TODO overload threaded functions - true if threaded, false if not.

	private SpeedController DriveRight1;
	private SpeedController DriveRight2;
	private SpeedController DriveLeft1;
	private SpeedController DriveLeft2;

	private Encoder EncoderRight;
	private Encoder EncoderLeft;
	// private CANTalon t;

	private boolean ThreadRunning;

	private GyroBase Gyro;

	/**
	 * Constructs a new Drive object. Sets ThreadRunning to false, sets other
	 * variables.
	 */
	public Drive()
	{
		ThreadRunning = false;
		Gyro = new AnalogGyro(Constants.DRIVE_GYRO_CHANNEL);
		Gyro.calibrate();

		EncoderRight = new Encoder(Constants.DRIVE_ENCODER_RIGHT_CHANNEL_A, Constants.DRIVE_ENCODER_RIGHT_CHANNEL_B);
		EncoderLeft = new Encoder(Constants.DRIVE_ENCODER_LEFT_CHANNEL_A, Constants.DRIVE_ENCODER_LEFT_CHANNEL_B);
		double distPerRev = Math.PI * Constants.DRIVE_WHEEL_DIAMETER;
		double distPerPulse = distPerRev / Constants.DRIVE_CYCLES_PER_REV;

		EncoderRight.setDistancePerPulse(distPerPulse);
		EncoderLeft.setDistancePerPulse(distPerPulse);

		if (Constants.REAL_ROBOT)
		{

		}
		else
		{
			// t = new CANTalon(Constants.DRIVE_RIGHT_1_CHANNEL);
			DriveRight1 = new Victor(Constants.DRIVE_RIGHT_1_CHANNEL);
			DriveRight2 = new Victor(Constants.DRIVE_RIGHT_2_CHANNEL);
			DriveLeft1 = new Victor(Constants.DRIVE_LEFT_1_CHANNEL);
			DriveLeft2 = new Victor(Constants.DRIVE_LEFT_2_CHANNEL);
		}
	}

	/**
	 * Sets speed for right side of the robot.
	 * 
	 * @param speed
	 *            percent power this motor should be given (-1 to 1) TODO:
	 *            correct? these bounds (and setRight correct?)
	 */
	public void setRight(double speed)
	{
		DriveRight1.set(speed);
		DriveRight2.set(speed);
	}

	/**
	 * Sets speed for left side of the robot.
	 * 
	 * @param speed
	 *            percent power this motor should be given (-1 to 1) TODO:
	 *            correct?
	 */
	public void setLeft(double speed)
	{
		DriveLeft1.set(speed);
		DriveLeft2.set(speed);
	}

	/**
	 * Makes the robot drive a certain distance at a given speed. Will not work
	 * if ThreadRunning is currently true - see BlockUntilComplete().
	 * 
	 * @param distance
	 *            how far to go (in inches) TODO: correct?
	 * @param speed
	 *            how fast to go (-1 to 1) TODO: correct?
	 */
	public void DriveDist(double distance, double speed)
	{
		if (!ThreadRunning)
		{
			ThreadRunning = true;
			new Thread(new Runnable()
			{
				public void run()
				{
					driveDistanceRunnable(distance, speed);
				}
			}).start();
		}
		else
		{
			System.out.println("Drive distance thread is aready running.");
		}

	}

	/**
	 * Makes robot turn given degrees. Will not work if ThreadRunning is true -
	 * see BlockUntilComplete().
	 * 
	 * @param degrees
	 *            degrees the robot should turn (360 = all the way around)
	 */
	public void TurnDegrees(double degrees)
	{
		if (!ThreadRunning)
		{
			ThreadRunning = true;
			new Thread(new Runnable()
			{
				public void run()
				{
					turnDegreesRunnable(degrees);
				}
			}).start();
		}
		else
		{
			System.out.println("Drive turning thread is already running.");
		}
	}

	/**
	 * Drives the distance given.
	 * 
	 * @param distance
	 *            inches to drive
	 * @param speed
	 *            speed to go (-1 to 1) TODO: correct?
	 */
	private void driveDistanceRunnable(double distance, double speed)
	{
		EncoderRight.reset();
		EncoderLeft.reset();

		setRight(speed);
		setLeft(speed);

		long startTime = System.currentTimeMillis();
		while (EncoderRight.getDistance() < distance || EncoderLeft.getDistance() < distance)
		{
			if (EncoderRight.getDistance() >= distance)
			{
				setRight(0);
			}
			if (EncoderRight.getDistance() >= distance)
			{
				setRight(0);
			}

			if (startTime + Constants.DRIVE_TIME_PER_INCH * distance < System.currentTimeMillis())
			{
				System.out.println("Encoder unplugged or slow robot");
				break;
			}
		}

		setRight(0);
		setLeft(0);

		ThreadRunning = false;
	}

	/**
	 * Turns the robot.
	 * 
	 * @param degrees
	 *            how far to turn (360 = all the way around)
	 */
	private void turnDegreesRunnable(double degrees)
	{
		double angle = Gyro.getAngle();
		if (degrees > 0)
		{
			this.setLeft(0.5);
			this.setRight(-0.5);

			long startTime = System.currentTimeMillis();
			while (Gyro.getAngle() - angle < degrees)
			{
				try
				{
					Thread.sleep(50);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}

				if (startTime + Constants.DRIVE_TIME_PER_DEGREE < System.currentTimeMillis())
				{
					System.out.println("Took too long to turn.");
					break;
				}
			}
		}
		else
		{
			this.setLeft(-0.5);
			this.setRight(0.5);
			while (Gyro.getAngle() - angle > degrees)
			{
				try
				{
					Thread.sleep(50);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

			ThreadRunning = false;
		}

		this.setLeft(0);
		this.setRight(0);
	}

	/**
	 * Sleeps until ThreadRunning is false (when drive has completed previous
	 * task).
	 */
	public void BlockUntilComplete()
	{
		while (ThreadRunning)
		{
			try
			{
				Thread.sleep(1);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}
