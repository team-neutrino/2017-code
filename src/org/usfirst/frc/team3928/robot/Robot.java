package org.usfirst.frc.team3928.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 * Object that runs the entire robot. Compensation for creating these javadoc
 * comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class Robot extends IterativeRobot
{
	private SpeedController Climber;
	private Drive DriveInst;
	private Joystick JoyRight;
	private Joystick JoyLeft;
	private Joystick Pad;
	private BallManager BallManagerInst;
	private GearManipulator GearManipulatorInst;

	/**
	 * Initializes the robot.
	 */
	@Override
	public void robotInit()
	{
		DriveInst = new Drive();
		JoyRight = new Joystick(Constants.JOY_LEFT_CHANNEL);
		JoyLeft = new Joystick(Constants.JOY_RIGHT_CHANNEL);
		Pad = new Joystick(Constants.JOY_PAD_CHANNEL);

		GearManipulatorInst = new GearManipulator();
		BallManagerInst = new BallManager();
		if (Constants.REAL_ROBOT)
		{
			Climber = new CANTalon(Constants.CLIMBER_CHANNEL);
		}
		else
		{
			Climber = new Victor(Constants.CLIMBER_CHANNEL);
		}
	}

	/**
	 * Initializes the autonomous.
	 */
	@Override
	public void autonomousInit()
	{
		AutonModes mode = new GearLeft(DriveInst, GearManipulatorInst, BallManagerInst);
		mode.execute();
	}

	/**
	 * Calls periodically over autonomous
	 */
	@Override
	public void autonomousPeriodic()
	{
	}

	/**
	 * Initializes the teleop.
	 */
	@Override
	public void teleopInit()
	{
	}

	@Override
	public void teleopPeriodic()
	{
		double rightSpeed;
		double leftSpeed;

		if (JoyRight.getY() > 0)
		{
			rightSpeed = -Math.pow(JoyRight.getY(), 2);
		}
		else
		{
			rightSpeed = Math.pow(JoyRight.getY(), 2);
		}
		if (JoyLeft.getY() > 0)
		{
			leftSpeed = -Math.pow(JoyLeft.getY(), 2);
		}
		else
		{
			leftSpeed = Math.pow(JoyLeft.getY(), 2);
		}

		if (Pad.getRawButton(Constants.BUTTON_CLIMB_UP))
		{
			Climber.set(1);
			System.out.println(Climber.get());
		}
		else if (Pad.getRawButton(Constants.BUTTON_CLIMB_DOWN))
		{
			Climber.set(-0.25);
			System.out.println(Climber.get());
		}
		else
		{
			Climber.set(0);
		}

		if (JoyLeft.getRawButton(Constants.BUTTON_INVERT_DIRECTION))
		{
			DriveInst.setLeft(-rightSpeed);
			DriveInst.setRight(-leftSpeed);
		}
		else if (JoyRight.getRawButton(Constants.BUTTON_HALF_SPEED))
		{
			DriveInst.setRight(rightSpeed / 2);
			DriveInst.setLeft(leftSpeed / 2);
		}
		else
		{
			DriveInst.setRight(rightSpeed);
			DriveInst.setLeft(leftSpeed);
		}

		BallManagerInst.Intake(Pad.getRawButton(Constants.BUTTON_INTAKE));
		BallManagerInst
				.Shoot(JoyRight.getRawButton(Constants.BUTTON_SHOOT) || JoyLeft.getRawButton(Constants.BUTTON_SHOOT));
		BallManagerInst.SpinUpShooter(Pad.getRawButton(Constants.BUTTON_SHOOTER_SPIN_UP));

		GearManipulatorInst.GearHopperMove(Pad.getRawButton(Constants.BUTTON_GEAR_HOPPER));
		GearManipulatorInst.GearFlapOpen(Pad.getRawButton(Constants.BUTTON_GEAR_FLAP));
	}

	@Override
	public void testPeriodic()
	{

	}
}