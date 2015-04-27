package team.gif.autocommands;

import team.gif.commands.fastriggerHard;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class GottaGoFast extends CommandGroup {
    
    public  GottaGoFast() {
    	addParallel(new DriveHard(1, 0.25)); // Drive 100% speed for 0.25 seconds
    	//addParallel(new AutoDrivePID(-100, -100));
    	addSequential(new fastriggerHard(0.125, 0.1)); // Fastrigger 1/8 speed, 0.1 seconds
        addSequential(new fastriggerHard(1, 0.15));
        addSequential(new WaitCommand(0.5));
        addSequential(new DriveHard(-0.75, 0.75));
    }
}
