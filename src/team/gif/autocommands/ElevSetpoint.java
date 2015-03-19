package team.gif.autocommands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	Globals.elevatorSetpoint = position;
    }

    protected void execute() {
    	Robot.elevator.drive(position);
    }

    protected boolean isFinished() {
    	if(Robot.elevator.getMin())
    	{
    		Robot.elevator.reset();
    		return true;
    	}
        return (Math.abs(Robot.elevator.getError()) < 100);
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
