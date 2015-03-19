package team.gif.autocommands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpdateElevPos extends Command {

    public UpdateElevPos() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	Globals.elevManualPos = Robot.elevator.getHeight();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
