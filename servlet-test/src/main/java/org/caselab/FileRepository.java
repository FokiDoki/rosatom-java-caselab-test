package org.caselab;

import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class FileRepository {

    public void saveFile(String fileName, Collection<Part> fileContent) throws IOException {
        for (Part part : fileContent) {
            part.write(fileName);
        }
    }
}
