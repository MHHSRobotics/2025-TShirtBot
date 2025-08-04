// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private final DifferentialDrive robotDrive;
  private final PS5Controller controller;

  private final Spark leftMotor1 = new Spark(0);
  private final Spark leftMotor2 = new Spark(1);
  private final Spark rightMotor1 = new Spark(2);
  private final Spark rightMotor2 = new Spark(3);

  /** Called once at the beginning of the robot program. */
  public Robot() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    rightMotor1.setInverted(true);
    rightMotor2.setInverted(true);

    robotDrive = new DifferentialDrive((s)->{leftMotor1.set(s);leftMotor2.set(s);}, (s)->{rightMotor1.set(s);rightMotor2.set(s);});
    controller = new PS5Controller(0);

    SendableRegistry.addChild(robotDrive, leftMotor1);
    SendableRegistry.addChild(robotDrive, leftMotor2);
    SendableRegistry.addChild(robotDrive, rightMotor1);
    SendableRegistry.addChild(robotDrive, rightMotor2);
  }

  @Override
  public void teleopPeriodic() {
    robotDrive.arcadeDrive(-controller.getLeftY(), -controller.getLeftX());
  }
}
/*        .                                       . .        .                                        
        .                               .          .                                                
             .           .       .                .               .   %*.   .    .           @#@    
 . .        .         .                                .    .         #  ##                @*  @    
                 . .    . .                             .    .        #=  .@@ @      .@@ @@-  ##    
                                 .                  .                  .  .=@-.:@@@@@@..@@+.  .. .  
       .    . .                .                                    .  .=    %%=@    @-%#    =:+    
                    .        .   . .                                   ## :#.:.@ @* @ @.%*##  #*    
.                                      . .      .                      @ .+  - @ @@@@ @ %.  @ *@    
       .    .  .                              ..                      ..   %@@@@ =  % @@@@@ . @#    
                    .                                        .        +..@  .@.%  =- +@.@   *@ @.   
                                                    .                .@@@.@.=  @@  ..@@    .@@@@    
                        . .                            ..     .           @ @  .#. .@=..:@%@@...    
                                       .  .                    .   .  ..@@@#. #. @@@@ #@  @@@@@    .
   . .                                .                    .         @@   . .     @.        .@@     
               .                       .      .             .    . +@%+    =    @@@@@@ .  @.:       
           .       .                            . .      @@@@@@@@@@@@ -#-@:-+@%.      =@@@@.@    .  
                                              .    .@@@@@@@   @@.=@@@ @#  .@%@@@@@@@@@@@@@@@+@@     
               .        .   .     .       .      .@@@=  @@  -@+ :@@ @  @= @ :@@@@@@*%#*%@@@*@+@.    
                             .     .           @@@*@  @@@. @@+ .@.@=@  .@  +   .%@*-#-@%=.:@@+@+    
 .   .                                .      =@@+#@  %@@  @@- +@@#@@ +. @@@ -@@   ..  : .%@++@@     
                         .               .  @@-@@@@  @@   @@  .@@.@@      @@@     ..:%#@@*+@@@.     
 .                .     .                  @@@  @@   @@  @@@ .@@ %#-        @@@@@@@@@@@@@@@@ +      
                                 . .     -@@@  @@-  @@  @@@  .@#+@.@@#  .@@    .  .         @@      
                                     .  @@@   @- .@@.   +@@  @@@@-   #@@%.@@#     .. %    .@@.      
    .     ..                           %@ .=..@@:  @@   .@#  @@@  @@@@@     % .*.. -@ ==. :@@    .  
                .                     -@@#     %@@   %. :@@=.@@@**@@%@@: @%::=*    %.   *@@@        
 .                  .                .@ @@@@.    @@@  %@@@#. @@@@@@   %@.. %  #.:# @ =+=@@@        .
                             .  .    @@  .@@@@@    @@- .@  ..@%@@.  .    @@@   .   * %...@          
                                    @@@     @@@@@@  .@@ @@  :@@@  @@@@@    % @@ : -#   *@- .        
  .                      .     .   .@%@*@@     =@@@= %@  @+ .@:*@@@@@@@@@@-  @ . .   @@@@           
       .             .              @.:@. @@      :@@ @# @@  @@@@ :     .@@@#. %=  -@@@@            
                       .           .@@@ @@  #+.   . @@.  ..  .@ @@@@       @@. .   @#.:#            
                 .                  @@%@%*@@@@* #:   @@@@-@ . -@@           +* . @@@%=@=   .        
   @@@@@    ..                      @@@:@+    @@  :    #@+# :#   @@@@@@@@@@@%:.@@@@@@@@             
    @@@@@@@                        .*@@* @@@@@@ @@:      ..   .@*@:@@@%@#  @@@@@@@.  *#  .   .   .  
    @@@@@@@@@              .    .    @@*.@-.  .@@= @%:    .   . .           *@@..    -              
.    #@@@@@@  :@@          .          @#@@ .@@     *:@@@%.    .  - .   -@    .@      @              
       @@@   .@@@@@ .=            @@@@@@=@@@@@@@@@@*+   .     #..@@@@@@@@@    .    @@@              
        .@@@@@@@@@  @@@@@@@@@@@@@@@#@@*+@..-%@@# @@@@@@.     .    #  @@@ -@   @@. . @%              
        .  @@@@@@  @@@-  @@@.  @@ @=@@-:@%@@@@@@@@@-@+@*@@@@%@ -#@@-    %@      .: %@               
              @@@@@@@@-  +@@   @@ @-@@=.@@@@@@@@@@@@@@@@@@@@@@@%%%@@ @@+:..-. = #   @               
.               . @@@@@@@@@@@: @@+@@#@#@@@@@@@@@@+-  . .     +@@@@@@ @@%@@#@@ *...@@@..             
       .  .           .%@@@@@@@@@@@@@@@@@@  @@@@@@@@@@@=.   % @@@@@@ +   @  @.@@=. .@ : +           
                                     .        .     @@@@@@@@@@     @@@*%@@#@@@ @@@@:@@@@@       .   
                      .      .                      .               .                 . .           
                                     .      .                           .                            */