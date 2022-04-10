package com.company;
import java.util.Scanner;
public class Main {
        protected double sum(double a, double b){
            return a + b;
        }

        protected double minus(double a, double b){
            return a - b;
        }

        protected String multiply(a,b){
            return a*b;
        }

        protected String division(a,b){
            return a/b;
        }

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
                case '+': ans = sum(num1,num2);
                    break;
                case '-': ans = minus(num1,num2);
                    break;
                case '*': ans = multiply(num1,num2);
                    break;
                case '/': ans = division(num1,num2);
                    break;
                default:  System.out.print("тварь");
                    return;
            }
            System.out.print(num1 + " " + operation + " " + num2 + " = " + ans);
        }
    }