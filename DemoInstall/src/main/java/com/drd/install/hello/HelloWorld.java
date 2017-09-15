package com.drd.install.hello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author darrenp - 2017-09-14.
 */
public class HelloWorld extends JFrame {

    public HelloWorld() {
        initUI();
    }

    private void initUI() {

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(null);

        JButton quitButton = new JButton("Hello World");
        quitButton.setBounds(50, 60, 120, 30);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        panel.add(quitButton);

        setTitle("Hello World");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloWorld ex = new HelloWorld();
                ex.setVisible(true);
            }
        });
    }
}
