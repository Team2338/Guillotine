package team.gif.autocommands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class AutoDrivePID extends Command {

	private double leftSet;
	private double rightSet;
	private double l = 0;
	private double r = 0;
	private double initTime = 0;
	
    public AutoDrivePID(double leftSetpoint, double rightSetpoint) {
        requires(Robot.chassis);
        leftSet = leftSetpoint;
        rightSet = rightSetpoint;
    }

    protected void initialize() {
    	Robot.chassis.enablePositionControl();
    	initTime = Timer.getFPGATimestamp();
    	
    	if (leftSet > 1000) {
    		l = 1000;
    	} else {
    		l = leftSet;
    	}
    	
    	if (rightSet > 1000) {
    		r = 1000;
    	} else {
    		r = rightSet;
    	}
    }

    protected void execute() {
    	l = l + ((Timer.getFPGATimestamp() - initTime) * 100);
    	r = r + ((Timer.getFPGATimestamp() - initTime) * 100);
    	
    	if (l < leftSet) {
    		Robot.chassis.driveLeft(l);
    	} else {
    		Robot.chassis.driveLeft(leftSet);
    	}
    	
    	if (r < rightSet) {
    		Robot.chassis.driveRight(r);
    	} else {
    		Robot.chassis.driveRight(rightSet);
    	}
    }

    protected boolean isFinished() {
    	return (Math.abs(Robot.chassis.getLeftError()) < 100 && Math.abs(Robot.chassis.getRightError()) < 100);
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
