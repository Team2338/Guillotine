package team.gif.autocommands;

import team.gif.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CanRetract extends CommandGroup {
    
    public  CanRetract() {
    	addSequential(new HooksRetract());
        addSequential(new WaitCommand(2));
        addSequential(new OutriggersRetract());
    }
}
