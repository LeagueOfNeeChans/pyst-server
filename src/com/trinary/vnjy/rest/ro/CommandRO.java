package com.trinary.vnjy.rest.ro;

import java.util.ArrayList;

public class CommandRO {
    protected String from = "";
    private String command = "";
    private ArrayList<String> args = new ArrayList<>();
    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public void setArgs(ArrayList<String> args) {
        this.args = args;
    }
}
