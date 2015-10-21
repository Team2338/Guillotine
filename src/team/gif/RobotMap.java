package team.gif;
/**
 * This class defines the port number of every sensor and actuator.
 * IT ALLOWS MECHANICAL/ELECTRICAL TO EASILY CHANGE PORT NUMBERS WITHOUT DIGGING THROUGH CODE!
 * DO NOT touch this file if you have not been informed how to properly change the code.
 */
public class RobotMap {
	
	// CAN addresses
	public static int frontLeft = 1;
	public static int frontRight = 2;
	public static int elevator = 3;
	public static int collectorLeft = 4;
    public static int collectorRight = 5;
    public static int rearRight = 6;
    public static int rearLeft = 7;
    
    // DIO ports
    public static int elevatorMin = 0;
    public static int elevatorMax = 1;
    public static int collectorLimit = 2;
    
    // Relay ports (solenoids)
    public static int collectorA = 0;
    public static int collectorB = 7;
    public static int chopSticksA = 1;
    public static int chopSticksB = 6;
}
