package team.gif.subsystems;

import lib.gif.GIFSplitSolenoid;
import team.gif.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author PatrickUbelhor
 */
public class Chopsticks extends Subsystem {
    
    private static final Solenoid chopsticksA = new Solenoid(0, RobotMap.chopSticksA);
    private static final Solenoid chopsticksB = new Solenoid(0, RobotMap.chopSticksB);
    
//    private static final GIFSplitSolenoid chopsticks =
//    		new GIFSplitSolenoid(RobotMap.chopSticksA, RobotMap.chopSticksB);
    
    public void open() {
    	chopsticksA.set(false);
    	chopsticksB.set(true);
//    	chopsticks.retract();
    }
    
    public void close() {
    	chopsticksB.set(false);
    	chopsticksA.set(true);
//    	chopsticks.extend();
    }

    public void initDefaultCommand() {}
    
}
