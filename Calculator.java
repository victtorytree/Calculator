package finalProject;

import java.util.logging.*;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    Logger logger;
    public void addLogger() {
        this.logger = Logger.getLogger(Calculator.class.getName());
        final SimpleFormatter simplef = new SimpleFormatter();
        try {
			FileHandler handler = new FileHandler("calcLogs.txt", true);
			logger.addHandler(handler);
            handler.setFormatter(simplef);	
		} catch (IOException e) {
			logger.log(Level.WARNING,"file don't exist", e);
		}
    }

    public Complex sumOperation(Complex num1, Complex num2) {
        double sum1 = num1.getFirstPart() + num2.getFirstPart();
        double sum2 = num1.getSecondPart() + num2.getSecondPart();
        return new Complex(sum1, sum2);
    }
    public Complex multiplyOperation(Complex num1, Complex num2) {
        double res1 = num1.getFirstPart() * num2.getFirstPart();
        double res2 = num1.getSecondPart() * num2.getSecondPart();
        return new Complex(res1, res2);
    }
    public Complex divideOperation(Complex num1, Complex num2) {
        double divide1 = num1.getFirstPart() / num2.getFirstPart();
        double divide2 = num1.getSecondPart() / num2.getSecondPart();
        return new Complex(divide1, divide2);
    }

    public void initCalculator() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter first number (real part): ");
        double var1 = reader.nextDouble();
        System.out.print("Enter first number (imaginary part without(!) i): ");
        double var2 = reader.nextDouble();
        Complex a = new Complex(var1, var2);
        System.out.print("Enter an operator (+, *, /): ");
        char op = reader.next().charAt(0);
        System.out.print("Enter second number (real part): ");
        double var3 = reader.nextDouble();
        System.out.print("Enter second number (imaginary part without(!) i): ");
        double var4 = reader.nextDouble();
        Complex b = new Complex(var3, var4);
        reader.close();

        Complex res;
        switch(op) {
            case '+': res = sumOperation(a, b);
                System.out.println("\nSum of numbers is " + res);
                break;
            case '*': res = multiplyOperation(a, b);
                System.out.println("\nMultiplication result is " + res);
                break;
            case '/': res = divideOperation(a, b);
                System.out.println("\nDivision result is " + res);
                break;
            default:  System.out.printf("Error! Enter correct operator");
                logger.info("Error!");
                return;
                
        }
        
        logger.info("operation: " + a + " " + op + " " + b + " = " + res);
    }
} 
