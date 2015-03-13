package team.gif.autocommands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class ElevSetpoint extends Command {

	private double position;
	
    public ElevSetpoint(double setpoint) {
        requires(Robot.elevator);
        position = setpoint;
    }

    protected void initialize() {
    	Robot.elevator.enablePositionControl(Robot.elevator.getHeight() > position);
    	Globals.elevatorSetpoint = position;
    }

    protected void execute() {
    	Robot.elevator.drive(position);
    }

    protected boolean isFinished() {
        return Math.abs(Robot.elevator.getError()) < 100;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
