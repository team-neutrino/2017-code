package org.usfirst.frc.team3928.robot;

public class Constants
{
	public static final boolean REAL_ROBOT = false;
	
	//drive constants
	public static final int DRIVE_RIGHT_1_CHANNEL = 0;
	public static final int DRIVE_RIGHT_2_CHANNEL = 1;
	public static final int DRIVE_LEFT_1_CHANNEL = 2;
	public static final int DRIVE_LEFT_2_CHANNEL = 3;
	
	public static final int DRIVE_RIGHT_1_POWER_CHANNEL = 0;
	public static final int DRIVE_RIGHT_2_POWER_CHANNEL = 1;
	public static final int DRIVE_LEFT_1_POWER_CHANNEL = 2;
	public static final int DRIVE_LEFT_2_POWER_CHANNEL = 3;
	
	public static final int ENCODER_DRIVE_RIGHT_CHANNEL_A = 0; //TODO
	public static final int ENCODER_DRIVE_RIGHT_CHANNEL_B = 1; //TODO
	public static final int ENCODER_DRIVE_LEFT_CHANNEL_A = 2; //TODO
	public static final int ENCODER_DRIVE_LEFT_CHANNEL_B = 3; //TODO
	public static final int ANALOG_CHANNEL = 5; //TODO
	public static final double DRIVE_WHEEL_DIAMETER = 4;
	public static final int CYCLES_PER_REV = 360;
	public static final int PULSE_PER_REV = CYCLES_PER_REV * 4;
	
	//driver station constants
	public static final int JOY_RIGHT_CHANNEL = 2;
	public static final int JOY_LEFT_CHANNEL = 1;
	
	//gear manipulation constants
	public static final int GEAR_FLAP_SOLENOID_CHANNEL_A = 0; //TODO
	public static final int GEAR_FLAP_SOLENOID_CHANNEL_B = 1; //TODO
	public static final int GEAR_SOLENOID_CHANNEL_A = 2; //TODO
	public static final int GEAR_SOLENOID_CHANNEL_B = 3; //TODO
	
	//camera constants
	public static final int CAMERA_B_MAX = 255;
	public static final int CAMERA_B_MIN = 50;
	public static final int CAMERA_G_MAX = 255;
	public static final int CAMERA_G_MIN = 50;
	public static final int CAMERA_R_MAX = 35;
	public static final int CAMERA_R_MIN = 25;
	
	//shooter and intake constants
	public static final int SHOOTER_1_POWER_CHANNEL = 4; //TODO
	public static final int SHOOTER_2_POWER_CHANNEL = 5; //TODO
	public static final int INTAKE_1_POWER_CHANNEL = 6; //TODO
	public static final int INTAKE_2_POWER_CHANNEL = 7; //TODO
	
	public static final int SHOOTER_ENCODER_CHANNEL_A = 4; //TODO
	public static final int SHOOTER_ENCODER_CHANNEL_B = 5; //TODO
	
	public static final double SHOOTER_TARGET_PULSES_PER_ROTATION = 0; //TODO Tony has a problem with this
	
	public static final double HOPPER_SHOOTER_TARGET_SPEED = 0; //TODO
	public static final double SHOOTER_TARGET_SPEED = 0; //TODO
	public static final double INTAKE_SPEED = 0; //TODO
	
	public static final int SHOOT_OR_HOP_SOL_CHANNEL_A = 4; //TODO
	public static final int SHOOT_OR_HOP_SOL_CHANNEL_B = 5; //TODO


}
