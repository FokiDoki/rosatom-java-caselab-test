package org.jfm.controllers;

import org.jfm.cli.CommandOptions;

import java.io.IOException;

public class ControllerRunner {
    public static void run(IController controller) {
        try {
            controller.process();
        } catch (IOException | RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void getAndRunController(CommandOptions options) {
        if (options == null) {
            return;
        }
        IController controller = ControllerFactory.getController(options);
        run(controller);
    }
}
