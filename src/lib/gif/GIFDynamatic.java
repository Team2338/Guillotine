package lib.gif;

import team.gif.Globals;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class GIFDynamatic extends Command {
	
	private double dist;
	private double vel;
	private double time = 0;
	private boolean isFinished = false;
	private final GIFSubsystem subsystem;

    public GIFDynamatic(GIFSubsystem subsystem, double dist, double vel) {
    	
    	if (vel == 0) throw new RuntimeException("The value of \'vel\' cannot be 0!");
    	
    	if ((dist < 0 && vel > 0) || (dist > 0 && vel < 0)) vel = -vel;
    	
    	this.dist = dist;
    	this.vel = vel;
    	this.subsystem = subsystem;
    	requires(subsystem);
    }

    protected void initialize() {
    	subsystem.resetEncoder();
    	time = dist / vel;
    }

    protected void execute() {
    	
    	if (time - Globals.kinematicTolerance < 0) {
    		subsystem.drive(vel / Globals.drivetrainMaxVelLeft);
    		time = (dist - subsystem.getDistance()) / vel;
    	} else {
    		isFinished = true;
    	}
    	
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    	subsystem.drive(0);
    	// TODO: Replace the above statement with a call to the subsystem's standby command
    }

    protected void interrupted() {}
    
}