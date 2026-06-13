// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FlyWheel;

public class FlyWheelToggle extends Command {
  /** Creates a new FlyWheelToggle. */
  FlyWheel m_FlyWheel;

  public boolean isArmed = false;

  public FlyWheelToggle(FlyWheel flyWheel) {

    m_FlyWheel = flyWheel;

    // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(flyWheel);
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_FlyWheel.isArmed) 
    {
      m_FlyWheel.MotorOff();
      m_FlyWheel.isArmed = false;
    }
    else {
      m_FlyWheel.MotorOn();
      m_FlyWheel.isArmed = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}