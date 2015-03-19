package team.gif.autocommands;

import team.gif.Globals;
import team.gif.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Stacro extends CommandGroup {
    
    public  Stacro() {
    	addSequential(new ElevSetpoint(Globals.kElevatorLevel2));
    	addSequential(new WaitCommand(.3));
    	addSequential(new ChopsticksOpen());
    	addSequential(new WaitCommand(.3));
    	addSequential(new ElevSetpoint(Globals.kElevatorLevel1));
    	addSequential(new ElevatorCoastDown());
    	addSequential(new ChopsticksClose());
    	addSequential(new WaitCommand(.3));
    	addSequential(new ElevSetpoint(Globals.kElevatorLevel2 + 400));
    }
}
