package com.company;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.io.BufferedReader;
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
    public static void writeToFileFromConsole(String path){

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        System.out.println("вводи:");

        try {
            String command = "wr";
            String line;
            line = br.readLine();
            if ((line = br.readLine()).equals(command)) {
                writer = new FileWriter(path, true);
                bufferedWriter = new BufferedWriter(writer);

                bufferedWriter.append("\n");
                bufferedWriter.append(line);
            }
        }catch (IOException e){
            System.err.println("не не не " + path);
        }
        finally {
            try {
                reader.close();
                br.close();
                if (writer != null){
                    writer.close();
                }
                if (bufferedWriter != null){
                    bufferedWriter.close();
                }
            }catch (IOException e){
                System.err.println("где он " + path);
            }
        }
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
            writeToFileFromConsole(num1 + " " + operation + " " + num2 + " = " + ans);
        }
        }
