// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
  /**
   * Motor controller Mapping
   */
  public static int driveMotor_LeftPrimary = 2;
  public static int driveMotor_LeftSecondary = 3;
  public static int driveMotor_RightPrimary = 0;
  public static int driveMotor_RightSecondary = 1;
  // ShotUtil
  public static int shotMotor1 = 7;
  public static int shotMotor2 = 8;


  //CollectorUtil
  public static final int forwardSolenoid = 4;
  public static final int reverseSolenoid = 3;
  public static final int intakeMotor = 6;

  /**
   * Controller Input Device Mapping
   */
  public static int leftJoystick = 0;
  public static int rightJoystick = 1;
  public static int controller = 2;

  /**
   * Joystick Button Mapping
   */
  public static final int kJoystickButton1 = 1;
  public static final int kJoystickButton2 = 2;
  public static final int kJoystickButton3 = 3;
  public static final int kJoystickButton4 = 4;
  public static final int kJoystickButton5 = 5;
  public static final int kJoystickButton6 = 6;
  public static final int kJoystickButton7 = 7;
  public static final int kJoystickButton8 = 8;
  public static final int kJoystickButton9 = 9;
  public static final int kJoystickButton10 = 10;
  public static final int kJoystickButton11 = 11;
  public static final int kJoystickButton12 = 12;

  /**
   * Controller Button Mapping
   */
  public static final int kLeftXAxisNum = 0;
  public static final int kLeftYAxisNum = 1;
  public static final int kRightXAxisNum = 2;
  public static final int kRightYAxisNum = 3;

  public static final int kXButtonNum = 1;
  public static final int kAButtonNum = 2;
  public static final int kBButtonNum = 3;
  public static final int kYButtonNum = 4;
  public static final int kLeftBumperNum = 5;
  public static final int kRightBumperNum = 6;
  public static final int kLeftTriggerNum = 7;
  public static final int kRightTriggerNum = 8;
  public static final int kBackButtonNum = 9;
  public static final int kStartButtonNum = 10;
  public static final int kLeftStickButtonNum = 11;
  public static final int kRightStickButtonNum = 12;
}
