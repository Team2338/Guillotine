package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class CollectorOpen extends Command {

    public CollectorOpen() {
        requires(Robot.collectorPneumo);
    }

    protected void initialize() {
    	Robot.collectorPneumo.open();
    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
