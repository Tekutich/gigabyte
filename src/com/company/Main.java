package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.*;
import java.io.PrintWriter;

public class Main {
    protected static double sum(double a, double b) {
        return a + b;
    }

    protected static double minus(double a, double b) {
        return a - b;
    }

    protected static double multiply(double a, double b) {
        return a * b;
    }

    protected static double division(double a, double b) {
        return a / b;
    }

    protected static double square(double a) {
        return Math.pow(a, 2);
    }

    protected static double root(double a) {
        return Math.sqrt(a);
    }

    protected static double pow(double a, double b) {
        return Math.pow(a, b);
    }

    public static void writeToFileFromConsole(String str) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("history.txt"));
        writer.write(str);
        writer.close();
    }

    protected static void story() throws IOException {
        File file = new File("history.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        double num1 = 0;
        double num2;
        double ans = 0;
        String operation;
        Scanner reader = new Scanner(System.in);
        System.out.print("Вводи 1 число или history:");
        String type = reader.next();
        if (Objects.equals(type, "history")) {
            story();
            System.exit(0);
        } else {
            num1 = Double.parseDouble(type);
        }
        System.out.print("Вводи 2 число:");
        num2 = reader.nextDouble();
        System.out.print("Вводи операцию (+, -, *, /,ну или то что у руслана ┐(シ)┌): ");
        operation = reader.next();
        switch (operation) {
            case "+":
                ans = sum(num1, num2);
                break;
            case "-":
                ans = minus(num1, num2);
                break;
            case "*":
                ans = multiply(num1, num2);
                break;
            case "/":
                ans = division(num1, num2);
                break;
            case "square":
                ans = square(num1);
                break;
            case "root":
                ans = root(num1);
                break;
            case "pow":
                ans = pow(num1, num2);
                break;
            default:
                System.out.print("нет такого");
                return;
        }
        System.out.print(num1 + " " + operation + " " + num2 + " = " + ans);
        writeToFileFromConsole(num1 + " " + operation + " " + num2 + " = " + ans);
    }
}
