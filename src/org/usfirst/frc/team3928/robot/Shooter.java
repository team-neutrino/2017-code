package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Shooter implements Runnable{

	private SpeedController leftMotor;
	private SpeedController rightMotor;
	private Encoder encoder;
	private boolean threadRunning;
	
	public Shooter()
	{
		threadRunning = false;
		
		if (Constants.REAL_ROBOT)
		{

		} else
		{
			leftMotor = new Victor(Constants.SHOOTER_1_POWER_CHANNEL);
			rightMotor = new Victor(Constants.SHOOTER_2_POWER_CHANNEL);
			
			encoder = new Encoder(Constants.ENCODER_DRIVE_LEFT_CHANNEL_A, Constants.ENCODER_SHOOTER_CHANNEL_B);
			double distPerRev = Math.PI * Constants.SHOOTER_WHEEL_DIAMETER; 
			double distPerPulse = distPerRev / Constants.PULSE_PER_REV;
			encoder.setDistancePerPulse(distPerPulse);
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
		double power = Constants.SHOOTER_BASE_SPEED;
		
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
		leftMotor.set(0);
		rightMotor.set(0);
		
	}
	
	

}
