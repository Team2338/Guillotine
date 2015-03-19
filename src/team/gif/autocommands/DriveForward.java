package team.gif.autocommands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {
	private double driveForwardSpeed = .2;
	private double distanceLeft;
	private double distanceRight;
	private double errorLeft;
	private double errorRight;
	private final double TOLERANCE = 150;
	private double KP = .001;

	public DriveForward() {
		this(1000, 1000);
		KP = .001;
	}

	public DriveForward(double dist) {
		this(dist, dist);
		KP = 0.1;
	}

	public DriveForward(double distLeft, double distRight) {
		KP = 1;
		requires(Robot.chassis);
		distanceLeft = distLeft;
		distanceRight = distRight;
	}

	protected void initialize() {
		Robot.chassis.enableManualControl();
		Robot.chassis.resetEncoders();
	}

	protected void execute() {
		errorLeft = (distanceLeft - Robot.chassis.getLeftDistance());
		if (Math.abs(driveForwardSpeed * KP * errorLeft) >= driveForwardSpeed) {
			Robot.chassis.driveLeft(driveForwardSpeed * (errorLeft/Math.abs(errorLeft)));
		} else {
			Robot.chassis.driveLeft(driveForwardSpeed * KP * errorLeft);
		}
		
		errorRight = (distanceRight - Robot.chassis.getRightDistance());
		if (Math.abs(driveForwardSpeed * KP * errorRight) >= driveForwardSpeed) {
			Robot.chassis.driveRight(driveForwardSpeed * (errorRight/Math.abs(errorRight)));
		} else {
			Robot.chassis.driveRight(driveForwardSpeed * KP * errorRight);
		}
	}

	protected boolean isFinished() {
		if ((Math.abs(errorLeft) <= TOLERANCE) && (Math.abs(errorRight) <= TOLERANCE))
		{
			Robot.chassis.tankDrive(0, 0);
			return true;
		}
		return false;
	}

	protected void end() {
		Robot.chassis.tankDrive(0, 0);
	}

	protected void interrupted() {
		end();
	}
}
