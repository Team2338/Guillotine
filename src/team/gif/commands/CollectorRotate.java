package team.gif.commands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class CollectorRotate extends Command {

	private boolean rotDir;
	
    public CollectorRotate(boolean direction) {
        requires(Robot.collectorMotors);
        rotDir = direction;
        
    }

    protected void initialize() {}

    protected void execute() {
    	if (rotDir) {
    		Robot.collectorMotors.drive(Globals.collectorSpeed, -Globals.collectorSpeed);
    	} else {
    		Robot.collectorMotors.drive(-Globals.collectorSpeed, Globals.collectorSpeed);
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
