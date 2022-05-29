package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;

/**
 * Класс формы
 */
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

    /**
     * Конструктор класса mainForm
     */
    mainForm() {
        JFrame jFrame = new JFrame("Калькулятор");

        jFrame.setSize(800, 600);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        historyArea.setEditable(false);
        clearButton.addActionListener(this);
        inputNumberOne.addKeyListener(new NumberKeyListener());
        historyButton.addActionListener(this);
        clearHistory.addActionListener(this);
        sumButton.addActionListener(this);
        minusButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divisionButton.addActionListener(this);
        squareButton.addActionListener(this);
        rootButton.addActionListener(this);
        powButton.addActionListener(this);

        jFrame.setContentPane(panel);
        jFrame.setVisible(true);
        jFrame.setIconImage(new ImageIcon("image/666.png").getImage());

        historyArea.setVisible(false);
    }

    /**
     * Функция записи строки в файл
     *
     * @param str Строка
     */
    public static void writeToFile(String str) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("files/history.txt", true));
        writer.append(str).append("\r\n");
        writer.close();
    }

    /**
     * Вывод истории из файла
     */
    protected void story() throws IOException {
        File file = new File("files/history.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            historyArea.append(line + "\n");
            line = reader.readLine();
        }
    }

    /*
     * Функция очистка истории в файле
     */
    protected void deleteStory() throws IOException {
        try {
            FileWriter fstream1 = new FileWriter("files/history.txt");// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            historyArea.setText("");
            out1.close(); // закрываем
        } catch (Exception e) {
            System.err.println("Error in file cleaning: " + e.getMessage());
        }
    }

    /**
     * Функция суммирования
     * @param a Первое число
     * @param b Второе число
     * @return double
     */
    protected static double sum(double a, double b) {
        return a + b;
    }

    /**
     * Функция вычитания
     * @param a Первое число
     * @param b Второе число
     * @return double
     */
    protected static double minus(double a, double b) {
        return a - b;
    }

    /**
     * Функция умножения
     * @param a Первое число
     * @param b Второе число
     * @return double
     */
    protected static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Функция деления
     * @param a Первое число
     * @param b Второе число
     * @return double
     */
    protected static double division(double a, double b) {
        return a / b;
    }

    /**
     * Функция возведения в квадрат
     * @param a Число
     * @return double
     */
    protected static double square(double a) {
        return Math.pow(a, 2);
    }

    /**
     * Функция получения квадратного корня
     * @param a Число
     * @return double
     */
    protected static double root(double a) {
        return Math.sqrt(a);
    }

    /**
     * Функция возведения в степень
     * @param a Число
     * @param b Степень
     * @return double
     */
    protected static double pow(double a, double b) {
        return Math.pow(a, b);
    }

    /**
     * Функция обработки для кнопок
     * @param actionEvent Событие
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Очистить")) {
            inputNumberOne.setText("");
            inputNumberTwo.setText("");
            result.setText("");
        }

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
                historyArea.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // обработка кнопки плюс
        if (actionEvent.getActionCommand().equals("+")) {
            result.setText(String.valueOf(sum(Double.parseDouble(inputNumberOne.getText()), Double.parseDouble(inputNumberTwo.getText()))));
            try {
                writeToFile((inputNumberOne.getText() + " + " + (inputNumberTwo.getText() + " = " + sum(Double.parseDouble(inputNumberOne.getText()), Double.parseDouble(inputNumberTwo.getText())))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // обработка кнопки минус
        if (actionEvent.getActionCommand().equals("-")) {
            result.setText(String.valueOf(minus(Double.parseDouble(inputNumberOne.getText()), Double.parseDouble(inputNumberTwo.getText()))));
            try {
                writeToFile((inputNumberOne.getText() + " - " + (inputNumberTwo.getText() + " = " + minus(Double.parseDouble(inputNumberOne.getText()), Double.parseDouble(inputNumberTwo.getText())))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // обработка кнопки умножить
        if (actionEvent.getActionCommand().equals("*")) {
            result.setText(String.valueOf(multiply(Double.parseDouble(inputNumberOne.getText()), Double.parseDouble(inputNumberTwo.getText()))));
            try {
                writeToFile((inputNumberOne.getText() + " * " + (inputNumberTwo.getText() + " = " + multiply(Double.parseDouble(inputNumberOne.getText()), Double.parseDouble(inputNumberTwo.getText())))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // обработка кнопки разделить
        if (actionEvent.getActionCommand().equals("/")) {
            result.setText(String.valueOf(division(Double.parseDouble(inputNumberOne.getText()), Double.parseDouble(inputNumberTwo.getText()))));
            try {
                writeToFile((inputNumberOne.getText() + " / " + (inputNumberTwo.getText() + " = " + division(Double.parseDouble(inputNumberOne.getText()), Double.parseDouble(inputNumberTwo.getText())))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // обработка кнопки квадарт
        if (actionEvent.getActionCommand().equals("Квадрат")) {
            result.setText(String.valueOf(square(Double.parseDouble(inputNumberOne.getText()))));
            try {
                writeToFile((inputNumberOne.getText() + " / " + (inputNumberTwo.getText() + " = " + square(Double.parseDouble(inputNumberOne.getText())))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // обработка кнопки корень
        if (actionEvent.getActionCommand().equals("Корень")) {
            result.setText(String.valueOf(root(Double.parseDouble(inputNumberOne.getText()))));
            try {
                writeToFile((inputNumberOne.getText() + " / " + (inputNumberTwo.getText() + " = " + root(Double.parseDouble(inputNumberOne.getText())))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // обработка кнопки степень
        if (actionEvent.getActionCommand().equals("Степень")) {
            result.setText(String.valueOf(pow(Double.parseDouble(inputNumberOne.getText()), Double.parseDouble(inputNumberTwo.getText()))));
            try {
                writeToFile((inputNumberOne.getText() + " / " + (inputNumberTwo.getText() + " = " + pow(Double.parseDouble(inputNumberOne.getText()), Double.parseDouble(inputNumberTwo.getText())))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Класс слушатель кнопок
     */
    class NumberKeyListener extends KeyAdapter {   // расширяем абстрактный класс KeyAdapter

        /**
         * Функция обработки отжатия кнопки
         * @param event Событие
         */
        public void keyReleased(KeyEvent event) {  // переопределяем необходимые методы
            try {
                Integer.parseInt(String.valueOf(event.getKeyChar()));
            } catch (Exception e) {
                inputNumberOne.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (((c < '0') || (c > '9'))) {
                            e.consume();
                        }
                    }
                });
                inputNumberTwo.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (((c < '0') || (c > '9'))) {
                            e.consume();
                        }
                    }
                });
            }
        }
    }
}