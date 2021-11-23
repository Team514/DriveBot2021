// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShotUtil extends SubsystemBase {
  /** Creates a new ShotUtil. */

  CANSparkMax shotMotor1, shotMotor2;
  CANEncoder encoder;
  boolean running = false;
  boolean shooting = false;
  double targetRPM = 0;

  public ShotUtil() {
    shotMotor1 = new CANSparkMax(Constants.shotMotor1, CANSparkMaxLowLevel.MotorType.kBrushless);
    shotMotor2 = new CANSparkMax(Constants.shotMotor2, CANSparkMaxLowLevel.MotorType.kBrushless);
    encoder = shotMotor1.getEncoder();
    shotMotor1.setInverted(true);
    shotMotor2.follow(shotMotor1, true);
  }

  public void setSpeed(double speed) {
    shotMotor1.set(speed);
  }

  // If true, we want the shot motor to spin.
  // If false, we want the shot motor to stop.
  public void setRunning(boolean b) {
    running = b;
  }

  public boolean isRunning() {
    return running;
  }

  public void toggleShotMotor() {
    if (running) {
      running = false;
    } else {
      running = true;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("isRunning", isRunning());
    SmartDashboard.putNumber("shotMotor1 speed", shotMotor1.get());
    SmartDashboard.putNumber("shotMotor2 speed", shotMotor2.get());
    if (running) {
      setSpeed(1.0);
    } else {
      setSpeed(0.0);
    }
  }
}
