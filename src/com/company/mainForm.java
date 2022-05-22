package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class mainForm implements ActionListener {
    private JPanel panel;
    private JTextField inputNumberOne; // первое число
    private JTextField inputNumberTwo; // второе число
    private JLabel result; // поле результата
    private JButton sumButton; // кнопка суммы
    private JButton minusButton; // кнопка минус
    private JButton multiplyButton; // кнопка умножить
    private JButton divisionButton; // кнопка разделить
    private JButton squareButton; // кнопка квадрат
    private JButton rootButton; // кнопка корень
    private JButton powButton; // кнопка степень
    private JButton clearButton; // кнопка очистить
    private JButton historyButton; // кнопка показать историю
    private JTextArea historyArea; // поле истории
    private JButton clearHistory; // кнопка очистить историю

    mainForm() {
        JFrame jFrame = new JFrame("Калькулятор");

        jFrame.setSize(800, 600);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        historyArea.setEditable(false);
        clearButton.addActionListener(this);
        historyButton.addActionListener(this);
        clearHistory.addActionListener(this);
        jFrame.setContentPane(panel);
        jFrame.setVisible(true);
        historyArea.setVisible(false);


    }

    protected void story() throws IOException {


        File file = new File("files/history.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            historyArea.append(String.valueOf(line + "\n"));
            line = reader.readLine();
        }
    }
    protected void deleteStory() throws IOException {
        try {
            FileWriter fstream1 = new FileWriter("files/history.txt");// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            historyArea.setText("");
            out1.close(); // закрываем
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());}
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {


        if (actionEvent.getActionCommand().equals("Очистить файл истории")) {
            try {
                deleteStory();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (actionEvent.getActionCommand().equals("Показать историю")) {
            try {
                story();
               // historyArea.setText("lf");
                historyArea.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        }
    }




