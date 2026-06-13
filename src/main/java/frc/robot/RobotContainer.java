// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.FlyWheelToggle;
import frc.robot.commands.PistonFire;
import frc.robot.commands.PistonUnfire;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.FiringCylinder;
import frc.robot.subsystems.FlyWheel;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.math.MathUtil;

import frc.robot.subsystems.DriveTrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final DriveTrain m_robotDrive = new DriveTrain();
  private final FiringCylinder m_Cylinder = new FiringCylinder();
  private final FlyWheel m_FlyWheel = new FlyWheel();


  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    //default Drive Command (arcade drive) students need to practice driving to see which drive method is better for parade
    m_robotDrive.setDefaultCommand(
      m_robotDrive.driveArcadeCommand(
        () -> MathUtil.applyDeadband(m_driverController.getLeftY(), OperatorConstants.kDriveDeadBand),
        () -> MathUtil.applyDeadband(m_driverController.getRightX(), OperatorConstants.kDriveDeadBand)
      )
    );
    //alternate Drive Command (curvature drive) students need to practice driving to see which drive method is better for parade
    //comment out default and uncomment alternate during testing
    //m_robotDrive.setDefaultCommand(
    //  m_robotDrive.driveCurvatureCommand(
    //    () -> MathUtil.applyDeadband(m_driverController.getLeftY(), OperatorConstants.kDriveDeadBand),
    //    () -> MathUtil.applyDeadband(m_driverController.getRightX(), OperatorConstants.kDriveDeadBand),
    //    () -> {if(Math.abs(m_driverController.getLeftY()) < 0.05){
    //            return true;
    //            } else {return false;}
    //          }
    //  )
    //);

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */


  private void configureBindings() {

    // Piston Bindings
    m_driverController.a().onTrue(new PistonFire(m_Cylinder));
    m_driverController.a().onFalse(new PistonUnfire(m_Cylinder));

    // Flywheel Bindings
    m_driverController.leftBumper().onTrue(new FlyWheelToggle(m_FlyWheel));


  }
}
