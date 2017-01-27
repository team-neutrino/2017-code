package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot
{
	Drive DriveInst;
	Joystick JoyRight;
	Joystick JoyLeft;
	Joystick pad;
	Shooter shoot;
	Intake intake;
	Camera cam;

	@Override
	public void robotInit()
	{
		DriveInst = new Drive();
		shoot = new Shooter();
		 intake = new Intake();
		JoyRight = new Joystick(Constants.JOY_LEFT_CHANNEL);
		JoyLeft = new Joystick(Constants.JOY_RIGHT_CHANNEL);
		cam = new Camera("cam0");
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
		DriveInst.setRight(Math.pow(-JoyRight.getY(), 2));
		DriveInst.setLeft(Math.pow(-JoyLeft.getY(), 2));
		
		if(pad.getRawButton(0)) //TODO
		{
			intake.intake();
		}
		if(pad.getRawButton(0)) //TODO
		{
			shoot.shoot();
		}
	}

	@Override
	public void testPeriodic()
	{
	}
}