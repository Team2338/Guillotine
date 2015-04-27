package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Tyler
 */
public class fastriggerStandby extends Command {

    public fastriggerStandby() {
        requires(Robot.fastrigger);
    }

  
    protected void initialize() {}

  
    protected void execute() {
    	Robot.fastrigger.drive(0.0);
    }

   
    protected boolean isFinished() {
        return false;
    }

   
    protected void end() {}

    
    protected void interrupted() {}
}
