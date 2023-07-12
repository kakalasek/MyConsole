package org.example.commandWindow;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame(){
        /* Frame setup */
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        this.getContentPane().add(new Panel());
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
