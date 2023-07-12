package org.example.Utils;

import java.awt.*;

/**
 * Provides some useful methods for manipulating with string and fonts
 */
public class StringHandler {

    private FontMetrics fontMetrics;

    public StringHandler(FontMetrics fontMetrics){
        this.fontMetrics = fontMetrics;
    }

    /**
     * Calculates the height of font passed in the constructor
     * @return The height of the font
     */
    public int calculateFontHeight(){
        return fontMetrics.getHeight();
    }

    /**
     * Calculstes the width of a text according to the font passed in the constructor
     * @param text Text of which you want to know the width of
     * @return The width of the text passed
     */
    public int calculateTextWidth(String text){
        return fontMetrics.stringWidth(text);
    }

    /**
     * Removes last character of the passed string. If it sees an End of Medium at the end of the string, it will leave it intact!
     */
    public String removeLastChar(String str){
        String out = "";
        for(int i = 0; i < str.length(); i++){
            if(i == (str.length()-1) && str.charAt(i) != '\0') break;
            out = out.concat(String.valueOf(str.charAt(i)));
        }
        return out;
    }
}
