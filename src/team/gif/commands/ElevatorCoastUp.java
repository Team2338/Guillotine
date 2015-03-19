package team.gif.commands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorCoastUp extends Command {
	
	private static double topVal = 7992;

	public ElevatorCoastUp() {
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.drive(Robot.elevator.getHeight() + 325);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.elevator.getMax())
    	{
    		topVal = Robot.elevator.getHeight();
    		Robot.elevator.drive(topVal);
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Globals.elevatorSetpoint = topVal;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Globals.elevatorSetpoint = Robot.elevator.getHeight();
    }
}
