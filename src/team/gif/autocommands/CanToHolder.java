package team.gif.autocommands;

import team.gif.Globals;
import team.gif.commands.ChopsticksClose;
import team.gif.commands.ElevatorStandby;
import team.gif.commands.HolderOpen;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author PatrickUbelhor
 */
public class CanToHolder extends CommandGroup {
    
    public  CanToHolder() {
    	addParallel(new HolderOpen());
        addSequential(new ChopsticksClose());
        addSequential(new WaitCommand(0.3));
        addSequential(new ElevSetpoint(Globals.kElevatorLevel2 + 400));
        addParallel(new ElevatorStandby());
        addSequential(new WaitCommand(0.3));
        addSequential(new AutoDrivePID(0, 2750));
        addSequential(new DriveForward(-3000, -2000));
        addSequential(new DriveForward(-2000, -2000));
        //addSequential(new ElevatorCoastUp());
        //addSequential(new HolderClose());
    }
}