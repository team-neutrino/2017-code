package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.Constants;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * This is the class that takes input form the auton switch
 * 
 * @author YouKnowWho
 *
 */
public class RotarySwitch
{
	private DigitalInput Bit1;
	private DigitalInput Bit2;
	private DigitalInput Bit3;
	private DigitalInput Bit4;

	/**
	 * Constructs the the channels for the auton switch
	 */
	public RotarySwitch()
	{
		Bit1 = new DigitalInput(Constants.AUTON_SWITCH_CHANNEL_1);
		Bit2 = new DigitalInput(Constants.AUTON_SWITCH_CHANNEL_2);
		Bit3 = new DigitalInput(Constants.AUTON_SWITCH_CHANNEL_3);
		Bit4 = new DigitalInput(Constants.AUTON_SWITCH_CHANNEL_4);
	}

	/**
	 * Calculates the value of the auton switch setting
	 * 
	 * @return 
	 * 		The current number that the rotary switch is on
	 */
	public int getValue()
	{
		int total = 0;

		if (!Bit1.get())
		{
			total = total + 1;
		}

		if (!Bit2.get())
		{
			total = total + 2;
		}

		if (!Bit3.get())
		{
			total = total + 4;
		}

		if (!Bit4.get())
		{
			total = total + 8;
		}

		return total;
	}
}
