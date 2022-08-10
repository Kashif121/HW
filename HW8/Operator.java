/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operator;

import java.util.Scanner;

public class Operator {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        double firstNumber;
        double secondNumber;
        String operator;

        System.out.println("Input a new set of numbers and operator. Make sure to put a space between operator and number.");

        firstNumber = sc.nextDouble();
        operator = sc.next();
        secondNumber = sc.nextDouble();

        while (firstNumber != 0.0) {
            if (operator.equals("+")) {
                double sum;
                sum = firstNumber + secondNumber;
                System.out.println(firstNumber + " " + operator + " " + secondNumber + " =" + " " + sum);

            } else if (operator.equals("-")) {
                double difference;
                difference = firstNumber - secondNumber;
                System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + " " + difference);

            } else if (operator.equals("*")) {
                double product;
                product = firstNumber * secondNumber;
                System.out.println(firstNumber + " " + operator + " " + secondNumber + " =" + " " + product);

            } else {
                double division;
                division = firstNumber / secondNumber;
                System.out.println(firstNumber + " " + operator + " " + secondNumber + " =" + " " + division);

            }
            
            System.out.println("Input a new set of numbers and operator. Make sure to put a space between operator and number.");
            firstNumber = sc.nextDouble();
            operator = sc.next();
            secondNumber = sc.nextDouble();
        }

    }

}
