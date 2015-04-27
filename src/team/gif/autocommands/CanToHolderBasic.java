package team.gif.autocommands;

import team.gif.Globals;
import team.gif.commands.ChopsticksClose;
import team.gif.commands.ElevatorStandby;
import team.gif.commands.HolderClose;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author PatrickUbelhor
 */
public class CanToHolderBasic extends CommandGroup {
    
    public  CanToHolderBasic() {
    	addParallel(new HolderClose());
        addSequential(new ChopsticksClose());
        addSequential(new WaitCommand(1));
        addSequential(new ElevSetpoint(Globals.kElevatorLevel4));
        addParallel(new ElevatorStandby());
        //addSequential(new ElevatorCoastUp());
        //addSequential(new HolderClose());
    }
}
