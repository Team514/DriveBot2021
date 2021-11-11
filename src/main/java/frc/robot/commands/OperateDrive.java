// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveUtil;

public class OperateDrive extends CommandBase {
  // Local driveUtil object
  private DriveUtil driveUtil;

  /** Creates a new OperateDrive. */
  public OperateDrive(DriveUtil driveUtil) {
    // Set OperateDrive's local driveUtil value to the value passed in above
    this.driveUtil = driveUtil;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveUtil);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Tell DriveUtil to set the drive motors based on the Joystick's values
    driveUtil.driveRobot(
      RobotContainer.getLeftJoystickX(),
      RobotContainer.getLeftJoystickY(),
      RobotContainer.getRightJoystickX(),
      RobotContainer.getRightJoystickY()
    );
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
