package org.caselab;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.MultipartConfigElement;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;

public class JettyServer {
    private Server server;
    private final int port = 8080;
    ServletContextHandler handler = new ServletContextHandler();
    public void start() throws Exception {
        server = new Server();
        try (ServerConnector connector = new ServerConnector(server)){
            connector.setPort(port);
            server.setConnectors(new Connector[]{connector});
        }
        server.setHandler(handler);
        server.start();
    }

    public void join() throws InterruptedException {
        server.join();
    }

    public void stop() throws Exception {
        server.stop();
    }

    public void addServlet(Class<? extends Servlet> servletClass, String pathSpec) {
        handler.addServlet(servletClass, pathSpec).getRegistration().setMultipartConfig(
                new MultipartConfigElement("/home/fokidoki/projects/servlet-test/src/main/resources")
        );
    }

}