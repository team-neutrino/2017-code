package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.Solenoid;

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

}
