package team.gif.commands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Tyler
 */
public class PusherExtend extends Command {

    public PusherExtend() {
    	requires(Robot.pusher);
        
    }

    
    protected void initialize() {
    }

  
    protected void execute() {
    	if (Robot.pusher.getMax()) {
    		Robot.pusher.setSpeed(Globals.pusherSpeed);
    	} else {
    		Robot.pusher.setSpeed(0);
    	}
    }


    protected boolean isFinished() {
        return !Robot.pusher.getMax();
    }

    
    protected void end() {
    	Robot.pusher.setSpeed(0);
    }

   
    protected void interrupted() {
    }
}
