package team.gif.subsystems;

import team.gif.RobotMap;
import team.gif.commands.CollectorStandby;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author PatrickUbelhor
 */
public class CollectorMotors extends Subsystem {
    
    private static final CANTalon left = new CANTalon(RobotMap.collectorLeft);
    private static final CANTalon right = new CANTalon(RobotMap.collectorRight);
    private static final DigitalInput limit = new DigitalInput(RobotMap.collectorLimit);
    
    public CollectorMotors() {
    	super();
    	enable();
    }
    
    private void enable() {
    	left.changeControlMode(ControlMode.PercentVbus);
    	right.changeControlMode(ControlMode.PercentVbus);
    	drive(0, 0);
    	left.enableControl();
    	right.enableControl();
    }
    
    public boolean getLimit() {
    	return !limit.get();
    }
    
    public void drive(double leftSpeed, double rightSpeed) {
    	left.set(-leftSpeed);
    	right.set(rightSpeed);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new CollectorStandby());
    }
}

