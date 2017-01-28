package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class GearManipulator {

	private Solenoid GearSolA;
	private Solenoid GearSolB;
	private Solenoid GearFlapSolA;
	private Solenoid GearFlapSolB;
	
	public GearManipulator()
	{
		GearSolA = new Solenoid(Constants.GEAR_SOLENOID_CHANNEL_A);
		GearSolB = new Solenoid(Constants.GEAR_SOLENOID_CHANNEL_B);
		GearFlapSolA = new Solenoid(Constants.GEAR_FLAP_SOLENOID_CHANNEL_A);
		GearFlapSolB = new Solenoid(Constants.GEAR_FLAP_SOLENOID_CHANNEL_B);
	}

	public void Open(boolean open)
	{
		GearFlapSolA.set(open);
		GearFlapSolB.set(!open);
	}

	public void Tilt(boolean tilt)
	{
		GearSolA.set(tilt);
		GearSolB.set(!tilt);
	}
}
