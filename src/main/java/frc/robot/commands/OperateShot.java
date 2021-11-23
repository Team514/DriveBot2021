// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShotUtil;

public class OperateShot extends CommandBase {
  /** Creates a new OperateShot. */
  private ShotUtil shotUtil;
  public OperateShot(ShotUtil shotUtil) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shotUtil = shotUtil;
    addRequirements(shotUtil);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shotUtil.setRunning(true);
    shotUtil.setSpeed(.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}