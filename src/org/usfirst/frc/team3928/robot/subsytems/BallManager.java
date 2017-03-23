package org.usfirst.frc.team3928.robot.subsytems;

import org.usfirst.frc.team3928.robot.Constants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Manages the balls. Compensation for creating these javadoc comments is the
 * author tag.
 * 
 * @author JamesBeetham
 */
public class BallManager extends PIDSubsystem
{
	private SpeedController ShooterLeft;
	private SpeedController ShooterRight;
	private SpeedController ElevatorMotor;

	private Relay Agitator;

	private Counter ShooterBeamBreak;

	private boolean ShooterRunning;
	private boolean IntakeRunning;

	private long LastCheckTime;

	/**
	 * Constructs a new ball manager using values in the constants file.
	 */
	public BallManager()
	{
		super(Constants.SHOOTER_P, Constants.SHOOTER_I, Constants.SHOOTER_D);
		IntakeRunning = false;
		ShooterRunning = false;
		ShooterBeamBreak = new Counter(Constants.SHOOTER_BEAM_BREAK_CHANNEL);
		ShooterBeamBreak.setDistancePerPulse(1);

		Agitator = new Relay(Constants.AGITATOR_CHANNEL);

		if (Constants.REAL_ROBOT)
		{
			ShooterLeft = new CANTalon(Constants.SHOOTER_1_CHANNEL);
			ShooterRight = new CANTalon(Constants.SHOOTER_2_CHANNEL);

			ElevatorMotor = new CANTalon(Constants.ELEVATOR_CHANNEL);
		}
		else
		{
			ShooterLeft = new Victor(Constants.SHOOTER_1_CHANNEL);
			ShooterRight = new Victor(Constants.SHOOTER_2_CHANNEL);

			ElevatorMotor = new Victor(Constants.ELEVATOR_CHANNEL);
		}
	}

	/**
	 * Sets the flap to shooting position and turns elevator on.
	 * 
	 * @param isShooting
	 *            true to start shooter
	 */
	public void Shoot(boolean isShooting)
	{
		if (isShooting)
		{
			ElevatorMotor.set(Constants.ELEVATOR_SHOOT_SPEED);
			Agitator.set(Relay.Value.kForward);
		}
		else if (!IntakeRunning)
		{
			ElevatorMotor.set(0);
			Agitator.set(Relay.Value.kOff);
		}
		else
		{
			Agitator.set(Relay.Value.kOff);
		}
	}


	/**
	 * Spins the shooter up.
	 * 
	 * @param isRunning
	 *            true to start shooter up, false to stop it
	 */
	public void SpinUpShooter(boolean isRunning)
	{
		if (!ShooterRunning && isRunning)
		{
			ShooterRunning = isRunning;
			super.setSetpoint(Constants.SHOOTER_TARGET_SPEED);
			super.enable();
		}
		else if (!isRunning)
		{
			ShooterRunning = false;
		}

		if (!ShooterRunning && !IntakeRunning)
		{
			ShooterLeft.set(0);
			ShooterRight.set(0);
			super.setSetpoint(0);
			super.disable();
		}

	}

	@Override
	protected double returnPIDInput()
	{
		double rate = ShooterBeamBreak.getRate();
		System.out.println(ShooterBeamBreak.getRate());
		return rate;
	}

	@Override
	protected void usePIDOutput(double output)
	{
		if (output < 0)
		{
			output = 0;
		}
		// Correction for wires that were soldered on with opposite polarity
		if (Constants.REAL_ROBOT)
		{
			output = -output;
		}
		ShooterRight.set(output);
		ShooterLeft.set(output);
	}

	@Override
	protected void initDefaultCommand()
	{
		// TODO Auto-generated method stub

	}

	// TODO can remove?
	private double getShooterRate()
	{
		long time = System.currentTimeMillis() - LastCheckTime;
		double rate = ShooterBeamBreak.getRate() / time;
		LastCheckTime = System.currentTimeMillis();
		return rate;
	}
}
