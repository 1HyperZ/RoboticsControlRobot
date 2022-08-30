package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.DriveByJoystick;

public class Drive extends SubsystemBase {
    private TalonFX back_left_m;
    private TalonFX back_right_m;
    private TalonFX front_left_m;
    private TalonFX front_right_m;

    public Drive() {
        back_left_m = new TalonFX(Constants.back_left_motor);
        back_right_m = new TalonFX(Constants.back_right_motor);
        front_left_m = new TalonFX(Constants.front_left_motor);
        front_right_m = new TalonFX(Constants.front_right_motor);
        back_left_m.setInverted(Constants.setInverted_left_m);
        front_left_m.setInverted(Constants.setInverted_left_m);
        back_left_m.follow(back_right_m);
        front_left_m.follow(front_right_m);
        setDefaultCommand(new DriveByJoystick(this));
    }

    public void setPower(double left, double right)
    {
        back_left_m.set(ControlMode.PercentOutput, left);
        back_right_m.set(ControlMode.PercentOutput, right);
        front_left_m.set(ControlMode.PercentOutput, left);
        front_right_m.set(ControlMode.PercentOutput, right);
    }

    // public double getLeftPosition()
    // {
    //      double pulsesmade = back_left_m.getSelectedSensorPosition();
    //      //return pulsesmade/double;
    // }

    // //public double getRightPosition()
    // {
    //      double pulsesmade = back_right_m.getSelectedSensorPosition();
    //      //return pulsesmade/ double(Constants.PulsePerMeter);
    // }
    @Override
    public void periodic() {
        // TODO Auto-generated method stub
        super.periodic();
        // SmartDashboard.putNumber("Left Position" ,getLeftPosition());
    }
}