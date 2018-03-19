package com.wdq.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.UUID;

public class InitialID implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        servletContext.setAttribute("uuid", uuid);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
