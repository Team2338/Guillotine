package team.gif.commands;

import team.gif.OI;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class HolderSet extends Command {

	private boolean open = true;
	private boolean held = false;
	
    public HolderSet() {
        requires(Robot.holder);
    }

    protected void initialize() {
    	Robot.holder.open();
    }

    protected void execute() {
    	if (open) {
    		Robot.holder.open();
    	} else {
    		Robot.holder.close();
    	}
    	
    	if (OI.aux11.get() && !held) {
    		open = !open;
    		held = true;
    	} else {
    		if (!OI.aux11.get()) {
    			held = false;
    		}
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
