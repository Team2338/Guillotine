package team.gif.autocommands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class LeftKinematic extends Command {
	
	private double dist;
	private double vel;
	private double time = 0;
	private double initTime = 0;
	private boolean isFinished = false;

    public LeftKinematic(double dist, double vel) {
    	if (vel == 0) throw new RuntimeException("The value of \'vel\' cannot be 0!");
    	
    	if ((dist < 0 && vel > 0) || (dist > 0 && vel < 0)) vel = -vel;
    	
    	this.dist = dist;
    	this.vel = vel;
    }

    protected void initialize() {
    	Robot.chassis.resetEncoders(); // TODO: separate left and right reset
    	time = dist / vel;
    	initTime = Timer.getFPGATimestamp();
    }

    protected void execute() {
    	
    	if (time - Globals.kinematicTolerance < 0) {
    		Robot.chassis.driveLeft(vel / Globals.drivetrainMaxVelLeft);
    		time = (dist - Robot.chassis.getLeftDistance()) / vel;
    	} else {
    		isFinished = true;
    	}
    	
    	
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    	Robot.chassis.driveLeft(0);
    }

    protected void interrupted() {}
    
}
