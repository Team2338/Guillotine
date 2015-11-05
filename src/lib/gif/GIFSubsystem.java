package lib.gif;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author PatrickUbelhor
 */
public abstract class GIFSubsystem extends Subsystem {
    
	public abstract void enablePositionControl();
	public abstract void enableManualControl();
    public abstract void drive(double setpoint);
    public abstract void resetEncoder();
    
    public abstract double getDistance();

    public void initDefaultCommand() {} // TODO: Add standby default command
    
}

