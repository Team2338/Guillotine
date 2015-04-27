package team.gif;
/**
 * This class defines the port number of every sensor and actuator.
 * IT ALLOWS MECHANICAL/ELECTRICAL TO EASILY CHANGE PORT NUMBERS WITHOUT DIGGING THROUGH CODE!
 * DO NOT touch this file if you have not been informed how to properly change the code.
 */
public class RobotMap {
	
	// CAN addresses
    public static int leftRigger = 1;
    public static int collectorRight = 2;
    public static int collectorLeft = 3;
    public static int elevator = 4;
    public static int frontRight = 5;
    public static int rearRight = 6;
    public static int frontLeft = 7;
    public static int rearLeft = 8;
    public static int rightRigger = 9;
    
    // DIO ports
    public static int elevatorMin = 0;
    public static int elevatorMax = 1;
    public static int pusherMax = 2;
    public static int pusherMin = 3;
    public static int collectorLimit = 4;
    
    // Relay ports (solenoids)
    public static int collectorA = 0;
    public static int collectorB = 0;
    public static int hooksA = 3;
    public static int hooksB = 3;
    public static int holderA = 2;
    public static int holderB = 2;
    public static int outriggersA = 1;
    public static int outriggersB = 1;
    public static int chopSticksA = 4;
    public static int chopSticksB = 4;
}
