package team.gif.subsystems;

import team.gif.RobotMap;
import team.gif.commands.HolderClose;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author PatrickUbelhor
 */
public class Holder extends Subsystem {
    
    private static Solenoid canHolderA = new Solenoid(0, RobotMap.holderA);
    private static Solenoid canHolderB = new Solenoid(1, RobotMap.holderB);
    
    public void open() {
    	canHolderB.set(false);
    	canHolderA.set(true);
    }
    
    public void close() {
    	canHolderA.set(false);
    	canHolderB.set(true);
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new HolderClose());
    }
}

