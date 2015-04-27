package team.gif.commands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevBumpDown extends Command {

    public ElevBumpDown() {
        requires(Robot.elevator);
    }

    protected void initialize() {
    	Robot.elevator.drive(Robot.elevator.getHeight() - 200);
    	Globals.elevatorSetpoint = Robot.elevator.getSetpoint();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
