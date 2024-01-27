package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.*;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    DifferentialDrive m_drivetrain;

  public DriveTrain(){
    CANSparkMax leftFront = new CANSparkMax(kLeftFrontID, MotorType.kBrushed);
    CANSparkMax leftBack = new CANSparkMax(kLeftRearID, MotorType.kBrushed);
    CANSparkMax rightFront = new CANSparkMax(kRightFrontID, MotorType.kBrushed);
    CANSparkMax rightBack = new CANSparkMax(kRightRearID, MotorType.kBrushed);

    leftFront.setSmartCurrentLimit(kCurrentLimit);
    leftBack.setSmartCurrentLimit(kCurrentLimit);
    rightFront.setSmartCurrentLimit(kCurrentLimit);
    rightBack.setSmartCurrentLimit(kCurrentLimit);


    


    rightFront.setInverted(true);
    leftFront.setInverted(false);

    rightBack.follow(rightFront);
    leftBack.follow(leftFront);

    m_drivetrain = new DifferentialDrive(rightFront, leftFront);
  }

  public void arcadeDrive(double speed, double rotation){
    m_drivetrain.arcadeDrive(speed, rotation);
  }

public void setDefaultCommand(RunCommand runCommand) {
   }
}
