package com.company;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception {
        //Ветка Артёма
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String sAge = bufferedReader.readLine();
        int a = Integer.parseInt(sAge);

        int b = a*2;

        System.out.println(b);

    }
    protected Integer sum(a, b){
        return a + b;
    }
    protected Integer minus(a, b){
        return a - b;
    }
}
