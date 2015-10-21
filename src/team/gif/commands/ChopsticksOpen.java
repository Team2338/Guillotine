package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class ChopsticksOpen extends Command {

    public ChopsticksOpen() {
        requires(Robot.chopsticks);
    }

    protected void initialize() {
    	Robot.chopsticks.open();
    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
