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
	public static final double drivetrainP = 0.3;
	public static final double drivetrainI = 0.0001;
	public static final double drivetrainD = 0.0;
	public static final int drivetrainIZone = 1000;
	public static final boolean leftEncoderReversed = true;
	public static final boolean rightEncoderReversed = true;
	public static final boolean leftMotorReversed = false;
	public static final boolean rightMotorReversed = false;
	
	// Elevator variables
	public static final double elevatorP = 4;
	public static final double elevatorI = 0.008;
	public static final double elevatorD = 0.1;
	public static final int elevatorIZone = 150;
	public static final double elevDownP = 4;
	public static final double elevDownI = 0.008;
	public static final double elevDownD = 0.1;
	public static final double elevatorRaiseSpeed = -0.6;
	public static final double elevatorLowerSpeed = 0.5;
	public static final boolean elevatorMotorReversed = true;
	public static final boolean elevatorEncoderReversed = false;
	public static final double kElevatorLevel1 = 0;
	public static final double kElevatorLevel2 = 1000;
	public static final double kElevatorLevel3 = 2100;
	public static final double kElevatorLevel4 = 3200;
	public static final double kElevatorLevel5 = 4300;
	public static final double kElevatorBump = 400;
	
	// DON'T TOUCH THIS VALUE OR THE ROBOT WILL DIE:
	public static double elevatorSetpoint = 0;
	public static double elevManualPos = 0;
}