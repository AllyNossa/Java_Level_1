package lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    private JSlider slider;
    public SubWindow(MyWindow myWindow) {
        this.myWindow = myWindow;

        JPanel jPanel = new JPanel(new GridLayout(4, 1));

//        JTextField jTextField1 = new JTextField();
//        JTextField jTextField2 = new JTextField();
////        JTextField jTextField3 = new JTextField();
//
//        jPanel.add(jTextField1);
//        jPanel.add(jTextField2);
//        jPanel.add(jTextField3);



        JRadioButton jRadioButton1 = new JRadioButton("1");
        JRadioButton jRadioButton2 = new JRadioButton("2");

        jPanel.add(jRadioButton1);
        jPanel.add(jRadioButton2);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);

        slider = new JSlider(1, 6, 1);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentNumber = slider.getValue();
                JLabel label = new JLabel();
                label.setText("Выбрано " + currentNumber);

                jPanel.add(label);
                jPanel.add(slider);

            }
        });




        add(jPanel);


        setVisible(true);
        setBounds(500, 300, 400, 400);
    }
}

class Main {
    public static void main(String[] args) {
        new MyWindow();
    }
}


