package team.gif.autocommands;

import team.gif.commands.HooksExtend;
import team.gif.commands.OutriggersExtend;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CanExtend extends CommandGroup {
    
    public  CanExtend() {
    	addSequential(new OutriggersExtend());
        addSequential(new WaitCommand(1));
        addSequential(new HooksExtend());
    }
}
