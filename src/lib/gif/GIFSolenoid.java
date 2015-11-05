package lib.gif;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * @author PatrickUbelhor
 */
public class GIFSolenoid extends Solenoid {

	/**
	 * Creates a new Solenoid object. This class automatically
	 * determines the PCM
	 * @param channel
	 */
	public GIFSolenoid(int channel) {
		super(channel / 8, channel % 8);
	}
	
}
