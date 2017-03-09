package org.usfirst.frc.team3928.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
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
	private SpeedController DriveLeft1;
	private SpeedController DriveLeft2;
	private SpeedController DriveRight1;
	private SpeedController DriveRight2;

	private Encoder EncoderRight;
	private Encoder EncoderLeft;

	/**
	 * Constructs a new Drive object. Sets ThreadRunning to false, sets other
	 * variables.
	 */
	public Drive()
	{
		double distPerRev = Math.PI * Constants.DRIVE_WHEEL_DIAMETER;
		double distPerPulse = distPerRev / Constants.DRIVE_CYCLES_PER_REV;

		EncoderRight = new Encoder(Constants.DRIVE_ENCODER_RIGHT_CHANNEL_A, Constants.DRIVE_ENCODER_RIGHT_CHANNEL_B);
		EncoderLeft = new Encoder(Constants.DRIVE_ENCODER_LEFT_CHANNEL_A, Constants.DRIVE_ENCODER_LEFT_CHANNEL_B);

		EncoderRight.setDistancePerPulse(distPerPulse);
		EncoderLeft.setDistancePerPulse(distPerPulse);

		if (Constants.REAL_ROBOT)
		{
			DriveLeft1 = new CANTalon(Constants.DRIVE_LEFT_1_CHANNEL);
			DriveLeft2 = new CANTalon(Constants.DRIVE_LEFT_2_CHANNEL);
			DriveRight1 = new CANTalon(Constants.DRIVE_RIGHT_1_CHANNEL);
			DriveRight2 = new CANTalon(Constants.DRIVE_RIGHT_2_CHANNEL);
		}
		else
		{
			DriveLeft1 = new Victor(Constants.DRIVE_LEFT_1_CHANNEL);
			DriveLeft2 = new Victor(Constants.DRIVE_LEFT_2_CHANNEL);
			DriveRight1 = new Victor(Constants.DRIVE_RIGHT_1_CHANNEL);
			DriveRight2 = new Victor(Constants.DRIVE_RIGHT_2_CHANNEL);
		}

	}

	/**
	 * Sets speed for right side of the robot.
	 * 
	 * @param speed
	 *            percent power this motor should be given (-1 to 1) TODO:
	 *            correct? these bounds (and setRight correct?)
	 */
	public void setLeft(double speed)
	{
		DriveLeft1.set(speed);
		DriveLeft2.set(speed);
	}

	/**
	 * Sets speed for left side of the robot.
	 * 
	 * @param speed
	 *            percent power this motor should be given (-1 to 1) TODO:
	 *            correct?
	 */
	public void setRight(double speed)
	{
		DriveRight1.set(-speed);
		DriveRight2.set(-speed);
	}

	/**
	 * Drives specified distance.
	 * 
	 * @param distance
	 *            distance to drive (in inches)
	 * @param speed
	 *            how fast, by percent
	 */
	public void DriveDistance(double distance, double speed)
	{
		driveDist(distance, distance, speed);
	}

	/**
	 * Makes robot turn given degrees. Will not work if ThreadRunning is true -
	 * see BlockUntilComplete().
	 * 
	 * @param degrees
	 *            degrees the robot should turn (-180 to 180)
	 * @param speed
	 *            positive value
	 */
	public void TurnDegrees(double degrees, double speed)
	{
		EncoderRight.reset();
		EncoderLeft.reset();
		double turnDistance = degrees * Constants.DRIVE_DISTANCE_PER_TURN_DEGREE;
		
		driveDist(turnDistance, -turnDistance, speed);
	}


	/**
	 * Drives the distance given.
	 * 
	 * @param distance
	 *            inches to drive, positive or negative for direction
	 * @param speed
	 *            speed, positive
	 */
	private void driveDist(double rightDistanceToDrive, double leftDistanceToDrive, double speed)
	{
		EncoderRight.reset();
		EncoderLeft.reset();
		double rightSpeed = speed;
		double leftSpeed = speed;

		double rightDistancePercentCompleted = 0;
		double leftDistancePercentCompleted = 0;

		while (rightDistancePercentCompleted < 1 && leftDistancePercentCompleted < 1
				&& DriverStation.getInstance().isAutonomous() && !DriverStation.getInstance().isDisabled())
		{
			rightDistancePercentCompleted = Math.abs(EncoderRight.getDistance() / rightDistanceToDrive);
			leftDistancePercentCompleted = Math.abs(EncoderLeft.getDistance() / leftDistanceToDrive);
			double distancePercentDiff = Math.abs(rightDistancePercentCompleted - leftDistancePercentCompleted);
			if (rightDistancePercentCompleted >= leftDistancePercentCompleted)
			{
				rightSpeed = speed - distancePercentDiff;
				if (rightDistanceToDrive > 0)
				{
					setRight(rightSpeed);
				}
				else
				{
					setRight(-rightSpeed);
				}
			}
			if (leftDistancePercentCompleted >= rightDistancePercentCompleted)
			{
				leftSpeed = speed - distancePercentDiff;
				if (leftDistanceToDrive > 0)
				{
					setLeft(leftSpeed);
				}
				else
				{
					setLeft(-leftSpeed);
				}
			}
			System.out.println("Right distance: " + EncoderRight.getDistance());
			System.out.println("Left distance: " + EncoderLeft.getDistance());
			
		}
		setRight(0);
		setLeft(0);

	}
	
	
}
