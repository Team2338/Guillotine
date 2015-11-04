
package team.gif;

import team.gif.autocommands.*;
import team.gif.commands.ChopsticksOpen;
import team.gif.commands.TankDriveLinear;
import team.gif.subsystems.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Elevator elevator = new Elevator();
	public static final Drivetrain chassis = new Drivetrain();
	public static final Chopsticks chopsticks = new Chopsticks();
	public static final CollectorMotors collectorMotors = new CollectorMotors();
	public static final CollectorPneumatics collectorPneumo = new CollectorPneumatics();
	public static OI oi;
	
	public SendableChooser autoChooser;
	
	private static Compressor compressor = new Compressor(0);
	
	Command autoCommand;
	Command teleCommand;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		teleCommand = new TankDriveLinear(Globals.joystickDeadband);
		elevator.resetEncoder();
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("No autonomous", new AntiAuto());
		autoChooser.addObject("Testing", new Testing());
		SmartDashboard.putData("Auto Mode", autoChooser);
    }
    
    /**
     * Runs once at the beginning of autonomous mode.
     * Use to initialize anything specifically for auto.
     */
    public void autonomousInit() {
    	(new ChopsticksOpen()).start();
    	
        if (autoChooser.getSelected() != null) {
	    	autoCommand = (Command) autoChooser.getSelected();
	    	autoCommand.start();
        }
    }

    /**
     * Runs every 20ms in autonomous mode.
     * Use to update IO values.
     */
    public void autonomousPeriodic() {
        update();
    }

    /**
     * Runs once at the beginning of teleoperator mode.
     * Use to initialize anything specifically for teleop.
     */
    public void teleopInit() {
    	if (autoCommand != null) autoCommand.cancel();
    	teleCommand.start();
    }

    /**
     * Runs every 20ms in teleop mode.
     * Use to update IO values.
     */
    public void teleopPeriodic() {
        update();
        //compressor.stop();
    }
    
    /**
     * Once once after the robot enters the disabled state.
     * Use to set any final values before the robot is uncontrollable.
     */
    public void disabledInit() {}
    
    /**
     * Runs every 20ms when disabled.
     * Use to update driver station display values.
     */
    public void disabledPeriodic() {
		update();
	}
    
    /**
     * Runs once when entering test mode.
     */
    public void testInit() {}
    
    /**
     * Runs every 20ms in test mode.
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    /**
     * Updates the currently schedules command
     * and displays data on the DS Smart Dashboard.
     */
    private final void update() {
    	Scheduler.getInstance().run();
    	SmartDashboard.putNumber("leftTicks:", chassis.getLeftDistance());
        SmartDashboard.putNumber("rightTicks:", chassis.getRightDistance());
        SmartDashboard.putNumber("ElevHeight:", elevator.getHeight());
        SmartDashboard.putBoolean("ElevMin:", elevator.getMin());
        SmartDashboard.putBoolean("ElevMax:", elevator.getMax());
        SmartDashboard.putBoolean("CollectorLimit", collectorMotors.getLimit());
        SmartDashboard.putNumber("iAccum", elevator.getIAccum());
        SmartDashboard.putNumber("Error", elevator.getError());
        SmartDashboard.putNumber("Setpoint", elevator.getSetpoint());
        SmartDashboard.putBoolean("CompressorRunning", compressor.enabled());
        SmartDashboard.putNumber("LeftVel ", chassis.getLeftVelocity());
        SmartDashboard.putNumber("RightVel ", chassis.getRightVelocity());
        SmartDashboard.putNumber("LeftCurrent ", chassis.getLeftCurrent());
    }
    
}
