package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HooksExtend extends Command {

    public HooksExtend() {
        requires(Robot.hooks);
    }

    protected void initialize() {
    	Robot.hooks.open();
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
