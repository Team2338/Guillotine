package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Tyler
 */
public class PusherStandby extends Command {

    public PusherStandby() {
        requires(Robot.pusher);
    }

  
    protected void initialize() {
    }

  
    protected void execute() {
    	Robot.pusher.setSpeed(0.0);
    }

   
    protected boolean isFinished() {
        return false;
    }

   
    protected void end() {
    }

    
    protected void interrupted() {
    }
}
