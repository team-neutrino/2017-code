package org.usfirst.frc.team3928.robot;

public abstract class AutonModes
{
    protected Drive DriveInst;
    protected GearManipulator Gear;
    protected Shooter Shoot;

    public AutonModes(Drive driveInst, GearManipulator gear, Shooter shoot)
    {
	DriveInst = driveInst;
	Gear = gear;
	Shoot = shoot;
	Gear.open(true);
	Gear.tilt(false);
    }

    public abstract void execute();
}
