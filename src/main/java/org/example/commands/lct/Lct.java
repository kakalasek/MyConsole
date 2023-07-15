package org.example.commands.lct;

import org.example.commands.Command;

import java.time.LocalDateTime;

public class Lct implements Command {

    @Override
    public String execute(String[] parameters) {
        return String.valueOf(LocalDateTime.now());
    }
}
