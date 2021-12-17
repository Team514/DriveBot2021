// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CollectorUtil extends SubsystemBase {
  private DoubleSolenoid collectorSolenoid;
  private TalonSRX intakeMotor;

  public CollectorUtil() {
    collectorSolenoid = new DoubleSolenoid(Constants.forwardSolenoid, Constants.reverseSolenoid);
    intakeMotor = new TalonSRX(Constants.intakeMotor);
    intakeMotor.setInverted(true);
  }

  public void toggleCollector() {
    if(collectorSolenoid.get().equals(Value.kForward)) {
      collectorSolenoid.set(Value.kReverse);
    } else {
      collectorSolenoid.set(Value.kForward);
    }
  }

  public boolean isCollectorDeployed() {
    return collectorSolenoid.get().equals(Value.kForward);
  }

  public void setIntakeSpeed(boolean enabled) {
    if (enabled) {
      intakeMotor.set(ControlMode.PercentOutput, 1.0);
    } else {
      intakeMotor.set(ControlMode.PercentOutput, 0.0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Intake Motor Speed", intakeMotor.getMotorOutputPercent());
    SmartDashboard.putBoolean("Is Collector Deployed", collectorSolenoid.get().equals(Value.kForward));

  }
}
