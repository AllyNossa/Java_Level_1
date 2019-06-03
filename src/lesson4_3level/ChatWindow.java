package lesson4_3level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {
    JTextArea windowChat;
    JTextField textField;

    public ChatWindow() {
        setTitle("Окно чата");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel jPanel = new JPanel(new GridLayout(1, 2));

        textField = new JTextField();
        JButton buttonSend = new JButton("Отправить");

        jPanel.add(textField);
        jPanel.add(buttonSend);

        windowChat = new JTextArea();
        windowChat.setEditable(false);

        add(windowChat, BorderLayout.CENTER);

        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        add(jPanel, BorderLayout.SOUTH);

        setBounds(400, 400, 400, 400);
        setVisible(true);
    }

    private void sendMessage() {
        this.windowChat.append(this.textField.getText() + "\n");
        this.textField.setText("");
        this.textField.grabFocus();
    }
}

class Main {
    public static void main(String[] args) {
        new ChatWindow();
    }
}
