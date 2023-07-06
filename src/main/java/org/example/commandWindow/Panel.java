package org.example.commandWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener {

    JLabel testLabel;

    public Panel(){
        this.setPreferredSize(new Dimension(1000, 700));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.addKeyListener(this);

        this.setFocusable(true);
        this.requestFocusInWindow();

        testLabel = new JLabel("");
        testLabel.setBounds(0, -40, 1000, 100);
        testLabel.setForeground(Color.white);
        this.add(testLabel);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        testLabel.setText(testLabel.getText() + keyEvent.getKeyChar());

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
