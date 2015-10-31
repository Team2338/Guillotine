package team.gif.autocommands;

import team.gif.Globals;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author PatrickUbelhor
 */
public class AroundCones extends CommandGroup {
	
	private double turnLength = 2100;
	private double linear = 5000;
	private double accTime = 0.2;
    
    public  AroundCones() {
        
    	// Drive forward to midpoint of first cone
    	addParallel(new LeftProfile(accTime, linear / 2, Globals.drivetrainMaxVelLeft / 2));
    	addSequential(new RightProfile(accTime, linear / 2, Globals.drivetrainMaxVelRight / 2));
    	
    	addSequential(new WaitCommand(1));
    	
    	// Turn right 90 degrees
    	addParallel(new LeftProfile(accTime, turnLength, Globals.drivetrainMaxVelLeft / 2));
    	addSequential(new RightProfile(accTime, -turnLength, Globals.drivetrainMaxVelRight / 2));
    	addSequential(new WaitCommand(1));
    	
    	// Drive to midpoint of second cone
    	addParallel(new LeftProfile(accTime, linear, Globals.drivetrainMaxVelLeft / 2));
    	addSequential(new RightProfile(accTime, linear, Globals.drivetrainMaxVelRight / 2));
    	addSequential(new WaitCommand(1));
    	
    	// Turn left 90 degrees
    	addParallel(new LeftProfile(accTime, -turnLength, (Globals.drivetrainMaxVelLeft / 2)));
    	addSequential(new RightProfile(accTime, turnLength, Globals.drivetrainMaxVelRight / 2));
    	addSequential(new WaitCommand(1));
    	
    	// Drive to midpoint of third cone
    	addParallel(new LeftProfile(accTime, linear, Globals.drivetrainMaxVelLeft / 2));
    	addSequential(new RightProfile(accTime, linear, Globals.drivetrainMaxVelRight / 2));
    	addSequential(new WaitCommand(1));
    	
    	// Turn right 90 degrees
    	addParallel(new LeftProfile(accTime, turnLength, Globals.drivetrainMaxVelLeft / 2));
    	addSequential(new RightProfile(accTime, -turnLength, Globals.drivetrainMaxVelRight / 2));
    	addSequential(new WaitCommand(1));
    	
    	// Drive to end point
    	addParallel(new LeftProfile(accTime, 0, Globals.drivetrainMaxVelLeft / 2));
    	addSequential(new RightProfile(accTime, 0, Globals.drivetrainMaxVelRight / 2));
    	addSequential(new WaitCommand(1));
    	
    }
}
