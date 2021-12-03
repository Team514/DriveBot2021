// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallMagnetUtil extends SubsystemBase {
  /** Creates a new BallMagnetUtil. */
  private DoubleSolenoid testSolenoid;



  public BallMagnetUtil() {
    testSolenoid = new DoubleSolenoid(3,4);
  }

  public void toggleBallMagnet() {
    if(testSolenoid.get().equals(Value.kForward)) {
      testSolenoid.set(Value.kReverse);
    } else {
      testSolenoid.set(Value.kForward);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
