package team.gif.subsystems;

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

    public void close() {
    	collectorA.set(false);
    	collectorB.set(true);
    }
    
    public void open() {
    	collectorB.set(false);
    	collectorA.set(true);
    }
    
    public void initDefaultCommand() {}
    
}
