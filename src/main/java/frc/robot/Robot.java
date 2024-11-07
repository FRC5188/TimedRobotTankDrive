// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  // TODO: Instantiate motor controller objects (Ender lore is gonna try this and it's probably gonna be bad but okay whatever lets go)

  private final TalonFX _frontLeftDriveMotor = new TalonFX(1);
  private final TalonFX _frontRightDriveMotor = new TalonFX(2);
  private final TalonFX _backLeftDriveMotor = new TalonFX(3);
  private final TalonFX _backRightDriveMotor = new TalonFX(4);
  // Directly above: Change the "=TalonFX(#)" at the end to the nessecary motor ID's when or if nessecary. (Ender Lore)

  // TODO: Instantiate motor controller group objects (Ender lore is gonna try this and it's probably gonna be bad but okay whatever lets go)

  private final MotorControllerGroup _leftDriveMotors = new MotorControllerGroup (_frontLeftDriveMotor, _backLeftDriveMotor);
  private final MotorControllerGroup _rightDriveMotors = new MotorControllerGroup (_frontRightDriveMotor, _backRightDriveMotor);

  // TODO: Instantiate Xbox controller object (Ender lore is gonna try this and it's probably gonna be bad but okay whatever lets go)

  private final XboxController controller = new XboxController(0);

  // TODO: Declare differential drive object (Ender lore is gonna try this and it's probably gonna be bad but okay whatever lets go)

  private DifferentialDrive _drive;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    // TODO: Call any necessary motor controller group methods

    // TODO: Instantiate differential drive object

    _drive = new DifferentialDrive(_leftDriveMotors, _rightDriveMotors);

  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    // TODO: Create a "speed" variable to store the left y-axis value from the controller
    
    double Speed=(controller.getLeftY());

    // TODO: Create a "rotation" variable to store the right x-axis value from the controller

    double Rotation=(controller.getRightX());

    // TODO: Call methods on the differential drive object to drive the robot    
    
    _drive.arcadeDrive(Speed, Rotation);
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}

// (Ender Lore) we should make the robot self-aware and show it skibidi toilet