package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class fastriggerHard extends Command {
	
	private double initTime;
	private double speed;
	private double endTime;

    public fastriggerHard(double speed, double time) {
        requires(Robot.fastrigger);
        this.speed = speed;
        endTime = time;
    }

    protected void initialize() {
    	initTime = Timer.getFPGATimestamp();
    }

    protected void execute() {
    	Robot.fastrigger.drive(speed);
    }

    protected boolean isFinished() {
        return (Timer.getFPGATimestamp() - initTime) > endTime;
    }

    protected void end() {
    	Robot.fastrigger.drive(0);
    }

    protected void interrupted() {}
}
