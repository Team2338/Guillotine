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
    	
    	// If elevator isn't at level 2, tell it to go to level 2
    	// Removes delay on initial stack (when not holding any totes)
    	//if (Math.abs(Robot.elevator.getHeight() - Globals.kElevatorLevel2) > 150) {
    		addSequential(new ElevSetpoint(Globals.kElevatorLevel2));
        	//addSequential(new WaitCommand(.3));
    	//}
    	
    	// Removes delay on initial stack (when not holding any totes)
    	//if (Globals.chopsticksOpen) {
    		addSequential(new ChopsticksOpen());
        	addSequential(new WaitCommand(0.18));
    	//}
    	//addSequential(new CollectorOpen());
    	addSequential(new ElevSetpoint(Globals.kElevatorLevel1));
    	addSequential(new ElevatorCoastDown());
    	addSequential(new ChopsticksClose());
    	addSequential(new WaitCommand(.25));
    	addSequential(new ElevSetpoint(Globals.kElevatorLevel2 + 400));
    }
}
