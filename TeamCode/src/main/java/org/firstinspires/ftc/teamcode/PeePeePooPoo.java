package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class PeePeePooPoo extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor myMotor = hardwareMap.get(DcMotor.class, "fromage");
        DcMotor myMotor2 = hardwareMap.get(DcMotor.class, "du_vin");
        myMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        myMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Servo myServo = hardwareMap.get(Servo.class, "servo");
        final double turnSpeed = 0.001;
        final double max_right = .32;
        final double min_left = .0;
        final double addToServo = 0.0001;
        final double centerPos = 0.19;

        while(opModeInInit()) {
            telemetry.addData("servo position", myServo.getPosition());
            myMotor2.setDirection(DcMotorSimple.Direction.REVERSE);
            myServo.setPosition(centerPos);



        }


        waitForStart();

        while(opModeIsActive()) {
            telemetry.addData("servo position", myServo.getPosition());
            telemetry.update();
            double drive = gamepad1.right_trigger;
            double back = gamepad1.left_trigger;
            double motion = drive - back;

            myMotor.setPower(motion);
            myMotor2.setPower(motion);

            if(myServo.getPosition()>= 0 && myServo.getPosition() <= 0.32){
                myServo.setPosition(myServo.getPosition()+turnSpeed*gamepad1.right_stick_x);
            }
            else {
                myServo.setPosition(0.32z);
            }
            if (gamepad1.a){
                requestOpModeStop();
            }


        }
    }
}
