package com.company;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.*;
import java.io.PrintWriter;
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
    public static void writeToFileFromConsole(String str) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("history.txt"));
        writer.write(str);
        writer.close();
    }
        public static void main(String[] args) throws Exception {
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
            writeToFileFromConsole(num1 + " " + operation + " " + num2 + " = " + ans);
        }
        }
