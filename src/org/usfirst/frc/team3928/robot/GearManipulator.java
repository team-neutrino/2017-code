package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class GearManipulator {

	Solenoid sol1;
	Solenoid flap;
	
	public GearManipulator()
	{
		sol1 = new Solenoid(Constants.SOLENOID_CHANNEL_1);
		flap = new Solenoid(Constants.SOLENOID_FLAP_CHANNEL);
	}

	public void close()
	{
		flap.set(false);
	}
	public void open()
	{
		flap.set(true);
	}
	public void tilt()
	{
		sol1.set(true);
	}
	public void untilt()
	{
		sol1.set(false);
	}
	
	
}
