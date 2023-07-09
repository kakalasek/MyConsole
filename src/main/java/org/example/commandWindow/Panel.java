package org.example.commandWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Panel extends JPanel implements KeyListener {

    private final int panelHeight = 700; // Panel height
    private final int panelWidth = 1000; // Panel width

    private ArrayList<JLabel> IO_array; // Declaring the JLabel array for input and output of the terminal
    private final int fontHeight = this.getFontMetrics(getFont()).getHeight(); // Calculating height of letters

    public Panel(){
        /* Panel setup */
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.addKeyListener(this);

        this.setFocusable(true);
        this.requestFocusInWindow();

        setup_IO_array();
    }

    /**
     * Sets up the input and output text interface for the terminal
     */
    private void setup_IO_array(){
        /* IO_array initialization and helper variable 'y' creation */
        IO_array = new ArrayList<>();
        int y = 0;

        /*
           I want to fill the whole height of the panel with labels.
           So here I am checking, if the next label is or isn't out
           of the boundaries of the screen. If so, I add no more.
        */
        while((y + fontHeight) < panelHeight){
            IO_label_init(0, y, "SAMPLE TEXT");
            y += fontHeight;
        }
    }

    /**
     * Initializes each label of the text interface of the terminal
     * @param x Position on the X axis
     * @param y Position on the Y axis
     * @param text Initial text of the label
     */
    private void IO_label_init(int x, int y, String text){
        /* Label setup */
        JLabel label = new JLabel(text);
        label.setBounds(x, y, panelWidth, fontHeight);
        label.setForeground(Color.WHITE);

        /* Adding label to the panel and IO_array */
        this.add(label);
        IO_array.add(label);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
