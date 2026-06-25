// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;;

public class DriveTrain extends SubsystemBase {
  /** Creates a new TankDrive. */

  private final WPI_TalonSRX frontRight = new WPI_TalonSRX(MotorConstants.FR_MOTOR_ID);;
  private final WPI_TalonSRX frontLeft = new WPI_TalonSRX(MotorConstants.FL_MOTOR_ID);;
  private final WPI_TalonSRX backRight = new WPI_TalonSRX(MotorConstants.BR_MOTOR_ID);;
  private final WPI_TalonSRX backLeft  = new WPI_TalonSRX(MotorConstants.BL_MOTOR_ID);;

  private final DifferentialDrive tankDrive = new DifferentialDrive(frontLeft, frontRight);

  private final DifferentialDrive curveDrive = new DifferentialDrive(frontLeft, frontRight);

  public DriveTrain() {

    backRight.follow(frontRight);
    backLeft.follow(frontLeft);

    frontRight.setInverted(false);
    frontLeft.setInverted(true);
    backRight.setInverted(false);
    backLeft.setInverted(false);
    
  }

  public void arcadeDrive(double forwardSpeed, double rotationSpeed){
    tankDrive.arcadeDrive(forwardSpeed, rotationSpeed);
  }

  public void curvatureDrive(double forwardSpeed, double curvature, boolean turnInPlace){
    curveDrive.curvatureDrive(forwardSpeed, curvature, turnInPlace);
  } 
  //curvature will attempt to drive like a car your turn in place vaiable should be false 99% of the time.
  //In curvature drive you should use two sticks to drive.  one acts as the gas pedal the other like a stearing wheel
  //this will likly be the better method of control with a four wheel pnematic drivetrain due to the difficulties whit turning the robot due friction and non-rotating wheels

  public Command driveArcadeCommand(DoubleSupplier speedSupplier, DoubleSupplier rotationSupplier){
    return this.run(() -> this.arcadeDrive(speedSupplier.getAsDouble(), rotationSupplier.getAsDouble()));
  }

  public Command driveCurvatureCommand(DoubleSupplier speedSupplier, DoubleSupplier rotationSupplier, BooleanSupplier turnInPlaceSupplier){
    return this.run(() -> this.curvatureDrive(speedSupplier.getAsDouble(), rotationSupplier.getAsDouble(), turnInPlaceSupplier.getAsBoolean()));
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
