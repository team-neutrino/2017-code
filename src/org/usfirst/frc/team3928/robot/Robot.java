package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;

public class Robot extends IterativeRobot {
	
	Victor driveRight1;
	Victor driveRight0;
	Victor driveLeft1;
	Victor driveLeft0;
	
	Joystick joyLeft;
	Joystick joyRight;
	
	@Override
	public void robotInit() {
		
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void teleopPeriodic() {
		
		driveLeft1.set(Math.pow(joyLeft.getY(), 2));
		driveLeft0.set(Math.pow(joyLeft.getY(), 2));
		
		driveRight1.set(Math.pow(joyRight.getY(), 2));
		driveRight0.set(Math.pow(joyRight.getY(), 2));
	}

	@Override
	public void testPeriodic() {
	}
}