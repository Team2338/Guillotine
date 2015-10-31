package team.gif.autocommands;

import team.gif.Globals;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author PatrickUbelhor
 */
public class KinematicTesting extends CommandGroup {
    
    public KinematicTesting() {
        
    	addParallel(new LeftProfile(0.5, 4880, Globals.drivetrainMaxVelLeft / 2));
        addSequential(new RightProfile(0.5, 4880, Globals.drivetrainMaxVelRight / 2));
        
    }
    
}
