package com.company;
import java.util.Scanner;
public class Main {
        protected static double sum(double a, double b){
            return a + b;
        }

        protected static double minus(double a, double b){
            return a - b;
        }

        protected static double multiply(double a, double b){
            return a*b;
        }

        protected static double division(double a, double b){
            return a/b;
        }

        protected static double square(double a){
            return Math.pow(a,2);
        }

        protected static double root(double a){
            return Math.sqrt(a);
        }

        protected static double pow(double a, double b){
            return Math.pow(a, b);
        }



         public static void main(String[] args) {
            System.out.println(Math.pow(4,2));
            System.out.println(Math.sqrt(4));
            System.out.println(Math.pow(4,4));
            double num1;
            double num2;
            double ans;
            String operation;
            Scanner reader = new Scanner(System.in);
            System.out.print("Вводи");
            num1 = reader.nextDouble();
            num2 = reader.nextDouble();
            System.out.print("Вводи операцию (+, -, *, /): ");
            operation = reader.next();
            switch(operation) {
                case "+": ans = sum(num1,num2);
                    break;
                case "-": ans = minus(num1,num2);
                    break;
                case "*": ans = multiply(num1,num2);
                    break;
                case "/": ans = division(num1,num2);
                    break;
                case "square": ans = square(num1);
                    break;
                case "root": ans = root(num1);
                    break;
                case "pow": ans = pow(num1,num2);
                    break;
                default:  System.out.print("тварь");
                    return;
            }
            System.out.print(num1 + " " + operation + " " + num2 + " = " + ans);
        }
    }