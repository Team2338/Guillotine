package team.gif.commands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *	@author NotPatrick && PatrickUbelhor
 */
public class ElevatorCoastDown extends Command {

    public ElevatorCoastDown() {
    	requires(Robot.elevator);
    }

    protected void initialize() {}

    protected void execute() {
    	if (Robot.elevator.getHeight() > 250) {
    		Robot.elevator.drive(Robot.elevator.getHeight() - 325);
    	} else {
    		Robot.elevator.drive(Robot.elevator.getHeight() - 150);
    	}
    }

    protected boolean isFinished() {
    	if(Robot.elevator.getMin())
    	{
    		Robot.elevator.resetEncoder();
    		return true;
    	}
        return false;
    }

    protected void end() {
    	Globals.elevatorSetpoint = 0;
    }

    protected void interrupted() {
    	Globals.elevatorSetpoint = Robot.elevator.getHeight();
    }
    
}
