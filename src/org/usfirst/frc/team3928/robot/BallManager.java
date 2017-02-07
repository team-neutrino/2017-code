package org.usfirst.frc.team3928.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class BallManager extends PIDSubsystem
{
    private SpeedController IntakeMotor;
    private SpeedController ShooterLeft;
    private SpeedController ShooterRight;
    private SpeedController ElevatorMotor;

    private Encoder ShooterEncoder;

    private Solenoid FlapSolenoidA;
    private Solenoid FlapSolenoidB;

    public BallManager()
    {
	super(Constants.SHOOTER_PID_P, Constants.SHOOTER_PID_I, Constants.SHOOTER_PID_D);
	ShooterEncoder = new Encoder(Constants.SHOOTER_ENCODER_CHANNEL_A, Constants.SHOOTER_ENCODER_CHANNEL_B);
	ShooterEncoder.setDistancePerPulse(1 / Constants.SHOOTER_PULSE_PER_REV);
	FlapSolenoidA = new Solenoid(Constants.INTAKE_SOLENOID_A_CHANNEL);
	FlapSolenoidB = new Solenoid(Constants.INTAKE_SOLENOID_B_CHANNEL);
	FlapSolenoidA.set(false);
	FlapSolenoidB.set(true);
	if (Constants.REAL_ROBOT)
	{
	    IntakeMotor = new CANTalon(Constants.INTAKE_CHANNEL);

	    ShooterLeft = new CANTalon(Constants.SHOOTER_1_CHANNEL);
	    ShooterRight = new CANTalon(Constants.SHOOTER_2_CHANNEL);

	    ElevatorMotor = new CANTalon(Constants.ELEVATOR_CHANNEL);
	}
	else
	{
	    IntakeMotor = new Victor(Constants.INTAKE_CHANNEL);

	    ShooterLeft = new Victor(Constants.SHOOTER_1_CHANNEL);
	    ShooterRight = new Victor(Constants.SHOOTER_2_CHANNEL);

	    ElevatorMotor = new Victor(Constants.ELEVATOR_CHANNEL);
	}
    }

    // Set flap to shoot, turns elevator on.
    public void Shoot(boolean isShooting)
    {
	FlapSolenoidA.set(isShooting);
	FlapSolenoidB.set(!isShooting);
	if (isShooting)
	{
	    ElevatorMotor.set(Constants.ELEVATOR_SHOOT_SPEED);
	}
	else
	{
	    ElevatorMotor.set(0);
	}
    }

    public void SpinUpShooter(boolean spin)
    {
	if (spin)
	{
	    getPIDController().setSetpoint(Constants.SHOOTER_TARGET_SPEED);
	}
	else
	{
	    getPIDController().setSetpoint(0);
	}
    }

    public void StopShooter()
    {
	getPIDController().setSetpoint(0);
    }

    public void Intake(boolean isIntaking)
    {
	FlapSolenoidA.set(isIntaking);
	FlapSolenoidB.set(!isIntaking);
	if (isIntaking)
	{
	    IntakeMotor.set(Constants.INTAKE_SPEED);
	    ElevatorMotor.set(Constants.ELEVATOR_INTAKE_SPEED);
	    getPIDController().setSetpoint(Constants.SHOOTER_FOR_INTAKE_SPEED);
	}
	else
	{ 
	    ElevatorMotor.set(0);
	    IntakeMotor.set(0);
	    getPIDController().setSetpoint(0);
	}
    }

    @Override
    protected double returnPIDInput()
    {
	return ShooterEncoder.getRate() * 60;
    }

    @Override
    protected void usePIDOutput(double output)
    {
	ShooterRight.pidWrite(-output);
	ShooterLeft.pidWrite(output);
    }

    @Override
    protected void initDefaultCommand()
    {
    }

}
