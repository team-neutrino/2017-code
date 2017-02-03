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

    //Drive
    public static final int DRIVE_RIGHT_1_CHANNEL = 0;
    public static final int DRIVE_RIGHT_2_CHANNEL = 1;
    public static final int DRIVE_LEFT_1_CHANNEL = 2;
    public static final int DRIVE_LEFT_2_CHANNEL = 3;
    public static final int DRIVE_RIGHT_1_POWER_CHANNEL = 0;
    public static final int DRIVE_RIGHT_2_POWER_CHANNEL = 1;
    public static final int DRIVE_LEFT_1_POWER_CHANNEL = 2;
    public static final int DRIVE_LEFT_2_POWER_CHANNEL = 3;
    public static final int DRIVE_ENCODER_RIGHT_CHANNEL_A = 0;
    public static final int DRIVE_ENCODER_RIGHT_CHANNEL_B = 2;
    public static final int DRIVE_ENCODER_LEFT_CHANNEL_A = 3;
    public static final int DRIVE_ENCODER_LEFT_CHANNEL_B = 4;
    public static final double DRIVE_WHEEL_DIAMETER = 4;
    public static final int DRIVE_GYRO_CHANNEL = 2; // TODO
    public static final int DRIVE_TIME_PER_INCH = 100; // In ms
    public static final int DRIVE_TIME_PER_DEGREE = 100; // in degrees
    public static final int DRIVE_CYCLES_PER_REV = 360;
    public static final int DRIVE_PULSE_PER_REV = DRIVE_CYCLES_PER_REV * 4;
    public static final double DRIVE_PID_P = 0; //TODO
    public static final double DRIVE_PID_I = 0; //TODO
    public static final double DRIVE_PID_D = 0; //TODO

    //Gear Manipulator
    public static final int GEAR_SOLENOID_FLAP_A_CHANNEL = 2; // TODO
    public static final int GEAR_SOLENOID_A_CHANNEL = 2; // TODO
    public static final int GEAR_SOLENOID_FLAP_B_CHANNEL = 2; // TODO
    public static final int GEAR_SOLENOID_B_CHANNEL_1 = 2; // TODO

    //Intake
    public static final int INTAKE_SOLENOID_A_CHANNEL = 2; // TODO
    public static final int INTAKE_SOLENOID_B_CHANNEL = 2; // TODO
    public static final int INTAKE_1_POWER_CHANNEL = 0; // TODO
    public static final int INTAKE_2_POWER_CHANNEL = 0; // TODO
    public static final double INTAKE_SPEED = 0; // TODO
    public static final int SHOOTER_FOR_INTAKE_SPEED = 0; // TODO
    
    //Elevator
    public static final int ELEVATOR_CHANNEL = 0; //TODO
    public static final int ELEVATOR_POWER_CHANNEL = 0; // TODO
    public static final double ELEVATOR_SHOOT_SPEED = 0; //TODO

    //Shooter
    public static final int SHOOTER_1_POWER_CHANNEL = 0; // TODO
    public static final int SHOOTER_2_POWER_CHANNEL = 0; // TODO
    public static final int SHOOTER_1_CHANNEL = 0; // TODO
    public static final int SHOOTER_2_CHANNEL = 0; // TODO
    public static final int SHOOTER_ENCODER_CHANNEL_A = 0; // TODO
    public static final int SHOOTER_ENCODER_CHANNEL_B = 0; // TODO
    public static final int SHOOTER_TARGET_SPEED = 0; // TODO
    public static final double SHOOTER_WHEEL_DIAMETER = 0; // TODO
    public static final double SHOOTER_PID_P = 0; //TODO
    public static final double SHOOTER_PID_I = 0; //TODO
    public static final double SHOOTER_PID_D = 0; //TODO
    public static final int SHOOTER_CYCLES_PER_REV = 360; //TODO
    public static final int SHOOTER_PULSE_PER_REV = SHOOTER_CYCLES_PER_REV * 4;

    //Camera
    public static final int CAMERA_GREEN_MAX = 255;
    public static final int CAMERA_GREEN_MIN = 0;
    public static final int CAMERA_BLUE_MAX = 255;
    public static final int CAMERA_BLUE_MIN = 100;
    public static final int CAMERA_RED_MAX = 73;
    public static final int CAMERA_RED_MIN = 30;

    //Joysticks
    public static final int JOY_RIGHT_CHANNEL = 2;
    public static final int JOY_LEFT_CHANNEL = 1;

    //Button Mappers
    public static final int BUTTON_HALF_SPEED = 0; //trigger
    public static final int BUTTON_INTAKE = 0; //left bumper
    public static final int BUTTON_SHOOT = 2; //TODO
    public static final int BUTTON_GEAR_TOGGLE_GEAR = 0; //x
    public static final int BUTTON_CLIMBER = 0; //XBox button
    public static final int BUTTON_FLAP = 0; //R Tigger
    public static final int BUTTON_SHOOTER_SPIN_UP = 0; //R bumper
    public static final int BUTTON_AIM_AT_GEAR = 2;

    //Encoder Magic Numbers

    // Auton mode
    public static final int AUTON_GEAR_FORWARD_PICKUP_TIME = 2000; // in ms
}
