package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Object that runs the entire robot. Compensation for creating these javadoc
 * comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class Robot extends IterativeRobot
{
	
	private Drive DriveInst;
	private Joystick JoyRight;
	private Joystick JoyLeft;
	private Joystick Pad;
	private BallManager Elevate;
	private Camera Cam;

	/**
	 * Initializes the robot.
	 */
	@Override
	public void robotInit()
	{
		//DriveInst = new Drive();
		//Elevate = new Elevator();
		JoyRight = new Joystick(Constants.JOY_LEFT_CHANNEL);
		JoyLeft = new Joystick(Constants.JOY_RIGHT_CHANNEL);
		Cam = new Camera("cam0");
	}

	/**
	 * Initializes the autonomous.
	 */
	@Override
	public void autonomousInit()
	{
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
//		DriveInst.setRight(-JoyRight.getY());
//		DriveInst.setLeft(-JoyLeft.getY());

		if (Pad.getRawButton(Constants.BUTTON_INTAKE)) // TODO
		{
		}
		else
		{
		}
		
		if (Pad.getRawButton(Constants.BUTTON_SHOOT)) // TODO
		{
			
		}
		else
		{
		}
	}
	
	@Override
	public void testPeriodic()
	{

	}
}