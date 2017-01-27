package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;

public class Robot extends IterativeRobot
{
	Drive DriveInst;
	Joystick JoyRight;
	Joystick JoyLeft;

	@Override
	public void robotInit()
	{
		DriveInst = new Drive();
		JoyRight = new Joystick(Constants.JOY_LEFT_CHANNEL);
		JoyLeft = new Joystick(Constants.JOY_RIGHT_CHANNEL);
		Camera cam = new Camera("cam0");
	}

	@Override
	public void autonomousInit()
	{
	}

	@Override
	public void autonomousPeriodic()
	{
	}

	@Override
	public void teleopPeriodic()
	{
		DriveInst.SetRight(Math.pow(-JoyRight.getY(), 2));
		DriveInst.SetLeft(Math.pow(-JoyLeft.getY(), 2));

	}

	@Override
	public void testPeriodic()
	{
	}
}