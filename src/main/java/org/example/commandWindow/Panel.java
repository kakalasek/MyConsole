package org.example.commandWindow;

import org.example.Utils.StringHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Panel extends JPanel implements KeyListener {

    private StringHandler strHandler = new StringHandler(this.getFontMetrics(this.getFont())); // Class for easier manipulation with strings inside the labels

    private final int panelHeight = 700; // Panel height
    private final int panelWidth = 1000; // Panel width

    private ArrayList<JLabel> IO_array; // Declaring the JLabel array for input and output of the terminal. Its size also represents the number of lines on the screen (INCLUDING LINE 0!)
    private final int fontHeight = strHandler.calculateFontHeight(); // Calculating height of letters

    private static int currentLine = 0;

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
            IO_label_init(0, y, "");
            y += fontHeight;
        }

        /* Initial prompt */
        prompt("User@This_Computer~: \0");
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

    private JLabel getCurrentLine(){
        return IO_array.get(currentLine);
    }

    /**
     * Checks if the user hasn't used up the full space of the console IO. If so, invokes scroll
     */
    private void checkForOverflow(){
        if(currentLine >= IO_array.size()){
            currentLine = IO_array.size()-1; // Setting current line to the last line of the screen
            scroll();
        }
    }

    /**
     * Scrolls down by a line
     */
    private void scroll(){
        for(int i = 0; i < IO_array.size(); i++){
            /* Clears the last line and breaks from for loop */
            if(i == (IO_array.size()-1)){ IO_array.get(i).setText(""); break;}

            IO_array.get(i).setText(IO_array.get(i+1).getText());
        }
    }

    private void prompt(String prompt){
        getCurrentLine().setText(prompt);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent){
        /* Checking if end of the line wasn't reached. If so, incrementing currentLine */
        if(strHandler.calculateTextWidth(getCurrentLine().getText()) > (getCurrentLine().getWidth() - 150)){
            currentLine++;
            checkForOverflow(); // Checking for overflow
        }

        /* Deciding what to type based on keyboard input */
        switch (keyEvent.getKeyChar()){
            case 10: currentLine++;
                     checkForOverflow(); // Checking for overflow
                     prompt("User@This_Computer~: \0");
                break;
            case 8: if(getCurrentLine().getText() == "") currentLine--;
                    getCurrentLine().setText(strHandler.removeLastChar(getCurrentLine().getText()));
                break;
            default: getCurrentLine().setText(getCurrentLine().getText() + keyEvent.getKeyChar());
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
