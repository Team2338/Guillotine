package team.gif.autocommands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author PatrickUbelhor
 */
public class LeftProfile extends Command {
	
	private double riseTime;
	private double maxVel;
	private double acc;
	private double coastTime;
	private boolean done = false;
	
	private PIDCalculator pid = new PIDCalculator();
	private double initTime = 0;
	private double feedforward = 0;
	private double error = 0;
	private boolean first = false;
	private boolean second = false;

    public LeftProfile(double riseTime, double dist, double maxSpeed) {
        
    	if (maxSpeed == 0) throw new RuntimeException("Max speed cannot be zero!");
		riseTime = Math.abs(riseTime);
		if (dist < 0 && maxSpeed > 0) maxSpeed = -maxSpeed; // Motors are inverted; positive speed is reverse
		
		if (riseTime != 0) {
			acc = maxSpeed / riseTime;
			
			if (acc * riseTime * riseTime > Math.abs(dist)) {			// Triangle Profile
				coastTime = 0;
				// d = a*t^2
				// t^2 = d/a
				riseTime = Math.sqrt(dist / acc);
			} else {													// Trapezoidal Profile
				coastTime = (dist - (maxSpeed * riseTime)) / maxSpeed;
			}
			
		} else {														// Rectangular Profile
			acc = 0;
			riseTime = 0;
			coastTime = dist / maxSpeed;
		}
		
		this.riseTime = riseTime;
		this.maxVel = maxSpeed;
    	
    }

    protected void initialize() {
    	initTime = Timer.getFPGATimestamp();
    	feedforward = 0;
    	first = riseTime == 0; //false; cancels acceleration phase if unnecessary
    	second = false;
    	done = false;
    }

    protected void execute() {
		
		// Accelerate to max velocity
		if ((Timer.getFPGATimestamp() - initTime < riseTime) && !first) {
			feedforward = acc * (Timer.getFPGATimestamp() - initTime);
			//error = (0.5 * feedforward * (Timer.getFPGATimestamp() - initTime)) - Robot.chassis.getLeftDistance();
			drive(feedforward);// + pid.calculateGain(error));
			SmartDashboard.putNumber("Speed", feedforward);
		} else if (!first) {
			initTime = Timer.getFPGATimestamp();
			first = true;
		}
		
		// Maintain max velocity
		if ((Timer.getFPGATimestamp() - initTime < coastTime) && first && !second) {
			//error = (0.5 * maxVel * riseTime) + (maxVel * (Timer.getFPGATimestamp() - initTime)) - Robot.chassis.getLeftDistance();
			feedforward = maxVel;
			drive(feedforward);// + pid.calculateGain(error));
			SmartDashboard.putNumber("Time", Timer.getFPGATimestamp() - initTime);
		} else if (!second && first) {
			initTime = Timer.getFPGATimestamp();
			second = true;
			if (riseTime == 0) {
				done = true;
				drive(0);
			}
		}
		
		// Decelerate to zero
		if ((Timer.getFPGATimestamp() - initTime < riseTime) && second) {
			feedforward = acc * (riseTime + initTime - Timer.getFPGATimestamp());
			//error = ((0.5 * maxVel * riseTime) + (maxVel * coastTime) +
					//(0.5 * (Timer.getFPGATimestamp() - initTime) * (maxVel + feedforward))) - Robot.chassis.getLeftDistance();
			drive(feedforward);// + pid.calculateGain(error));
		} else if (first && second) {
			done = true;
		}
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {}

    protected void interrupted() {}
    
    private void drive(double velocity) {
		if (velocity > 1) {
			System.err.println("Attempting to go above 100% speed!");
		}
		Robot.chassis.driveLeft(-velocity / Globals.drivetrainMaxVel);
	}
	
	private class PIDCalculator {
		private double iAccum = 0;
		private double lastError = 0;
		private double lastTime = 0;
		private double slope = 0;
		
		private double calculateGain(double error) {
			iAccum += error;
			slope = (error - lastError) / (Timer.getFPGATimestamp() - lastTime);
			lastError = error;
			lastTime = Timer.getFPGATimestamp();
			return (error * Globals.motionProfilerP) + (iAccum * Globals.motionProfilerI) + (slope * Globals.motionProfilerD);
		}
	}
}
