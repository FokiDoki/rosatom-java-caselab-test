package org.jfm.controllers;

import org.jfm.cli.CommandOptions;

public class ControllerFactory {
    public static IController getController(CommandOptions commandOptions) {
        if (commandOptions.isHelp()) {
            return new HelpController();
        } else if (commandOptions.isVersion()){
            return new VersionController();
        } else if (commandOptions.isCreate()){
            return new CreateFileController(commandOptions);
        } else if (commandOptions.isDelete()){
            return new DeleteFileController(commandOptions);
        } else if (commandOptions.getContent() != null) {
            return new WriteToFileController(commandOptions);
        } else {
            return new HelpController();
        }
    }
}
