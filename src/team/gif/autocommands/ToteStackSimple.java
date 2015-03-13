package team.gif.autocommands;

import team.gif.Globals;
import team.gif.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ToteStackSimple extends CommandGroup {
    
    public  ToteStackSimple() {
    	
    	//Grab first tote
    	addSequential(new ChopsticksClose());
    	addSequential(new CollectorOpen());
    	addParallel(new CollectorReceive());
    	addSequential(new WaitCommand(2));
    	
    	//Drive Forward and Grab Second Tote
    	addParallel(new ElevSetpoint(Globals.kElevatorLevel3));
    	addSequential(new DriveForward(-4000));
    	addSequential(new CollectorClose());
    	addSequential(new WaitCommand(1));
    	
    	addParallel(new CollectorStandby());
    	addSequential(new ElevSetpoint(Globals.kElevatorLevel2));
    	addSequential(new WaitCommand(2));
    	addSequential(new ChopsticksOpen());
    	addSequential(new WaitCommand(2));
    	
    	addSequential(new ElevSetpoint(Globals.kElevatorLevel1));
    	addSequential(new WaitCommand(2));
    	addSequential(new ChopsticksClose());
    	addSequential(new CollectorOpen());
    	addSequential(new WaitCommand(2));
    	
    	//Repeat
    	addParallel(new ElevSetpoint(Globals.kElevatorLevel3));
    	addParallel(new CollectorReceive());
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveForward(-4000));
    	addSequential(new CollectorClose());
    	addSequential(new WaitCommand(1));
    	
    	addParallel(new CollectorStandby());
    	addSequential(new ElevSetpoint(Globals.kElevatorLevel2));
    	addSequential(new WaitCommand(2));
    	addSequential(new ChopsticksOpen());
    	addSequential(new WaitCommand(2));
    	
    	addSequential(new ElevSetpoint(Globals.kElevatorLevel3));
    	addSequential(new WaitCommand(2));
    	addSequential(new ChopsticksClose());
//    	addSequential(new CollectorOpen());
    	addSequential(new WaitCommand(2));
    	
    	//Turn and go
    	addSequential(new AutoDrivePID(2400, -400));
    	addSequential(new DriveForward(-1000));
    	addSequential(new ChopsticksOpen());
    	addSequential(new CollectorOpen());
    	addSequential(new WaitCommand(2));
    	addSequential(new DriveForward(1000));
    	
    }
}
