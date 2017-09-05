package com.trinary.vnjy.rest.ro;

import java.util.ArrayList;
import java.util.List;

public class CommandRO {
    protected String from = "";
    private String command = "";
    private List<String> args = new ArrayList<>();
    
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

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }
}
