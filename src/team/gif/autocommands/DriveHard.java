package team.gif.autocommands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveHard extends Command {

	private double initTime = 0;
	private double endTime;
	private double rate;
	
    public DriveHard(double speed, double time) {
        requires(Robot.chassis);
        rate = speed;
        endTime = time;
    }

    protected void initialize() {
    	Robot.chassis.enableManualControl();
    	initTime = Timer.getFPGATimestamp();
    }

    protected void execute() {
    	Robot.chassis.tankDrive(rate, rate);
    }

    protected boolean isFinished() {
        return (Timer.getFPGATimestamp() - initTime > endTime);
    }

    protected void end() {
    	Robot.chassis.tankDrive(0, 0);
    }

    protected void interrupted() {
    }
}
