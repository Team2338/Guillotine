package team.gif.subsystems;

import team.gif.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hooks extends Subsystem {
    
    private final Solenoid leftHookA = new Solenoid(0, RobotMap.hooksA);
    private final Solenoid leftHookB = new Solenoid(1, RobotMap.hooksB);

    public void open() {
    	leftHookB.set(false);
    	leftHookA.set(true);
   	}
    
    public void close() {
   		leftHookA.set(false);
   		leftHookB.set(true);
    }
    
    public void initDefaultCommand() {}
}

