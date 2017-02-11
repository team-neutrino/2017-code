package org.usfirst.frc.team3928.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class BallManager
{
	private SpeedController IntakeMotor;
	private SpeedController ShooterLeft;
	private SpeedController ShooterRight;
	private SpeedController ElevatorMotor;

	private Counter ShooterBeamBreak;
	private Solenoid FlapSolenoidA;
	private Solenoid FlapSolenoidB;

	private boolean ShooterRunning;
	private boolean IntakeRunning;

	public BallManager()
	{
		IntakeRunning = false;
		ShooterRunning = false;
		ShooterBeamBreak = new Counter(Constants.SHOOTER_BEAM_BREAK_CHANNEL);
		ShooterBeamBreak.setDistancePerPulse(1);
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
		else if (!IntakeRunning)
		{
			ElevatorMotor.set(0);
		}
	}

	public void Intake(boolean isIntaking)
	{
		FlapSolenoidA.set(isIntaking);
		FlapSolenoidB.set(!isIntaking);
		IntakeRunning = isIntaking;
		if (isIntaking)
		{
			IntakeMotor.set(Constants.INTAKE_SPEED);
			ElevatorMotor.set(Constants.ELEVATOR_INTAKE_SPEED);
			ShooterRight.set(Constants.SHOOTER_FOR_INTAKE_SPEED);
			ShooterLeft.set(Constants.SHOOTER_FOR_INTAKE_SPEED);
		}
		else
		{
			IntakeMotor.set(0);
		}
		// If shooter and intake are not running, shut off the elevator and
		// shooter wheels
		if (!ShooterRunning && !IntakeRunning)
		{
			ElevatorMotor.set(0);
			ShooterRight.set(0);
			ShooterLeft.set(0);
		}
	}

	public void SpinUpShooter(boolean isRunning)
	{
		if (!ShooterRunning && isRunning)
		{
			ShooterRunning = isRunning;

			new Thread(new Runnable()
			{
				public void run()
				{
					double speed = 1;
					while (ShooterRunning)
					{
						if (ShooterBeamBreak.getRate() < Constants.SHOOTER_TARGET_SPEED)
						{
							speed += .05;
						}
						else if (ShooterBeamBreak.getRate() > Constants.SHOOTER_TARGET_SPEED)
						{
							speed -= .05;
						}
						ShooterLeft.set(speed);
						ShooterRight.set(speed);
					}
				}
			}).start();
		}
		else if(!isRunning)
		{
			ShooterRunning = false;
		}

		if (!ShooterRunning && !IntakeRunning)
		{
			ShooterLeft.set(0);
			ShooterRight.set(0);
		}

	}

}
