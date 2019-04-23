package lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyWindow extends JFrame {
    JTextArea jTextArea = new JTextArea();
    SubWindow subWindow;
    public MyWindow() {
        jTextArea.setEditable(false);
        JButton button1 = new JButton("Нажми меня");
        add(button1, BorderLayout.SOUTH);

        subWindow = new SubWindow(this);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText("");
                subWindow.setVisible(true);
            }
        });

        add(jTextArea, BorderLayout.NORTH);
        setBounds(500, 300, 400, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class SubWindow extends JFrame {
    MyWindow myWindow;
    public SubWindow(MyWindow myWindow) {
        this.myWindow = myWindow;

        JPanel jPanel = new JPanel(new GridLayout(4, 1));

        JTextField jTextField1 = new JTextField();
        JTextField jTextField2 = new JTextField();
        JTextField jTextField3 = new JTextField();

        jPanel.add(jTextField1);
        jPanel.add(jTextField2);
        jPanel.add(jTextField3);

        add(jPanel);

        JButton button2 = new JButton("Заполнить ФИО");
        jPanel.add(button2, BorderLayout.SOUTH);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myWindow.jTextArea.append(jTextField1.getText() + "\n");
                myWindow.jTextArea.append(jTextField2.getText() + "\n");
                myWindow.jTextArea.append(jTextField3.getText() + "\n");
                setVisible(false);
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
            }
        });

        setVisible(true);
        setBounds(500, 300, 400, 400);
    }
}

class Main {
    public static void main(String[] args) {
        new MyWindow();
    }
}


