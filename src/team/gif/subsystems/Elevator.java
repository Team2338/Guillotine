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
	
	public Elevator(){
		super();
		enablePositionControl(true);
		elevator.setPosition(0);
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
		return elevatorMin.get();
	}
	
	public boolean getMax() {
		return elevatorMax.get();
	}
	
	public double getHeight() {
		return elevator.getEncPosition();
	}
	
	public void enablePositionControl(boolean goingUp) {
		elevator.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		elevator.changeControlMode(ControlMode.Position);
		if (goingUp) { elevator.setPID(Globals.elevatorP, Globals.elevatorI, Globals.elevatorD); }
		else { elevator.setPID(Globals.elevDownP, Globals.elevDownI, Globals.elevDownD); }
		elevator.setIZone(Globals.elevatorIZone);
		elevator.reverseOutput(Globals.elevatorMotorReversed);
		elevator.reverseSensor(Globals.elevatorEncoderReversed);
		elevator.set(0);
		elevator.enableControl();
	}
	
	public void enableManualControl() {
		elevator.changeControlMode(ControlMode.PercentVbus);
		elevator.set(0);
		elevator.enableControl();
	}
	
	public void drive(double setpoint) {
    	if (elevator.getControlMode() == ControlMode.Position) {
        	SmartDashboard.putNumber("Error", elevator.getClosedLoopError());
    	} else { SmartDashboard.putNumber("Error", -0.001); }
    	elevator.set(setpoint);
    	SmartDashboard.putNumber("ElevCurrent", elevator.getOutputCurrent());
    }
	
    public void initDefaultCommand() {
        setDefaultCommand(new ElevatorStandby());
    }
    
}
