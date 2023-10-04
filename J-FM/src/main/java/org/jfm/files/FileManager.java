package org.jfm.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {

    private static FileManager instance;

    private FileManager() {
    }

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public File createFile(String path) {
        return new File(path);
    }

    public File createFile(String path, Boolean override) throws IOException {
        File file = new File(path);
        if (file.exists() && !override) {
            throw new FileAlreadyExistsException(file);
        }
        file.delete();
        file.createNewFile();
        return file;
    }

    public void writeToFile(File file, String content) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)){
            fileOutputStream.write(content.getBytes());
        }
    }

    public void deleteFile(File file) {
        boolean isDeleted = file.delete();
        if (!isDeleted) {
            throw new FileNotExistsException(file);
        }

    }


}
