package team.gif.autocommands;

import team.gif.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class PullCans extends CommandGroup {
    
    public  PullCans() {
        addSequential(new OutriggersExtend());
        addSequential(new WaitCommand(1));
        addSequential(new HooksExtend());
        addSequential(new WaitCommand(3));
        addSequential(new DriveForward(-1500));
        addSequential(new HooksRetract());
        addSequential(new OutriggersRetract());
    }
}
