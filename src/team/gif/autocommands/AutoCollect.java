package team.gif.autocommands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class AutoCollect extends Command {

    public AutoCollect() {
        requires(Robot.collectorMotors);
    }

    protected void initialize() {
    	Robot.collectorMotors.drive(1, 1);
    }

    protected void execute() {}

    protected boolean isFinished() {
        return Robot.collectorMotors.getLimit();
    }

    protected void end() {
    	Robot.collectorMotors.drive(0, 0);
    }

    protected void interrupted() {
    	Robot.collectorMotors.drive(0, 0);
    }
    
}
