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
        addSequential(new WaitCommand(0.85));
        addSequential(new HooksExtend());
        addSequential(new WaitCommand(2.5));
        //addSequential(new DriveForward(-4000));
        addSequential(new DriveHard(-0.6, 2));
        addSequential(new WaitCommand(1));
        addSequential(new HooksRetract());
        addSequential(new OutriggersRetract());
    }
}
