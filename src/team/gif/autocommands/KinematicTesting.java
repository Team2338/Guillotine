package team.gif.autocommands;

import team.gif.Globals;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author PatrickUbelhor
 */
public class KinematicTesting extends CommandGroup {
    
    public  KinematicTesting() {
        
    	addParallel(new LeftProfile(4, 2000, Globals.drivetrainMaxVel / 2));
        addSequential(new RightProfile(4, 2000, Globals.drivetrainMaxVel / 2));
    }
}
