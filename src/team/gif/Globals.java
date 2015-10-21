package team.gif;

public class Globals {
	
	/**
	 * This file defines the values used when each subsystem is actuated.
	 * If a value is changed, code must be redeployed.
	 * DO NOT EDIT UNLESS YOU KNOW WHAT YOU ARE DOING. PLEASE CONSULT SOMEONE WHO DOES.
	 */
	
	public static final double collectorSpeed = 1;
	public static final double joystickDeadband = 0.1;
	
	// Drivetrain variables
	public static final boolean leftEncoderReversed = false;
	public static final boolean rightEncoderReversed = true;
	public static final boolean frontLeftMotorReversed = true;
	public static final boolean frontRightMotorReversed = true;
	public static final boolean rearLeftMotorReversed = false;
	
	public static final double robotWidth = 1305; // In encoder ticks. ESTIMATED.
	public static final double drivetrainMaxVel = 8000; // Ticks/sec. ESTIMATED.
	public static final double motionProfilerP = 0.0;
	public static final double motionProfilerI = 0.0;
	public static final double motionProfilerD = 0.0;
	
	// Elevator variables
	public static final double elevDownP = 8;
	public static final double elevDownI = 0;
	public static final double elevDownD = 0;
	public static final boolean elevatorMotorReversed = false;
	public static final boolean elevatorEncoderReversed = true;
	public static final double kElevatorLevel1 = 12;
	public static final double kElevatorLevel2 = 1000;
	public static final double kElevatorLevel3 = 2100;
	
	// DON'T TOUCH THIS VALUE OR THE ROBOT WILL DIE:
	public static double elevatorSetpoint = 0;
}