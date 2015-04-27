package team.gif;

public class Globals {
	
	/**
	 * This file defines the values used when each subsystem is actuated.
	 * If a value is changed, code must be redeployed.
	 * DO NOT EDIT UNLESS YOU KNOW WHAT YOU ARE DOING. PLEASE CONSULT SOMEONE WHO DOES.
	 */
	
	public static final double collectorSpeed = 1;
	public static final double pusherSpeed = 1;
	public static final double joystickDeadband = 0.1;
	
	// Drivetrain variables
	public static final double drivetrainP = 1;
	public static final double drivetrainI = 0.0001;
	public static final double drivetrainD = 0.0;
	public static final int drivetrainIZone = 1000;
	public static final boolean leftEncoderReversed = false;
	public static final boolean rightEncoderReversed = true;
	public static final boolean leftMotorReversed = true;
	public static final boolean rightMotorReversed = true;
	
	// Elevator variables
	public static final double elevDownP = 8;
	public static final double elevDownI = 0;
	public static final double elevDownD = 0;
	public static final boolean elevatorMotorReversed = true;
	public static final boolean elevatorEncoderReversed = true;
	public static final double kElevatorLevel1 = 12;
	public static final double kElevatorLevel2 = 1000;
	public static final double kElevatorLevel3 = 2100;
	public static final double kElevatorLevel4 = 3200;
	public static final double kElevatorLevel5 = 4300;
	
	// DON'T TOUCH THIS VALUE OR THE ROBOT WILL DIE:
	public static double elevatorSetpoint = 0;
	//public static boolean chopsticksOpen = true;
}