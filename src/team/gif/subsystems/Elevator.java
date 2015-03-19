package team.gif.subsystems;

import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.ElevatorStandby;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** Doin' Elevator Stuff....
 * @author Armaan
 */

public class Elevator extends Subsystem {
	
	private static final CANTalon elevator = new CANTalon(RobotMap.elevator);
	private static final DigitalInput elevatorMax = new DigitalInput(RobotMap.elevatorMax);
	private static final DigitalInput elevatorMin = new DigitalInput(RobotMap.elevatorMin);
	private static double prevSet = 0;
	
	public Elevator(){
		super();
		enablePositionControl();
		elevator.setPosition(0);
	}
	
	public double getSetpoint(){
		return elevator.getSetpoint();
	}
	
	public ControlMode getMode() {
		return elevator.getControlMode();
	}
	
	public double getError() {
		return elevator.getClosedLoopError();
	}
	
	public long getIAccum() {
		return elevator.GetIaccum();
	}
	
	public boolean getMin() {
		return !elevatorMin.get();
	}
	
	public boolean getMax() {
		return !elevatorMax.get();
	}
	
	public double getHeight() {
		return elevator.getEncPosition();
	}
	
	public void enablePositionControl() {
		elevator.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		elevator.changeControlMode(ControlMode.Position);
//		elevator.setPID(Globals.elevatorP, Globals.elevatorI, Globals.elevatorD, 0, 0, 0, 0);
		elevator.setPID(Globals.elevDownP, Globals.elevDownI, Globals.elevDownD);
		elevator.reverseOutput(Globals.elevatorMotorReversed);
		elevator.reverseSensor(Globals.elevatorEncoderReversed);
		drive(0);
	}
	
	public void enableManualControl() {
		elevator.changeControlMode(ControlMode.PercentVbus);
		drive(0);
		elevator.enableControl();
	}
	
	public void drive(double setpoint) {
//    	SmartDashboard.putNumber("Error", -0.001);
//    	if (setpoint - elevator.getEncPosition() > 0){
//    		elevator.setProfile(0);
//    	}
//    	else {
//    		elevator.setProfile(1);
//    	}
    	if (setpoint != prevSet)
    		elevator.ClearIaccum();
    	prevSet = setpoint;
    	elevator.set(setpoint);
//    	SmartDashboard.putNumber("ElevCurrent", elevator.getOutputCurrent());
    }
	
    public void initDefaultCommand() {
        setDefaultCommand(new ElevatorStandby());
    }
    
    public void reset() {
    	elevator.setPosition(0);
    	drive(0);
    }
    
}
