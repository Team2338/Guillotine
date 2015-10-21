package team.gif.subsystems;

import team.gif.Globals;
import team.gif.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author NotPatrick & PatrickUbelhor
 */
public class Drivetrain extends Subsystem {
    
	private static final CANTalon frontLeft = new CANTalon(RobotMap.frontLeft);
	private static final CANTalon frontRight = new CANTalon(RobotMap.frontRight);
	private static final CANTalon rearLeft = new CANTalon(RobotMap.rearLeft);
	private static final CANTalon rearRight = new CANTalon(RobotMap.rearRight);
	
	public Drivetrain() {
		super();
    	
    	frontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		frontLeft.reverseSensor(Globals.leftEncoderReversed);
		frontLeft.reverseOutput(Globals.frontLeftMotorReversed);
		
		frontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		frontRight.reverseSensor(Globals.rightEncoderReversed);
		frontRight.reverseOutput(Globals.frontRightMotorReversed);
    	
		frontRight.setPosition(0);
    	frontLeft.setPosition(0);
    	
    	frontLeft.changeControlMode(ControlMode.PercentVbus);
    	frontRight.changeControlMode(ControlMode.PercentVbus);
    	rearLeft.changeControlMode(ControlMode.Follower);
    	rearRight.changeControlMode(ControlMode.Follower);
    	
    	rearLeft.reverseOutput(Globals.rearLeftMotorReversed);
    	
    	frontLeft.set(0);
    	frontRight.set(0);
    	rearLeft.set(RobotMap.frontLeft);
    	rearRight.set(RobotMap.rearRight);
	}
	
	
	public void tankDrive(double left, double right) {
		driveLeft(left);
		driveRight(right);
	}
	
    public void driveLeft(double setpoint) {
    	frontLeft.set(setpoint);
    	rearLeft.set(RobotMap.frontLeft);
    }
    
    public void driveRight(double setpoint) {
    	frontRight.set(-setpoint);
    	rearRight.set(RobotMap.frontRight);
    }
    
    public double getLeftDistance() {
    	return frontLeft.getPosition();
    }
    
    public double getRightDistance() {
    	return frontRight.getPosition();
    }
    
    public void resetEncoders() {
    	frontRight.setPosition(0);
    	frontLeft.setPosition(0);
    }
    
    public void initDefaultCommand() {}
    
}
