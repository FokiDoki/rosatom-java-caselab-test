package org.jfm;

import org.jfm.cli.CommandOptions;
import org.jfm.cli.OptionsFactory;
import org.jfm.controllers.ControllerRunner;

public class Main {
    public static void main(String[] args) {
        CommandOptions options = OptionsFactory.getOptions(args);
        ControllerRunner.getAndRunController(options);
    }
}