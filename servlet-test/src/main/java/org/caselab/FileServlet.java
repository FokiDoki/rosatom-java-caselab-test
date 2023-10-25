package org.caselab;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;


public class FileServlet extends HttpServlet {
    FileRepository fileRepository = new FileRepository();
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {


        response.setStatus(HttpServletResponse.SC_CREATED);
        fileRepository.saveFile(String.valueOf(UUID.randomUUID()), request.getParts());
    }
}