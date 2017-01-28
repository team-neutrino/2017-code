package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Intake implements Runnable{

	private SpeedController leftMotor;
	private SpeedController rightMotor;
	
	private SpeedController shooterLeftMotor;
	private SpeedController shooterRightMotor;
	
	private boolean threadRunning;
	
	public Intake()
	{
		threadRunning = false;
		
		if (Constants.REAL_ROBOT)
		{

		} else
		{
			shooterLeftMotor = new Victor(Constants.SHOOTER_1_POWER_CHANNEL);
			shooterRightMotor = new Victor(Constants.SHOOTER_2_POWER_CHANNEL);
			leftMotor = new Victor(Constants.INTAKE_1_POWER_CHANNEL);
			rightMotor = new Victor(Constants.INTAKE_2_POWER_CHANNEL);
		}
	}
	
	public void intake()
	{
		if (!threadRunning)
		{
			threadRunning = true;
			new Thread(this).start();
		}
	}
	
	public void stop()
	{
		threadRunning = false;
	}

	@Override
	public void run() {
		
		while(threadRunning)
		{
			shooterLeftMotor.set(Constants.SHOOTER_FOR_INTAKE_BASE_SPEED);
			shooterRightMotor.set(-Constants.SHOOTER_FOR_INTAKE_BASE_SPEED);
			leftMotor.set(Constants.INTAKE_BASE_SPEED);
			rightMotor.set(-Constants.INTAKE_BASE_SPEED);
		}

		shooterLeftMotor.set(0);
		shooterRightMotor.set(0);
		leftMotor.set(0);
		rightMotor.set(0);
		
	}
	
	

}

