package lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyWindow extends JFrame {
    public MyWindow() {
        JTextArea jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        JButton button1 = new JButton("Нажми меня");
        add(button1, BorderLayout.SOUTH);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText("");

                JFrame jFrame2 = new JFrame();
                jFrame2.setVisible(true);
                jFrame2.setBounds(500, 300, 400, 400);

                JPanel jPanel = new JPanel(new GridLayout(4, 1));
                jFrame2.add(jPanel);

                JTextField jTextField1 = new JTextField();
                JTextField jTextField2 = new JTextField();
                JTextField jTextField3 = new JTextField();

                jPanel.add(jTextField1);
                jPanel.add(jTextField2);
                jPanel.add(jTextField3);

                JButton button2 = new JButton("Заполнить ФИО");
                jPanel.add(button2, BorderLayout.SOUTH);

                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jTextArea.append(jTextField1.getText() + "\n");
                        jTextArea.append(jTextField2.getText()+ "\n");
                        jTextArea.append(jTextField3.getText()+ "\n");
                        jFrame2.setVisible(false);
                    }
                });
            }
        });

        add(jTextArea, BorderLayout.NORTH);
        setBounds(500, 300, 400, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class Main {
    public static void main(String[] args) {
        new MyWindow();
    }
}


