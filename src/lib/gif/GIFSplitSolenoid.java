package lib.gif;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * @author PatrickUbelhor
 */
public class GIFSplitSolenoid {
	
	Solenoid extender;
	Solenoid retractor;
	
	/**
	 * Constructs a new Split Solenoid object:
	 * two single-solenoids combined to act as a double solenoid
	 * 
	 * @param extendPCM PCM number of extending solenoid
	 * @param extendChannel Channel number of extending solenoid
	 * @param retractPCM PCM ID number of retracting solenoid
	 * @param retractChannel Channel number of retracting solenoid
	 */
	public GIFSplitSolenoid(int extendChannel, int retractChannel) {
		extender = new GIFSolenoid(extendChannel);
		retractor = new GIFSolenoid(retractChannel);
	}
	
	/**
	 * Causes the piston to extend
	 */
	public void extend() {
		retractor.set(false);
		extender.set(true);
	}
	
	/**
	 * Causes the piston to retract
	 */
	public void retract() {
		extender.set(false);
		retractor.set(true);
	}
	
	/**
	 * Disabled the airflow through both channels.
	 * Use this to allow a piston to freely move.
	 */
	public void disable() {
		extender.set(false);
		retractor.set(false);
	}
	
}
