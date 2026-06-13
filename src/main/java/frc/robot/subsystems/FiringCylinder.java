// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;;

public class FiringCylinder extends SubsystemBase {
  /** Creates a new FiringPin. */
  public static DoubleSolenoid fire;

  public FiringCylinder() {
    fire = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,Constants.FowardChannel, Constants.ReverseChannel); //CTRE PCM = PneumaticsControlModule
  }

  public void FiringPinForward(){
    fire.set(Value.kForward);
  }
  
  public void FiringPinBackward(){
    fire.set(Value.kReverse);
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}