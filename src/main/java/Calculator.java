package calc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import java.util.Scanner;
public class calc {
    public double squareRoot(double num)
    {
        double output = 0;
        try{
            logger.info("Calculating Square root  of number " + num);
            if(num < 0){
                output = Double.NaN;
                throw new ArithmeticException("Invalid Input, Enter Number greater than 0");
            }
            else{
                output = Math.sqrt(num);
            }
        }catch(ArithmeticException err){
            logger.error("Number cannot be smaller than 0. " + err.getMessage());
        }finally {
            logger.info("Square Root is : " + output);
        }

        return output;
    }


    public double naturalLog(double num) {
        double output = 0;
        try{
            logger.info("Calculating Natural log of " + num);
            if(num <= 0){
                output = Double.NaN;
                throw new ArithmeticException("Invalid Input, Enter Number greater than 0");
            }
            else{
                output = Math.log(num);
            }
        }
        catch(ArithmeticException err){
            logger.error("Number cannot be less than 0. " + err.getMessage());
        }
        finally {
            logger.info("Result of naturalLog is : " + output);
        }
        return output;
    }


    public double fact(double num)
    {
        double output = 1;
        try{
            if(num < 0) {
                output = Double.NaN;
                throw new ArithmeticException("Invalid Input, Enter Number greater than 0");
            }
            if(num!=(int)num)
            {
                output = Double.NaN;
                throw new ArithmeticException("Number not an integer");
            }

            if(num == 0 || num == 1) return 1;

            for(int i = 1; i <= num; i++){
                output *= i;
            }
        }
        catch(ArithmeticException err) {
            logger.error("Number cannot be less than 0. " + err.getMessage());
        }
        finally {
            logger.info("Factorial is : " + output);
        }

        return output;
    }


    public double power(double num1, double num2)
    {
        double output = 0;
        if(num1==0.0&&num2==0.0)
        {
            output = Double.NaN;
            logger.info("0 power 0 is not defined");
            return output;
        }
        try {
            logger.info("Calculating Power  of two numbers " + num1 + " and " + num2);
            output = Math.pow(num1, num2);
            if(output==Double.NaN) {
                throw new ArithmeticException("Power is not real");
            }
        }catch (ArithmeticException ae)
        {
            logger.error(ae.getMessage());
        }
        logger.info("Result of power is : " + output);
        return output;
    }

    private static final Logger logger = LogManager.getLogger(calc.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        double num1, num2;
        calc calculator = new calc();
        Scanner scanner = new Scanner(System.in);
        char choice='y';
        do {


            System.out.print("Enter an operator \n 1. Square Root \n 2. Factorial \n 3. Natural Log \n 4. Power  ");
            char operator = scanner.next().charAt(0);
            //scanner.close();
            double output=0.0;

            switch (operator) {
                case '1':
                    System.out.print("Enter first number:");
                    num1 = scanner.nextDouble();
                    try {
                        output = calculator.squareRoot(num1)   ;
                    }catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;

                case '2':
                    System.out.print("Enter first number:");
                    num1 = scanner.nextDouble();
                    output = 1;
                    try {
                        output = calculator.fact(num1);
                    }catch (Exception e)
                    {
                        System.out.println(e);
                    }

                    //output = num1;
                    break;

                case '3':
                    System.out.print("Enter first number:");
                    num1 = scanner.nextDouble();
                    try {
                        output = calculator.naturalLog( num1);
                    }catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;

                case '4':
                    System.out.print("Enter first number:");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number:");
                    num2 = scanner.nextDouble();
                    try {
                        output = Math.pow(num1, num2);
                    }catch(Exception e)
                    {
                        System.out.println(e);
                    }

                    break;

                default:
                    System.out.printf("You have entered wrong operator");
                    return;
            }

            System.out.println("Output: " + output);
            System.out.println("Press y to continue");
            choice = scanner.next().charAt(0);
        }while(choice=='y');
        scanner.close();
    }
}
