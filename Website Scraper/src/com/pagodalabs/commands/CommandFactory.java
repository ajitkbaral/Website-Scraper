package com.pagodalabs.commands;

import java.util.HashMap;

public class CommandFactory {

    private static HashMap<String, Command> commands = initialize();
    
    public static HashMap<String, Command> initialize(){
        HashMap<String, Command> commands = new HashMap<String, Command>();
        commands.put("jobsNepal", new JobsNepal());
        commands.put("meroJob", new MeroJob());
        return commands;
    }
    
    public static Command getCommand(String key){
        
    return (Command) commands.get(key);
    }
    
}
