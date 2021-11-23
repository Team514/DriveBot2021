// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.OperateDrive;
import frc.robot.commands.OperateShot;
import frc.robot.subsystems.DriveUtil;
import frc.robot.subsystems.ShotUtil;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  private final DriveUtil driveUtil = new DriveUtil();
  private final ShotUtil shotUtil = new ShotUtil();

  // Commands
  private final OperateDrive operateDrive = new OperateDrive(driveUtil);
  // private final OperateShot operateShot = new OperateShot(shotUtil);

  // Joysticks and controllers
  private static Joystick leftJoystick, rightJoystick, controller;

  private static XboxController xbox;

  // JoystickButton objects
  private JoystickButton toggleDriveMode, runShotMotor;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    leftJoystick = new Joystick(Constants.leftJoystick);
    rightJoystick = new Joystick(Constants.rightJoystick);
    controller = new Joystick(Constants.controller);
    xbox = new XboxController(Constants.controller);
    
    // Configure the button bindings
    configureButtonBindings();

    // Configure the default commands
    configureSubsystemDefaultCommands();
  }

  /**
   * Use this method to define your button->command mappings.
   */
  private void configureButtonBindings() {
    // Initialize JoystickButton objects
    toggleDriveMode = new JoystickButton(rightJoystick, Constants.kJoystickButton1);
    runShotMotor = new JoystickButton(controller, Constants.kAButtonNum);
    // Define what each JoystickButton does
    toggleDriveMode.whenPressed(new InstantCommand(() -> driveUtil.toggleDriveMode(), driveUtil));
    runShotMotor.whenPressed(new InstantCommand(() -> shotUtil.toggleShotMotor(), shotUtil));
  }

  /**
   * Use this method to define your subsystem's default commands.
   */
  private void configureSubsystemDefaultCommands() {
    driveUtil.setDefaultCommand(operateDrive);
  }

  public static double getLeftJoystickX() {
    return leftJoystick.getX();
  }

  public static double getLeftJoystickY() {
    return leftJoystick.getY();
  }

  public static double getRightJoystickX() {
    return rightJoystick.getX();
  }

  public static double getRightJoystickY() {
    return rightJoystick.getY();
  }

  // -1.0 -> 0.0 -> 1.0

  public static double getRightXboxTrigger() {
    return xbox.getTriggerAxis(GenericHID.Hand.kRight);
  }

  public static double getLeftXboxTrigger() {
    return xbox.getTriggerAxis(GenericHID.Hand.kLeft);
  }

  public static double getLeftXboxJoystickX() {
    return xbox.getX(GenericHID.Hand.kLeft);
  }

  

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
