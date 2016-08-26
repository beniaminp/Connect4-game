package com.connect4.service;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class App {
	public static void main(String[] args) {

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
		context.setContextPath("/");

		Server jettyServer = new Server(9999);
		jettyServer.setHandler(context);

		ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);

		// Tells the Jersey Servlet which REST service/class to load.
		jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "com.connect4.service");

		try {
			jettyServer.start();
			jettyServer.join();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jettyServer.destroy();
		}
	}
}
