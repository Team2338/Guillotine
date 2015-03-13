package team.gif.subsystems;

import team.gif.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Outriggers extends Subsystem {
    
    public static final Solenoid outriggersA = new Solenoid(0, RobotMap.outriggersA);
    public static final Solenoid outriggersB = new Solenoid(1, RobotMap.outriggersB);
    
    public void lower() {
    	outriggersA.set(false);
    	outriggersB.set(true);
    }
    
    public void raise() {
    	outriggersB.set(false);
    	outriggersA.set(true);
    }

    public void initDefaultCommand() {}
}

