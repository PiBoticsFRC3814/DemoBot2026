// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new TankDrive. */

  private final WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.FR_MOTOR_ID);;
  private final WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.FL_MOTOR_ID);;
  private final WPI_TalonSRX backRight = new WPI_TalonSRX(Constants.BR_MOTOR_ID);;
  private final WPI_TalonSRX backLeft  = new WPI_TalonSRX(Constants.BL_MOTOR_ID);;

  private final DifferentialDrive tankDrive = new DifferentialDrive(frontLeft, frontRight);

  private final DifferentialDrive cheesyDrive = new DifferentialDrive(frontLeft, frontRight);

  public DriveTrain() {

    backRight.follow(frontRight);
    backLeft.follow(frontLeft);

    frontRight.setInverted(false);
    frontLeft.setInverted(false);
    backRight.setInverted(false);
    backLeft.setInverted(false);

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
