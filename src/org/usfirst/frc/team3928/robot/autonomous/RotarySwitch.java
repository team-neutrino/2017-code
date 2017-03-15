package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.Constants;

import edu.wpi.first.wpilibj.DigitalInput;

public class RotarySwitch
{
    private DigitalInput Bit1;
    private DigitalInput Bit2;
    private DigitalInput Bit3;
    
    public RotarySwitch()
    {
	Bit1 = new DigitalInput(Constants.AUTON_SWITCH_CHANNEL_1);
	Bit2 = new DigitalInput(Constants.AUTON_SWITCH_CHANNEL_2);
	Bit3 = new DigitalInput(Constants.AUTON_SWITCH_CHANNEL_3);
    }
    
    public int getValue()
    {
	int total = 0;
	
	if (Bit1.get())
	{
	    total = total + 1;
	}
	
	if (Bit2.get())
	{
	    total = total + 2;
	}
	
	if (Bit3.get())
	{
	    total = total + 4;
	}
	
	return total;
	//return (Bit1.get()) ? 1 : 0 + ((Bit2.get()) ? 2 : 0) + ((Bit3.get()) ? 4 : 0);
    }
}
