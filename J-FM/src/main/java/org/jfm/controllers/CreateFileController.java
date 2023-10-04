package org.jfm.controllers;

import org.jfm.cli.CommandOptions;
import org.jfm.files.FileManager;

import java.io.File;
import java.io.IOException;

public class CreateFileController extends AbstractController {
    FileManager fm = FileManager.getInstance();
    WriteToFileController writeToFileController = new WriteToFileController(commandOptions);
    public CreateFileController(CommandOptions commandOptions) {
        super(commandOptions);
    }

    @Override
    public void process() throws IOException {
        System.out.printf("Creating file %s%n", commandOptions.getPath());
            File file = fm.createFile(commandOptions.getPath(), commandOptions.isOverride());
            if (commandOptions.getContent() != null) {
                writeToFileController.setFile(file);
                writeToFileController.process();
            }
    }
}
