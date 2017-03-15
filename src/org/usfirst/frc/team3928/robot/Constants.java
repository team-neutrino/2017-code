package org.usfirst.frc.team3928.robot;

/**
 * List of constants used in other classes. Compensation for creating these
 * javadoc comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class Constants
{
	public static final boolean REAL_ROBOT = false;

	// Drive
	public static final int DRIVE_RIGHT_1_CHANNEL = 3;
	public static final int DRIVE_RIGHT_2_CHANNEL = 4;
	public static final int DRIVE_LEFT_1_CHANNEL = 1;
	public static final int DRIVE_LEFT_2_CHANNEL = 2;
	public static final int DRIVE_RIGHT_1_POWER_CHANNEL = 13;
	public static final int DRIVE_RIGHT_2_POWER_CHANNEL = 12;
	public static final int DRIVE_LEFT_1_POWER_CHANNEL = 15;
	public static final int DRIVE_LEFT_2_POWER_CHANNEL = 14;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_A = 0;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_B = 1;
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_A = 2;
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_B = 3;
	public static final double DRIVE_WHEEL_DIAMETER = 4;
	public static final double DRIVE_TURN_RADIUS = 14.9;
	public static final double DRIVE_DISTANCE_PER_TURN_DEGREE = 2 * DRIVE_TURN_RADIUS * Math.PI / 360;
	public static final int DRIVE_GYRO_CHANNEL = 0;
	public static final int DRIVE_TIME_PER_INCH = 100; // In ms
	public static final int DRIVE_TIME_PER_DEGREE = 100; // in degrees
	public static final int DRIVE_CYCLES_PER_REV = 360;
	public static final int DRIVE_PULSE_PER_REV = DRIVE_CYCLES_PER_REV * 4;
	public static final double DRIVE_PID_P = 0; // TODO
	public static final double DRIVE_PID_I = 0; // TODO
	public static final double DRIVE_PID_D = 0; // TODO

	// Gear Manipulator
	public static final int GEAR_FLAP_SOLENOID_A_CHANNEL = 5;
	public static final int GEAR_FLAP_SOLENOID_B_CHANNEL = 4;
	public static final int GEAR_HOPPER_SOLENOID_A_CHANNEL = 3;
	public static final int GEAR_HOPPER_SOLENOID_B_CHANNEL = 2;
	public static final int GEAR_DROP_SOLENOID_A_CHANNEL = 6;
	public static final int GEAR_DROP_SOLENOID_B_CHANNEL = 7;

	// Intake
	public static final int INTAKE_SOLENOID_A_CHANNEL = 0;
	public static final int INTAKE_SOLENOID_B_CHANNEL = 1;
	public static final int INTAKE_POWER_CHANNEL = 9;
	public static final int INTAKE_CHANNEL = 9;
	public static final double INTAKE_SPEED = -0.7; // TODO
	public static final double SHOOTER_FOR_INTAKE_SPEED = .13; // Correction for wires that were soldered on with opposite polarity

	// Elevator
	public static final int ELEVATOR_CHANNEL = 8;
	public static final int ELEVATOR_POWER_CHANNEL = 10;
	public static final double ELEVATOR_SHOOT_SPEED = .75;
	public static final double ELEVATOR_INTAKE_SPEED = .6;

	// Shooter
	public static final int SHOOTER_1_POWER_CHANNEL = 1;
	public static final int SHOOTER_2_POWER_CHANNEL = 0;
	public static final int SHOOTER_1_CHANNEL = 5;
	public static final int SHOOTER_2_CHANNEL = 6;
	public static final int SHOOTER_BEAM_BREAK_POWER_CHANNEL = 6;
	public static final int SHOOTER_BEAM_BREAK_CHANNEL = 9;
	public static final double SHOOTER_P = 0.25; // TODO
	public static final double SHOOTER_I = 0; // TODO
	public static final double SHOOTER_D = 0; // TODO
	public static final double SHOOTER_TARGET_SPEED = 53;

	public static final int AGITATOR_CHANNEL = 0;
	public static final int AGITATOR_POWER_CHANNEL = 9;

	// Climber
	public static final int CLIMBER_POWER_CHANNEL = 11;
	public static final int CLIMBER_CHANNEL = 7;

	// Camera
	public static final int CAMERA_GREEN_MAX = 255;
	public static final int CAMERA_GREEN_MIN = 0;
	public static final int CAMERA_BLUE_MAX = 255;
	public static final int CAMERA_BLUE_MIN = 100;
	public static final int CAMERA_RED_MAX = 73;
	public static final int CAMERA_RED_MIN = 30;
	public static final int CAMERA_XRES = 640;
	public static final int CAMERA_YRES = 480;

	// Joysticks
	public static final int JOY_RIGHT_CHANNEL = 2;
	public static final int JOY_LEFT_CHANNEL = 1;
	public static final int JOY_PAD_CHANNEL = 0;

	// Buttons
	public static final int BUTTON_HALF_SPEED = 1; // joystick right trigger
	public static final int BUTTON_INVERT_DIRECTION = 1; // joystick left trigger
	public static final int BUTTON_SHOOT = 2; // joystick top
	public static final int BUTTON_DRIVE_STRAIGHT = 3; //joystick top
	public static final int BUTTON_SHOOTER_SPIN_UP = 2; // gamepad left trigger
	public static final int BUTTON_INTAKE = 5; // gamepad left bumper
	public static final int BUTTON_GEAR_DROP = 3; //gamepad right trigger
	public static final int BUTTON_GEAR_FLAP = 6; //gamepad right bumper
	public static final int BUTTON_GEAR_MOVE = 2; // gamepad b
	public static final int BUTTON_CLIMB = 4; //gamepad y

	// Auton mode
	public static final int AUTON_GEAR_FORWARD_WAIT_TIME = 500; // in ms
	public static final double AUTON_DRIVE_SPEED = .5;
	public static final double AUTON_TURN_SPEED = .2;
	public static final int AUTON_SWITCH_CHANNEL_1 = 1;
	public static final int AUTON_SWITCH_CHANNEL_2 = 2;
	public static final int AUTON_SWITCH_CHANNEL_3 = 3;
}
