package team.gif.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import team.gif.Globals;
import team.gif.commands.*;

/**
 *
 */
public class CanToteAuto extends CommandGroup {
    
    public  CanToteAuto() {
        addSequential(new CollectorOpen());
        addSequential(new ChopsticksOpen());
        addSequential(new WaitCommand(0.3));
        addSequential(new ChopsticksClose());
        addSequential(new WaitCommand(0.3));
        addSequential(new ElevSetpoint(Globals.kElevatorLevel2 + 400));
        addSequential(new DriveForward());
        addParallel(new CollectorReceive());
        addSequential(new CollectorClose());
        // NOT FINISHED, DO NOT USE
    }
}
