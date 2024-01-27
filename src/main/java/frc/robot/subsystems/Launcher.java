package frc.robot.subsystems;

import static frc.robot.Constants.LauncherConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase {
    CANSparkMax m_launcher;
    CANSparkMax m_feedWheel;
     
    public Launcher() {
        m_launcher = new CANSparkMax(kLauncherID, MotorType.kBrushed);
        m_feedWheel = new CANSparkMax(kFeederID, MotorType.kBrushed);

        m_feedWheel.setSmartCurrentLimit(kFeedCurrentLimit);
        m_launcher.setSmartCurrentLimit(kLauncherCurrentLimit);
    }

    public Command getIntakeCommand() {
        return this.startEnd(

            () -> {
              setFeedWheel(kIntakeFeederSpeed);
              setLaunchWheel(kIntakeLauncherSpeed);
            },

            () -> {
              stop();
            });     
    }

    public void setFeedWheel(double speed) {
        m_feedWheel.set(speed);
    }

    public void setLaunchWheel(double speed) {
        m_feedWheel.set(speed);
    }

    public void stop() {
        m_launcher.set(0);
        m_feedWheel.set(0);
    }
}
