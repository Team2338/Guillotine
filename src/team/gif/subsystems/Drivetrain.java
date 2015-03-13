package team.gif.subsystems;

import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.TankDriveLinear;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author PatrickUbelhor
 */
public class Drivetrain extends Subsystem {
    
	private static final CANTalon frontLeft = new CANTalon(RobotMap.frontLeft);
	private static final CANTalon frontRight = new CANTalon(RobotMap.frontRight);
	private static final CANTalon rearLeft = new CANTalon(RobotMap.rearLeft);
	private static final CANTalon rearRight = new CANTalon(RobotMap.rearRight);
	
	public Drivetrain() {
		super();
		enablePositionControl();
	}
	
	public void setPID(double p, double i, double d) {
		frontLeft.setPID(p, i, d);
		frontRight.setPID(p, i, d);
	}
	
	public double getLeftSetpoint() {
		return frontLeft.getSetpoint();
	}
	
	public double getRightSetpoint() {
		return frontRight.getSetpoint();
	}
	
	public double getLeftError() {
		return frontLeft.getClosedLoopError();
	}
	
	public double getRightError() {
		return frontRight.getClosedLoopError();
	}
	
	public int getLeftTicks() {
		return frontLeft.getEncPosition();
	}
	
	public int getRightTicks() {
		return frontRight.getEncPosition();
	}
    
    public void driveLeft(double setpoint) {
    	frontLeft.set(setpoint);
    	rearLeft.set(RobotMap.frontLeft);
    }
    
    public void driveRight(double setpoint) {
    	frontRight.set(-setpoint);
    	rearRight.set(RobotMap.frontRight);
    }
    
    public void enablePositionControl() {
    	frontLeft.changeControlMode(ControlMode.Position);
		frontRight.changeControlMode(ControlMode.Position);
		rearLeft.changeControlMode(ControlMode.Follower);
		rearRight.changeControlMode(ControlMode.Follower);
		
		frontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		frontLeft.reverseSensor(Globals.leftEncoderReversed);
		frontLeft.reverseOutput(Globals.leftMotorReversed);
		frontLeft.setPID(Globals.drivetrainP, Globals.drivetrainI, Globals.drivetrainD);
		frontLeft.setIZone(Globals.drivetrainIZone);
		frontLeft.setPosition(0);
		
		frontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		frontRight.reverseSensor(Globals.rightEncoderReversed);
		frontRight.reverseOutput(Globals.rightMotorReversed);
		frontRight.setPID(Globals.drivetrainP, Globals.drivetrainI, Globals.drivetrainD);
		frontRight.setIZone(Globals.drivetrainIZone);
		frontRight.setPosition(0);
		
		frontLeft.set(0);
		frontRight.set(0);
		rearLeft.set(RobotMap.frontLeft);
		rearRight.set(RobotMap.frontRight);
//		frontLeft.enableControl();
//		frontRight.enableControl();
//		rearLeft.enableControl();
//		rearRight.enableControl();
    }
    
    public void enableManualControl() {
    	frontLeft.changeControlMode(ControlMode.PercentVbus);
    	frontRight.changeControlMode(ControlMode.PercentVbus);
    	rearLeft.changeControlMode(ControlMode.Follower);
    	rearRight.changeControlMode(ControlMode.Follower);
    	
    	frontLeft.set(0);
    	frontRight.set(0);
    	rearLeft.set(RobotMap.frontLeft);
    	rearRight.set(RobotMap.rearRight);
    	
//    	frontLeft.enableControl();
//		frontRight.enableControl();
//		rearLeft.enableControl();
//		rearRight.enableControl();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new TankDriveLinear(Globals.joystickDeadband));
    }
}

