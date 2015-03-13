package team.gif.commands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Armaan
 */
public class ElevatorRaise extends Command {

	
    public ElevatorRaise() {
    	requires(Robot.elevator);
    }

    protected void initialize() {
    	Robot.elevator.enableManualControl();
    }

    protected void execute() {
    	if (Robot.elevator.getMax()) {
    		Robot.elevator.drive(Globals.elevatorRaiseSpeed);
    	}
    	Globals.elevManualPos = Robot.elevator.getHeight();
    }

    protected boolean isFinished() {
        return !Robot.elevator.getMax();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
