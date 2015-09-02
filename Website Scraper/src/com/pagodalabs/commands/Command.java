package com.pagodalabs.commands;

import java.io.IOException;
import java.net.MalformedURLException;

public abstract class Command {

    public abstract void add() throws MalformedURLException, IOException;

}
