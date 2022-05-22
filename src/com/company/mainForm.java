package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.net.URL;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


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
        inputNumberOne.addKeyListener(new NumberKeyListener());
        jFrame.setContentPane(panel);
        jFrame.setVisible(true);
        jFrame.setIconImage(new ImageIcon("image/666.png").getImage());

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Очистить")) {
            result.setText("");
            inputNumberOne.setText("");
            inputNumberTwo.setText("");
        }
    }
    class NumberKeyListener extends KeyAdapter {   // расширяем абстрактный класс KeyAdapter

        public void keyReleased(KeyEvent event) {  // переопределяем необходимые методы
            char c = event.getKeyChar();
            try {
                Integer.parseInt(String.valueOf(event.getKeyChar()));
            }catch (Exception e){
                inputNumberOne.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ( ((c < '0') || (c > '9'))) {
                            e.consume();
                        }
                    }
                });
                inputNumberTwo.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ( ((c < '0') || (c > '9'))) {
                            e.consume();
                        }
                    }
                });
            }
        }
    }
}