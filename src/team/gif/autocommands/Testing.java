package team.gif.autocommands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Testing extends Command {

	double initTime = 0;
	
    public Testing() {
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.resetEncoders();
    	initTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.driveLeft(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - initTime >= 10;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.driveLeft(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
