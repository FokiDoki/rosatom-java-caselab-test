package org.jfm.controllers;

import org.jfm.cli.CommandOptions;

public abstract class AbstractController implements IController{
    protected CommandOptions commandOptions;

    public AbstractController(CommandOptions commandOptions) {
        this.commandOptions = commandOptions;
    }
}
