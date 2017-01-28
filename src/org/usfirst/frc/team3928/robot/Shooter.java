package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Shooter implements Runnable{

	private SpeedController leftMotor;
	private SpeedController rightMotor;
	private Encoder encoder;
	private Solenoid sol1;
	private boolean threadRunning;
	private Solenoid shooterSol;
	
	public Shooter()
	{
		threadRunning = false;
		
		if (Constants.REAL_ROBOT)
		{

		} else
		{
			Solenoid sol1 = new Solenoid(Constants.SOLENOID_INTAKE_CHANNEL_1);
			leftMotor = new Victor(Constants.SHOOTER_1_POWER_CHANNEL);
			rightMotor = new Victor(Constants.SHOOTER_2_POWER_CHANNEL);
			
			encoder = new Encoder(Constants.SHOOTER_ENCODER_CHANNEL_A, Constants.SHOOTER_ENCODER_CHANNEL_B);
		}
	}
	
	public void shoot()
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
<<<<<<< HEAD
		double power = Constants.SHOOTER_BASE_SPEED;
		sol1.set(true);
		while(threadRunning)
		{
			if(encoder.getRate() < Constants.EXPECTED_RATE_SHOOTER)
			{
				power += .01;
			}
			if(encoder.getRate() > Constants.EXPECTED_RATE_SHOOTER)
			{
				power -= .01;
			}
			
			leftMotor.set(power);
			leftMotor.set(-power);
		}
		
		sol1.set(false);
		
		leftMotor.set(0);
		rightMotor.set(0);
=======
>>>>>>> origin/master
		
	}
	
	

}
