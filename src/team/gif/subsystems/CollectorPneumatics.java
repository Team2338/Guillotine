package team.gif.subsystems;

import lib.gif.GIFSplitSolenoid;
import team.gif.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author PatrickUbelhor
 */
public class CollectorPneumatics extends Subsystem {
	
	//A extends, B retracts
    private static final Solenoid collectorA = new Solenoid(0, RobotMap.collectorA);
    private static final Solenoid collectorB = new Solenoid(0, RobotMap.collectorB);
//    private static final GIFSplitSolenoid collector = new GIFSplitSolenoid(RobotMap.collectorA, RobotMap.collectorB);

    public void close() {
    	collectorA.set(false);
    	collectorB.set(true);
//    	collector.retract();
    }
    
    public void open() {
    	collectorB.set(false);
    	collectorA.set(true);
//    	collector.extend();
    }
    
    public void initDefaultCommand() {}
    
}
