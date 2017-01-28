package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.Solenoid;

<<<<<<< HEAD
public class GearManipulator
{

    /*
     * TODO private / public on variables member variables capitalized fix
     * capitalizations of functions 2 sol instances per physical sol
     */

    Solenoid sol1;
    Solenoid sol2;
    Solenoid flap1;
    Solenoid flap2;

    public GearManipulator()
    {
	sol1 = new Solenoid(Constants.SOLENOID_CHANNEL_1);
	flap1 = new Solenoid(Constants.SOLENOID_FLAP_CHANNEL);
	open(true);
	tilt(false);
	// set sol2 and flap2
    }

    public void open(boolean isOpen)
    {
	flap1.set(isOpen);
	flap2.set(!isOpen);
    }

    public void tilt(boolean isTilted)
    {
	sol1.set(isTilted);
	sol2.set(!isTilted);
    }

=======
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
>>>>>>> origin/master
}
