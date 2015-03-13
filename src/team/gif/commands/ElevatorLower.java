package team.gif.commands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Armaan
 */
public class ElevatorLower extends Command {

	
    public ElevatorLower() {
    	requires(Robot.elevator);
    }

    protected void initialize() {
    	Robot.elevator.enableManualControl();
    }

    protected void execute() {
    	if (Robot.elevator.getMin()) {
    		Robot.elevator.drive(Globals.elevatorLowerSpeed);
    	}
    }

    protected boolean isFinished() {
        return !Robot.elevator.getMin();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
