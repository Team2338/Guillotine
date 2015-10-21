package team.gif.commands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class CollectorEject extends Command {

    public CollectorEject() {
        requires(Robot.collectorMotors);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.collectorMotors.drive(-Globals.collectorSpeed, -Globals.collectorSpeed);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
