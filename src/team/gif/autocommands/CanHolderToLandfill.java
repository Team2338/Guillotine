package team.gif.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CanHolderToLandfill extends CommandGroup {
    
    public  CanHolderToLandfill() {
        addSequential(new CanToHolderBasic());
        addSequential(new AutoDrivePID(-2000, 2000));
        addSequential(new DriveForward(10000));
        addSequential(new AutoDrivePID(2000, -2000));
    }
}
