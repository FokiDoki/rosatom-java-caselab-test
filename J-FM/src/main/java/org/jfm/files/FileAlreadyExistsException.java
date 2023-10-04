package org.jfm.files;

import java.io.File;

public class FileAlreadyExistsException extends RuntimeException{
    public FileAlreadyExistsException(File file) {
        super("ERROR: File " + file.getAbsolutePath() + " already exists!");
    }
}
