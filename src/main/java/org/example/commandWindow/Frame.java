package org.example.commandWindow;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        this.getContentPane().add(new Panel());
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
