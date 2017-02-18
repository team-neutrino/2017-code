package org.usfirst.frc.team3928.robot;

/**
 * List of constants used in other classes. Compensation for creating these
 * javadoc comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class ConstantsPractice
{
	public static final boolean REAL_ROBOT = false;

	// Drive
	public static final int DRIVE_RIGHT_1_CHANNEL = 2;
	public static final int DRIVE_RIGHT_2_CHANNEL = 3;
	public static final int DRIVE_LEFT_1_CHANNEL = 0;
	public static final int DRIVE_LEFT_2_CHANNEL = 1;
	public static final int DRIVE_RIGHT_1_POWER_CHANNEL = 13;
	public static final int DRIVE_RIGHT_2_POWER_CHANNEL = 12;
	public static final int DRIVE_LEFT_1_POWER_CHANNEL = 15;
	public static final int DRIVE_LEFT_2_POWER_CHANNEL = 14;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_A = 0;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_B = 1;
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_A = 2;
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_B = 3;
	public static final double DRIVE_WHEEL_DIAMETER = 4;
	public static final double DRIVE_TURN_RADIUS = Math.pow((33 * 33 + 29 * 29), 0.5) / 2;
	public static final double DRIVE_DISTANCE_PER_TURN_DEGREE = Math.pow(DRIVE_TURN_RADIUS, 2) * Math.PI / 360;
	public static final int DRIVE_GYRO_CHANNEL = 0;
	public static final int DRIVE_TIME_PER_INCH = 100; // In ms
	public static final int DRIVE_TIME_PER_DEGREE = 100; // in degrees
	public static final int DRIVE_CYCLES_PER_REV = 360;
	public static final int DRIVE_PULSE_PER_REV = DRIVE_CYCLES_PER_REV * 4;

	// Gear Manipulator
	public static final int GEAR_FLAP_SOLENOID_A_CHANNEL = 4;
	public static final int GEAR_FLAP_SOLENOID_B_CHANNEL = 5;
	public static final int GEAR_HOPPER_SOLENOID_A_CHANNEL = 2;
	public static final int GEAR_HOPPER_SOLENOID_B_CHANNEL = 3;

	// Intake
	public static final int INTAKE_SOLENOID_A_CHANNEL = 0;
	public static final int INTAKE_SOLENOID_B_CHANNEL = 1;
	public static final int INTAKE_POWER_CHANNEL = 9;
	public static final int INTAKE_CHANNEL = 4;
	public static final double INTAKE_SPEED = -.5; // TODO
	public static final double SHOOTER_FOR_INTAKE_SPEED = .15;

	// Elevator
	public static final int ELEVATOR_CHANNEL = 5; // TODO
	public static final int ELEVATOR_POWER_CHANNEL = 10;
	public static final double ELEVATOR_SHOOT_SPEED = .85;
	public static final double ELEVATOR_INTAKE_SPEED = .5;

	// Shooter
	public static final int SHOOTER_1_POWER_CHANNEL = 1;
	public static final int SHOOTER_2_POWER_CHANNEL = 0;
	public static final int SHOOTER_1_CHANNEL = 6;
	public static final int SHOOTER_2_CHANNEL = 7;
	public static final int SHOOTER_BEAM_BREAK_CHANNEL = 9; // TODO
	public static final double SHOOTER_P = 0.5; // TODO
	public static final double SHOOTER_I = 0; // TODO
	public static final double SHOOTER_D = 0; // TODO
	public static final double SHOOTER_TARGET_SPEED = 23;

	// Climber
	public static final int CLIMBER_CHANNEL = 8;
	public static final int CLIMBER_POWER_CHANNEL = 11; // TODO

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

	// Button Mappers
	public static final int BUTTON_HALF_SPEED = 1; // trigger
	public static final int BUTTON_INTAKE = 5; // left bumper
	public static final int BUTTON_SHOOT = 2;
	public static final int BUTTON_GEAR_HOPPER = 2; // b
	public static final int BUTTON_CLIMBER = 0; // XBox button
	public static final int BUTTON_GEAR_FLAP = 10; // right trigger
	public static final int BUTTON_SHOOTER_SPIN_UP = 6; // R bumper
	public static final int BUTTON_AIM_AT_GEAR = 0;

	// Auton mode
	public static final int AUTON_GEAR_FORWARD_PICKUP_TIME = 2000; // in ms
	public static final double AUTON_DRIVE_SPEED = .5;
	public static final double AUTON_TURN_SPEED = .2;
}
