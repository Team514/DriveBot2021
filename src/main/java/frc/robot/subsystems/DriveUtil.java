// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.handlers.DriveMode;

public class DriveUtil extends SubsystemBase {
  // Motor controllers
  private WPI_VictorSPX leftPrimary, leftSecondary, rightPrimary, rightSecondary;

  // Speed
  private double speed, xSpeed, left, right; 

  // Drive controller
  private DifferentialDrive differentialDrive;

  // DriveMode defaults to TANK
  private DriveMode driveMode = DriveMode.XBOX;

  public DriveUtil() {
    // Initialize speed controllers (VictorSPX)
    leftPrimary = new WPI_VictorSPX(Constants.driveMotor_LeftPrimary);
    leftSecondary = new WPI_VictorSPX(Constants.driveMotor_LeftSecondary);
    rightPrimary = new WPI_VictorSPX(Constants.driveMotor_RightPrimary);
    rightSecondary = new WPI_VictorSPX(Constants.driveMotor_RightSecondary);


    // Set secondaries to follow primaries
    leftSecondary.follow(leftPrimary);
    rightSecondary.follow(rightPrimary);

    // Invert motors
    leftPrimary.setInverted(true);
    leftSecondary.setInverted(true);
    rightPrimary.setInverted(true);
    rightSecondary.setInverted(true);

    // Initialize DifferentialDrive controller
    differentialDrive = new DifferentialDrive(leftPrimary, rightPrimary);
  }


  public void toggleDriveMode() {
    if (driveMode.equals(DriveMode.ARCADE)) {
      driveMode = DriveMode.TANK;
    } else {
      driveMode = DriveMode.ARCADE;
    }
  }

  /**
   * Drive the robot based on the driveMode class parameter.
   * If in TANK mode, use leftX and rightX values.
   * If in ARCADE mode, use rightX and rightY values.
   * 
   * The DifferentialDrive class will square inputs for us.
   * Squaring inputs results in less sensitive inputs.
   * 
   * @param leftX the left controller's X (forward-backward) value
   * @param leftY the left controller's Y (left-right) value
   * @param rightX the right controller's X (forward-backward) value
   * @param rightY the right controller's Y (left-right) value
   */
  public void driveRobot() {

    switch (driveMode) {
      case TANK:
        differentialDrive.tankDrive(RobotContainer.getLeftJoystickY(), RobotContainer.getRightJoystickY());
        break;
      
      case ARCADE:
        differentialDrive.arcadeDrive(RobotContainer.getRightJoystickY(), RobotContainer.getRightJoystickX());
        break;

      case XBOX: 
        speed = -RobotContainer.getRightXboxTrigger() + RobotContainer.getLeftXboxTrigger();
        xSpeed = RobotContainer.getLeftXboxJoystickX();

        // left = xSpeed * speed;
        // right = xSpeed * speed * -1;


        differentialDrive.arcadeDrive(speed * 0.75, -xSpeed, true);
        break;

      default:
        differentialDrive.tankDrive(0.0, 0.0);
        break;

    }
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("drive speed", speed);
    SmartDashboard.putNumber("left speed", left);
    SmartDashboard.putNumber("right speed", right);
    // This method will be called once per scheduler run
  }



}
