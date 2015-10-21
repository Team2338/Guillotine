package team.gif.commands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class ElevBumpDown extends Command {

    public ElevBumpDown() {
        requires(Robot.elevator);
    }

    protected void initialize() {
    	Robot.elevator.drive(Robot.elevator.getHeight() - 200);
    	Globals.elevatorSetpoint = Robot.elevator.getSetpoint();
    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
    
}
