package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;

public class DriveByJoystick extends CommandBase 
{
    private Drive drive;

    public DriveByJoystick(Drive drive)
    {
        this.drive = drive;
        addRequirements(drive);
    }
    @Override
    public void execute() {
        super.execute();
        double left = getJVal(RobotContainer.getLJoystick());
        double right = getJVal(RobotContainer.getRJoystick());
        drive.setPower(left, right);

    }
    
    private double getJVal(Joystick j)
    {
        double y = j.getY();
        if (y < Constants.range && y > - Constants.range)
        {
            y = 0.0;
        }
        double a = 1/1.1;
        double b = 1 - a;
        double Value = Math.signum(y)*(Math.pow(y,2)*a + b);
        return Value;

    }

    
    
}
