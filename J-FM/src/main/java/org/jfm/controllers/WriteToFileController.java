package org.jfm.controllers;

import org.jfm.cli.CommandOptions;
import org.jfm.files.FileManager;
import org.jfm.files.FileNotExistsException;

import java.io.File;
import java.io.IOException;

public class WriteToFileController extends AbstractController{

    private final FileManager fm = FileManager.getInstance();

    private File file;
    public WriteToFileController(CommandOptions commandOptions) {
        super(commandOptions);
    }

    @Override
    public void process() throws IOException {
        if (file == null) {
            file = new File(commandOptions.getPath());
        }

        if (!file.exists()) {
            throw new FileNotExistsException(file);
        }
        fm.writeToFile(file, commandOptions.getContent());
    }

    public void setFile(File file) {
        this.file = file;
    }
}
