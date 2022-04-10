package com.company;
import java.util.Scanner;
public class Main {
        public static void main(String[] args) {
            double num1;
            double num2;
            double ans;
            char operation;
            Scanner reader = new Scanner(System.in);
            System.out.print("Вводи");
            num1 = reader.nextDouble();
            num2 = reader.nextDouble();
            System.out.print("Вводи операцию (+, -, *, /): ");
            operation = reader.next().charAt(0);
            switch(operation) {
                case '+': ans = num1 + num2;
                    break;
                case '-': ans = num1 - num2;
                    break;
                case '*': ans = num1 * num2;
                    break;
                case '/': ans = num1 / num2;
                    break;
                default:  System.out.print("тварь");
                    return;
            }
            System.out.print(num1 + " " + operation + " " + num2 + " = " + ans);
        }
    }