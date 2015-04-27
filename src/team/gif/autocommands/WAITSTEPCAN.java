package team.gif.autocommands;

import team.gif.commands.HooksExtend;
import team.gif.commands.HooksRetract;
import team.gif.commands.OutriggersExtend;
import team.gif.commands.OutriggersRetract;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class WAITSTEPCAN extends CommandGroup {
    
    public  WAITSTEPCAN() {
    	addSequential(new WaitCommand(5));
    	addSequential(new OutriggersExtend());
        addSequential(new WaitCommand(0.85));
        addSequential(new HooksExtend());
        addSequential(new WaitCommand(2));
        addSequential(new DriveHard(-0.5, 1.75));
        addSequential(new WaitCommand(1));
        addSequential(new HooksRetract());
        addSequential(new OutriggersRetract());
    }
}
