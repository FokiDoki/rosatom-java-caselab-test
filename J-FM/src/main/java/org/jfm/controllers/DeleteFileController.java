package org.jfm.controllers;

import org.jfm.cli.CommandOptions;
import org.jfm.files.FileManager;

import java.io.File;

public class DeleteFileController extends AbstractController{
    FileManager fm = FileManager.getInstance();
    public DeleteFileController(CommandOptions commandOptions) {
        super(commandOptions);
    }

    @Override
    public void process() {
        File file = new File(commandOptions.getPath());
        fm.deleteFile(file);
    }
}
