package team.gif.autocommands;

import team.gif.Globals;
import team.gif.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ToteStackAssisted extends CommandGroup {
    
    public  ToteStackAssisted() {
    	//Grab first tote
    	addSequential(new ChopsticksClose());
    	addSequential(new CollectorOpen());
    	addParallel(new CollectorEject());
    	addSequential(new WaitCommand(2));
    	
    	//Knock Can Out of the way
    	addSequential(new ElevSetpoint(Globals.kElevatorLevel4));
    	addSequential(new CollectorClose());
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveForward(-5000));
    	addSequential(new WaitCommand(1));
    	addSequential(new CollectorOpen());
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveForward(-1000));
    	addParallel(new CollectorReceive());
    	
    	//Drive Forward and Grab Second Tote
    	addParallel(new ElevSetpoint(Globals.kElevatorLevel3));
    	addSequential(new DriveForward(-2000));
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
    	addSequential(new DriveForward(-3000, 400));
    	addSequential(new DriveForward(-1000));
    	addSequential(new ChopsticksOpen());
    	addSequential(new CollectorOpen());
    	addSequential(new WaitCommand(2));
    	addSequential(new DriveForward(1000));
    }
}
