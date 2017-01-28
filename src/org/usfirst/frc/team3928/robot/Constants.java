package org.usfirst.frc.team3928.robot;

public class Constants
{
	public static final boolean REAL_ROBOT = false;
	
	public static final int DRIVE_RIGHT_1_CHANNEL = 0;
	public static final int DRIVE_RIGHT_2_CHANNEL = 1;
	public static final int DRIVE_LEFT_1_CHANNEL = 2;
	public static final int DRIVE_LEFT_2_CHANNEL = 3;
	

	public static final int SOLENOID_FLAP_CHANNEL = 2; //TODO
	public static final int SOLENOID_CHANNEL_1 = 2; //TODO
	
	public static final int BMax = 255;
	public static final int BMin = 50;
	public static final int GMax = 255;
	public static final int GMin = 50;
	public static final int RMax = 35;
	public static final int RMin = 25;
	
	public static final double SHOOTER_TARGET_PULSES_PER_ROTATION = 0; //TODO
	
	public static final int DRIVE_RIGHT_1_POWER_CHANNEL = 0;
	public static final int DRIVE_RIGHT_2_POWER_CHANNEL = 1;
	public static final int DRIVE_LEFT_1_POWER_CHANNEL = 2;
	public static final int DRIVE_LEFT_2_POWER_CHANNEL = 3;
	public static final int SHOOTER_1_POWER_CHANNEL = 0; //TODO
	public static final int SHOOTER_2_POWER_CHANNEL = 0; //TODO
	public static final int INTAKE_1_POWER_CHANNEL = 0; //TODO
	public static final int INTAKE_2_POWER_CHANNEL = 0; //TODO
	
	public static final int JOY_RIGHT_CHANNEL = 2;
	public static final int JOY_LEFT_CHANNEL = 1;
	
	public static final int ENCODER_DRIVE_RIGHT_CHANNEL_A = 0;
	public static final int ENCODER_DRIVE_RIGHT_CHANNEL_B = 2;
	public static final int ENCODER_DRIVE_LEFT_CHANNEL_A = 3;
	public static final int ENCODER_DRIVE_LEFT_CHANNEL_B = 4;
	public static final int ENCODER_SHOOTER_CHANNEL_A = 0; //TODO
	public static final int ENCODER_SHOOTER_CHANNEL_B = 0; //TODO

	public static final int SHOOTER_FOR_INTAKE_BASE_SPEED = 0; //TODO
	public static final int SHOOTER_BASE_SPEED = 0; //TODO
	public static final int INTAKE_BASE_SPEED = 0; //TODO

	public static final double EXPECTED_RATE_INTAKE = 0; //TODO
	public static final double EXPECTED_RATE_SHOOTER = 0; //TODO
	public static final double DRIVE_WHEEL_DIAMETER = 4;
	public static final double SHOOTER_WHEEL_DIAMETER = 0; //TODO
	public static final int CYCLES_PER_REV = 360;
	public static final int PULSE_PER_REV = CYCLES_PER_REV * 4;

}