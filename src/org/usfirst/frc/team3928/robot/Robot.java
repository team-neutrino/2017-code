package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Victor;


public class Robot extends SampleRobot {
	
	Victor vic0;
	Victor vic1;
	Joystick rightJoy;
	Joystick leftJoy;
	
	public Robot() {
		vic0 = new Victor(0);
		vic1 = new Victor(1);
	}

	@Override
	public void robotInit() {
	}

	@Override
	public void autonomous() {
	}

	@Override
	public void operatorControl() {
		vic0.set(Math.pow(leftJoy.getY(), 2));
		vic1.set(Math.pow(rightJoy.getY(), 2));
	}

	@Override
	public void test() {
	}
}
