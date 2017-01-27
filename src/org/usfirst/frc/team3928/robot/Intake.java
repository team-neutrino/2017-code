package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Intake implements Runnable{

	private SpeedController leftMotor;
	private SpeedController rightMotor;
	private boolean threadRunning;
	
	public Intake()
	{
		threadRunning = false;
		
		if (Constants.REAL_ROBOT)
		{

		} else
		{
			leftMotor = new Victor(Constants.SHOOTER_1_POWER_CHANNEL);
			rightMotor = new Victor(Constants.SHOOTER_2_POWER_CHANNEL);
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
		double power = Constants.INTAKE_BASE_SPEED;
		
		while(threadRunning)
		{
			leftMotor.set(power);
			leftMotor.set(-power);
		}
		leftMotor.set(0);
		rightMotor.set(0);
		
	}
	
	

}

