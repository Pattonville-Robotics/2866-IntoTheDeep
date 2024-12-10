//package org.firstinspires.ftc.teamcode.autonomous;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.util.ElapsedTime;
//import org.firstinspires.ftc.robotcore.external.JavaUtil;
//
//@Autonomous(name = "RRightForward")
//public class RRightForward {
//
//    private DcMotor motorBackLeft;
//    private DcMotor motorBackRight;
//    private DcMotor motorFrontLeft;
//    private DcMotor motorFrontRight;
//
//    double COUNTS_PER_INCH;
//    ElapsedTime runtime;
//
//    public void runOpMode() {
//        int COUNTS_PER_MOTOR_REV;
//        int DRIVE_GEAR_REDUCTION;
//        int WHEEL_DIAMETER_INCHES;
//        double DRIVE_SPEED;
//        double TURN_SPEED;
//
//        DcMotor motorBackRight = hardwareMap.dcMotor.get("backRight");
//        DcMotor motorFrontRight = hardwareMap.dcMotor.get("frontRight");
//        DcMotor motorBackLeft = hardwareMap.dcMotor.get("backLeft");
//        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("frontLeft");
//
//        COUNTS_PER_MOTOR_REV = 1440;
//        DRIVE_GEAR_REDUCTION = 1;
//        WHEEL_DIAMETER_INCHES = 4;
//
//        COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI);
//        DRIVE_SPEED = 0.6;
//        TURN_SPEED = 0.5;
//        runtime = new ElapsedTime();
//
//        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
//        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
//
//        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//        waitForStart();
//
//        // Turn right 12 inches with 4 second timeout.
//        encoderDrive(TURN_SPEED, 12, -12, 4);
//
//        // Forward 48 inches with 5 second timeout.
//        encoderDrive(DRIVE_SPEED, 48, 48, 5);
//    }
//
//
//    private void encoderDrive(double speed, int leftInches, int rightInches, int timeoutS) {
//        double newBackLeftTarget;
//        double newBackRightTarget;
//        double newFrontLeftTarget;
//        double newFrontRightTarget;
//
//        // Ensure that the OpMode is still active.
//        if (opModeIsActive()) {
//            // Determine new target position, and pass to motor controller.
//            newBackLeftTarget = motorBackLeft.getCurrentPosition() + Math.floor(leftInches * COUNTS_PER_INCH);
//            newBackRightTarget = motorBackRight.getCurrentPosition() + Math.floor(rightInches * COUNTS_PER_INCH);
//            newFrontLeftTarget = motorBackLeft.getCurrentPosition() + Math.floor(leftInches * COUNTS_PER_INCH);
//            newFrontRightTarget = motorBackRight.getCurrentPosition() + Math.floor(rightInches * COUNTS_PER_INCH);
//            motorBackLeft.setTargetPosition((int) newLeftTarget);
//            motorBackRight.setTargetPosition((int) newRightTarget);
//
//            // Turn On RUN_TO_POSITION.
//            motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//            // Reset the timeout time and start motion.
//            runtime.reset();
//            backLeft.setPower(Math.abs(speed));
//            backRight.setPower(Math.abs(speed));
//            backLeft.setPower(Math.abs(speed));
//            backRight.setPower(Math.abs(speed));
//
//
//            while (opModeIsActive() && runtime.seconds() < timeoutS && backLeft.isBusy() && backRight.isBusy()) {
//                // Display it for the driver.
//                telemetry.addData("Running to", JavaUtil.formatNumber(newLeftTarget, 7, 0) + " :" + JavaUtil.formatNumber(newRightTarget, 7, 0));
//                telemetry.addData("Currently at", JavaUtil.formatNumber(backLeft.getCurrentPosition(), 7, 0) + " :" + JavaUtil.formatNumber(backRight.getCurrentPosition(), 7, 0));
//                telemetry.update();
//            }
//            // Stop all motion.
//            backLeft.setPower(0);
//            backRight.setPower(0);
//            // Turn off RUN_TO_POSITION.
//            backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            // Optional pause after each move.
//            sleep(250);
//        }
//    }
//}