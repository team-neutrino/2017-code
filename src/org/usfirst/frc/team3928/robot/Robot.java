package org.usfirst.frc.team3928.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 * Object that runs the entire robot. Compensation for creating these javadoc
 * comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class Robot extends IterativeRobot {
    private SpeedController Climber;
    private Drive DriveInst;
    private Joystick JoyRight;
    private Joystick JoyLeft;
    private Joystick Pad;
    private BallManager2 Elevate;
    private Camera Cam;
    private GearManipulator BeCreative;

    /**
     * Initializes the robot.
     */
    @Override
    public void robotInit() {
	DriveInst = new Drive();
	JoyRight = new Joystick(Constants.JOY_LEFT_CHANNEL);
	JoyLeft = new Joystick(Constants.JOY_RIGHT_CHANNEL);
	Pad = new Joystick(Constants.JOY_PAD_CHANNEL);
	Cam = new Camera("cam0");

	BeCreative = new GearManipulator();
	Elevate = new BallManager2();
	if(Constants.REAL_ROBOT)
	{
	    Climber = new CANTalon(Constants.CLIMBER_CHANNEL);
	}
	else
	{
	    Climber = new Victor(Constants.CLIMBER_CHANNEL);
	}
    }

    /**
     * Initializes the autonomous.
     */
    @Override
    public void autonomousInit() {
	AutonModes mode = new GearLeft(DriveInst, BeCreative, Elevate);
	mode.execute();
    }

    /**
     * Calls periodically over autonomous
     */
    @Override
    public void autonomousPeriodic() {
    }

    /**
     * Initializes the teleop.
     */
    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {
	DriveInst.setRight((JoyRight.getRawButton(Constants.BUTTON_HALF_SPEED) || JoyRight.getRawButton(Constants.BUTTON_HALF_SPEED)) ? JoyRight.getY()/2 : JoyRight.getY());
	DriveInst.setLeft((JoyLeft.getRawButton(Constants.BUTTON_HALF_SPEED) || JoyLeft.getRawButton(Constants.BUTTON_HALF_SPEED)) ? -JoyLeft.getY()/2 : -JoyLeft.getY());
	
	System.out.println(JoyLeft.getY());
	System.out.println(JoyRight.getY());
	

	Elevate.Intake(Pad.getRawButton(Constants.BUTTON_INTAKE));
	Elevate.Shoot(Pad.getRawButton(Constants.BUTTON_SHOOT));
	//		BeCreative.Tilt(Pad.getTrigger());
			Elevate.SpinUpShooter(Pad.getRawButton(Constants.BUTTON_SHOOTER_SPIN_UP));

	//		if(Pad.getRawButton(Constants.BUTTON_CLIMBER))
	//		{
	//		    Climber.set(.5);
	//		}
	//		else
	//		{
	//		    Climber.set(0);
	//		}
    }

    @Override
    public void testPeriodic() {

    }
}