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
//		shoot = new Shooter();
//		 intake = new Intake();
		JoyRight = new Joystick(Constants.JOY_LEFT_CHANNEL);
		JoyLeft = new Joystick(Constants.JOY_RIGHT_CHANNEL);
		cam = new Camera("cam0");
		System.out.println(100.);
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
	public void teleopInit()
	{
	}
	@Override
	public void teleopPeriodic()
	{
		DriveInst.setRight(-JoyRight.getY());
		DriveInst.setLeft(-JoyLeft.getY());	
		
		
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