package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HooksRetract extends Command {

    public HooksRetract() {
        requires(Robot.hooks);
    }

    protected void initialize() {
    	Robot.hooks.close();
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
