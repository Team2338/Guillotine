
package team.gif;

import team.gif.autocommands.*;
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
	public static final Drivetrain2 chassis = new Drivetrain2();
	public static final Pusher pusher = new Pusher();
	public static final Chopsticks chopsticks = new Chopsticks();
	public static final CollectorMotors collectorMotors = new CollectorMotors();
	public static final CollectorPneumatics collectorPneumo = new CollectorPneumatics();
	public static final Outriggers outriggers = new Outriggers();
	public static final Holder holder = new Holder();
	public static final Hooks hooks = new Hooks();
	public static OI oi;
	
	public SendableChooser autoChooser;
	
	private static Compressor compressor = new Compressor(1);
//	CameraServer server;
	
	Command autoCommand;
	Command teleCommand;
	Command elevUpdatePos;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
//		server = CameraServer.getInstance();
//		server.setQuality(10);
//		server.startAutomaticCapture("cam0");
		
		compressor.start();
		teleCommand = new TankDriveLinear(.1);
		elevUpdatePos = new UpdateElevPos();
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Drive Forward", new DriveForward(-4000));
		autoChooser.addObject("Step Cans", new PullCans());
		//autoChooser.addObject("Solo Tote Stack", new ToteStackSolo());
		//autoChooser.addObject("Assisted Tote Stack", new ToteStackAssisted());
		//autoChooser.addObject("Simple Tote Stack", new ToteStackSimple());
		//autoChooser.addObject("Can and Tote Auto", new CanToteAuto());
		//autoChooser.addObject("Solo Can and Tote Stack", new CanToteStackSolo());
		//autoChooser.addObject("Assisted Can and Tote Stack", new CanToteStackAssisted());
		autoChooser.addObject("Can to holder", new CanToHolder());
		SmartDashboard.putData("Auto Mode", autoChooser);
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //if (autonomousCommand != null) autonomousCommand.start();
    	autoCommand = (Command) autoChooser.getSelected();
    	autoCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("leftTicks:", chassis.getLeftDistance());
        SmartDashboard.putNumber("rightTicks:", chassis.getRightDistance());
//        SmartDashboard.putNumber("DriveErrorLeft", chassis.getLeftError());
//        SmartDashboard.putNumber("DriveErrorRight", chassis.getRightError());
//        SmartDashboard.putNumber("Left Setpoint", chassis.getLeftSetpoint());
//        SmartDashboard.putNumber("Right Setpoint", chassis.getRightSetpoint());
    }

    public void teleopInit() {
    	if (autoCommand != null) {
    		autoCommand.cancel();
    	}
    	teleCommand.start();
    	elevUpdatePos.start();
    }


    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("leftTicks:", chassis.getLeftDistance());
        SmartDashboard.putNumber("rightTicks:", chassis.getRightDistance());
        SmartDashboard.putNumber("ElevHeight:", elevator.getHeight());
        SmartDashboard.putBoolean("ElevMin:", elevator.getMin());
        SmartDashboard.putBoolean("ElevMax:", elevator.getMax());
        SmartDashboard.putBoolean("PusherMin:", pusher.getMin());
        SmartDashboard.putBoolean("PusherMax:", pusher.getMax());
        SmartDashboard.putNumber("iAccum", elevator.getIAccum());
        SmartDashboard.putNumber("Error", elevator.getError());
        SmartDashboard.putNumber("Setpoint", elevator.getSetpoint());
        //compressor.stop();
    }
    
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }
    
    public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
