package team.gif.subsystems;

import team.gif.RobotMap;
import team.gif.commands.fastriggerStandby;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author PatrickUbelhor
 */
public class Fastrigger extends Subsystem {
    
	private static final CANTalon left = new CANTalon(RobotMap.leftRigger);
	private static final CANTalon right = new CANTalon(RobotMap.rightRigger);
    private static final DigitalInput pusherMax = new DigitalInput(RobotMap.pusherMax);
    private static final DigitalInput pusherMin = new DigitalInput(RobotMap.pusherMin);

    public Fastrigger() {
    	super();
    	enable();
    }
    
    private void enable() {
        left.changeControlMode(ControlMode.PercentVbus);
        left.set(0);
        left.enableControl();
        
        right.changeControlMode(ControlMode.PercentVbus);
        right.set(0);
        right.enableControl();
    }
    
    public void disableMotors() {
    	left.disableControl();
    	right.disableControl();
    }

   public void drive(double speed) {
	   left.set(speed);
	   right.set(speed);
   }
   
   public boolean getMax() {
	   return pusherMax.get();
   }
   
   public boolean getMin() {
	   return pusherMin.get();
   }
   
   public void initDefaultCommand() {
		setDefaultCommand(new fastriggerStandby());
	}
   
}

