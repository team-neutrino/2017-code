package org.usfirst.frc.team3928.robot;

/**
 * List of constants used in other classes. Compensation for creating these
 * javadoc comments is the author tag.
 * 
 * @author JamesBeetham
 */
public class Constants
{
	public static final boolean REAL_ROBOT = true;

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
	public static final double DRIVE_TURN_RADIUS = 12; //14.9
	public static final double DRIVE_DISTANCE_PER_TURN_DEGREE = 2 * DRIVE_TURN_RADIUS * Math.PI / 360;
	public static final int DRIVE_GYRO_CHANNEL = 0;
	public static final int DRIVE_TIME_PER_INCH = 100; // In ms
	public static final int DRIVE_TIME_PER_DEGREE = 100; // in degrees
	public static final int DRIVE_CYCLES_PER_REV = 360;
	public static final int DRIVE_PULSE_PER_REV = DRIVE_CYCLES_PER_REV * 4;

	// Gear Manipulator
	public static final int GEAR_HOPPER_SOLENOID_A_CHANNEL = 4;
	public static final int GEAR_HOPPER_SOLENOID_B_CHANNEL = 5;
	public static final int GEAR_DROP_SOLENOID_A_CHANNEL = 6;
	public static final int GEAR_DROP_SOLENOID_B_CHANNEL = 7;
	
	// Floor Gear Manipulator 
	public static final int FLOOR_GEAR_INTAKE_POWER_CHANNEL = 9; //old intake power channel
	public static final int FLOOR_GEAR_INTAKE_CHANNEL = 9; //old intake channel
	public static final double FLOOR_GEAR_INTAKE_SPEED = 1;
	public static final double FLOOR_GEAR_OUTTAKE_SPEED = -1;
	public static final int FLOOR_GEAR_INTAKE_BEAM_BREAK_POWER_CHANNEL = 0; //TODO
	public static final int FLOOR_GEAR_INTAKE_BEAM_BREAK_CHANNEL = 0; //TODO
	public static final int FLOOR_GEAR_DOWN_SOLENOID_A_CHANNEL = 1;
	public static final int FLOOR_GEAR_DOWN_SOLENOID_B_CHANNEL = 0;
	
	// Elevator
	public static final int ELEVATOR_CHANNEL = 8;
	public static final int ELEVATOR_POWER_CHANNEL = 10;
	public static final double ELEVATOR_SHOOT_SPEED = 1;

	// Shooter
	public static final int SHOOTER_1_POWER_CHANNEL = 1;
	public static final int SHOOTER_2_POWER_CHANNEL = 0;
	public static final int SHOOTER_1_CHANNEL = 5;
	public static final int SHOOTER_2_CHANNEL = 6;
	public static final int SHOOTER_BEAM_BREAK_POWER_CHANNEL = 6;
	public static final int SHOOTER_BEAM_BREAK_CHANNEL = 9;
	public static final double SHOOTER_P = 0.05; // TODO
	public static final double SHOOTER_I = 0; // TODO
	public static final double SHOOTER_D = 0; // TODO
	public static final double SHOOTER_TARGET_SPEED = 20; //competition = 54, demo = 

	public static final int AGITATOR_CHANNEL = 0;
	public static final int AGITATOR_POWER_CHANNEL = 9;

	// Climber
	public static final int CLIMBER_POWER_CHANNEL = 11;
	public static final int CLIMBER_CHANNEL = 7;
	
	//Camera
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
	public static final int BUTTON_CLIMB = 8; //gamepad start
	public static final int BUTTON_CLIMB_BACKWARDS = 7; //gamepad back
	public static final int BUTTON_SHOOTER_SPIN_UP = 4; // gamepad y
	public static final int BUTTON_GEAR_DROP = 3; //gamepad right trigger
	public static final int BUTTON_GEAR_MOVE = 6; //gamepad right bumper
	public static final int BUTTON_FLOOR_GEAR_INTAKE = 5; // gamepad left bumper
	public static final int BUTTON_FLOOR_GEAR_OUTTAKE = 2; //gamepad left trigger
	public static final int BUTTON_FLOOR_GEAR_DOWN = 2; //gamepad b

	// Auton mode
	public static final int AUTON_GEAR_FORWARD_WAIT_TIME = 1000; // in ms
	public static final double AUTON_DRIVE_SPEED = .5;
	public static final double AUTON_TURN_SPEED = .2;
	public static final double AUTON_GEAR_START_X = 180;
	public static final double AUTON_GEAR_START_Y = 62;
	public static final double AUTON_GEAR_TARGET_X = 310; //250
	public static final double AUTON_GEAR_TARGET_Y = 21;
	public static final double AUTON_SHOOT_START_X = 163;
	public static final double AUTON_SHOOT_START_Y = 105;
	public static final double AUTON_SHOOT_TARGET_X = 180;
	public static final double AUTON_SHOOT_TARGET_Y = 2;
	public static final int AUTON_SWITCH_CHANNEL_1 = 4;
	public static final int AUTON_SWITCH_CHANNEL_2 = 5;
	public static final int AUTON_SWITCH_CHANNEL_3 = 6;
	public static final int AUTON_SWITCH_CHANNEL_4 = 7;
}
