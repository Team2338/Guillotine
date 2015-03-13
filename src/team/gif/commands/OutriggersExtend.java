package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OutriggersExtend extends Command {

    public OutriggersExtend() {
        requires(Robot.outriggers);
    }

    protected void initialize() {
    	Robot.outriggers.lower();
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
