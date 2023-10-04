package org.jfm.files;

import java.io.File;

public class FileNotExistsException extends RuntimeException{
    public FileNotExistsException(File file) {
        super("ERROR: File " + file.getAbsolutePath() + " does not exist!");
    }
}
