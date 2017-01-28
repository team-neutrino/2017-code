package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Intake implements Runnable{

	private SpeedController LeftMotor;
	private SpeedController RightMotor;
	
	private SpeedController ShooterLeftMotor;
	private SpeedController ShooterRightMotor;
	
	private boolean threadRunning;
	
	public Intake()
	{
		threadRunning = false;
		
		if (Constants.REAL_ROBOT)
		{

		} else
		{
			ShooterLeftMotor = new Victor(Constants.SHOOTER_1_POWER_CHANNEL);
			ShooterRightMotor = new Victor(Constants.SHOOTER_2_POWER_CHANNEL);
			LeftMotor = new Victor(Constants.INTAKE_1_POWER_CHANNEL);
			RightMotor = new Victor(Constants.INTAKE_2_POWER_CHANNEL);
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
			ShooterLeftMotor.set(Constants.HOPPER_SHOOTER_TARGET_SPEED);
			ShooterRightMotor.set(-Constants.HOPPER_SHOOTER_TARGET_SPEED);
			LeftMotor.set(Constants.INTAKE_SPEED);
			RightMotor.set(-Constants.INTAKE_SPEED);
		}

		ShooterLeftMotor.set(0);
		ShooterRightMotor.set(0);
		LeftMotor.set(0);
		RightMotor.set(0);
		
	}
	
	

}

