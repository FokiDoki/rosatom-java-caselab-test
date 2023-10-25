package org.caselab;

import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main {
    public static void main(String[] args) throws Exception {
        JettyServer server = new JettyServer();
        server.addServlet(FileServlet.class, "/file");
        server.addServlet(CarServlet.class, "/cars/*");
        server.start();
    }
}