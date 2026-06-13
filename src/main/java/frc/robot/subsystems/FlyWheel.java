package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase {
  /** Creates a new FlyWheel. */
  private static TalonSRX shooter;
  public boolean isArmed = false;
  
  public FlyWheel() {
    shooter = new TalonSRX(Constants.ShooterMotor);
  }
  
  public void MotorOn() {
    shooter.set(ControlMode.PercentOutput,1.0);
  }

  public void MotorOff() {
    shooter.set(ControlMode.PercentOutput,0.0);
  }

  public boolean isArmed() {
    return false;
  }


  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}