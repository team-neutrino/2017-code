package org.usfirst.frc.team3928.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Object that runs the entire robot. Compensation for creating these javadoc
 * comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class Robot extends IterativeRobot {

	private Drive DriveInst;
	private Joystick JoyRight;
	private Joystick JoyLeft;
	private Joystick Pad;
	private BallManager Elevate;
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
	}

	/**
	 * Initializes the autonomous.
	 */
	@Override
	public void autonomousInit() {
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
		DriveInst.setRight((JoyLeft.getRawButton(Constants.BUTTON_HALF_SPEED) || JoyRight.getRawButton(Constants.BUTTON_HALF_SPEED)) ? -JoyRight.getY()/2 : -JoyRight.getY());
		DriveInst.setLeft((JoyLeft.getRawButton(Constants.BUTTON_HALF_SPEED) || JoyRight.getRawButton(Constants.BUTTON_HALF_SPEED)) ? -JoyRight.getY()/2 : -JoyRight.getY());

		
		Elevate.Intake(Pad.getRawButton(Constants.BUTTON_INTAKE));
		Elevate.Shoot(Pad.getRawButton(Constants.BUTTON_SHOOT));
		BeCreative.Tilt(Pad.getRawButton(Constants.BUTTON_FLAP));
		Elevate.SpinUpShooter(Pad.getRawButton(Constants.BUTTON_SHOOTER_SPIN_UP));
	}

	@Override
	public void testPeriodic() {

	}
}