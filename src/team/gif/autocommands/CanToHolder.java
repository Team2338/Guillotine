package team.gif.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import team.gif.Globals;
import team.gif.commands.*;

/**
 *
 */
public class CanToHolder extends CommandGroup {
    
    public  CanToHolder() {
    	addParallel(new HolderOpen());
        addSequential(new CollectorOpen());
        addSequential(new WaitCommand(0.3));
        addSequential(new ChopsticksClose());
        addSequential(new WaitCommand(0.3));
        addSequential(new ElevSetpoint(Globals.kElevatorLevel2));
        addSequential(new AutoDrivePID(-2000, 2000));
        addSequential(new DriveForward(6000, 6000));
        addSequential(new ElevatorCoastUp());
        addSequential(new HolderClose());
    }
}