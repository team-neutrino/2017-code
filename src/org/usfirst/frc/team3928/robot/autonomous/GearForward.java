package org.usfirst.frc.team3928.robot.autonomous;

import org.usfirst.frc.team3928.robot.subsytems.BallManager;
import org.usfirst.frc.team3928.robot.subsytems.Drive;
import org.usfirst.frc.team3928.robot.subsytems.GearManipulator;

public class GearForward extends AutonModes
{
	public GearForward(Drive driveInst, GearManipulator gearManipulatorInst, BallManager ballManagerInst)
	{
		super(driveInst, gearManipulatorInst, ballManagerInst);
	}

	public void execute()
	{
		//DriveInst.DriveDistance(120, 0.8);
	    if(DriveInst.getCamera().getIsTracking())
	    {
	    	System.out.println("is tracking");
	    	DriveInst.DriveToTarget();
	    	try
			{
				Thread.sleep(1000);
				DriveInst.DriveDistance(4, 0.3);
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    else
	    {
	    	DriveInst.DriveDistance(76, 0.35);
	    }
		GearManipulatorInst.GearDrop(true);
		
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DriveInst.DriveDistance(-20, 0.35);
		GearManipulatorInst.GearDrop(false);
	}
}
