package com.epam.lab.core.util;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class MyLogger {
    private static Logger rootLogger = LogManager.getLogger("");

    public static Logger getLogger() {
        return rootLogger;
    }

    public void setLevel(Level levelLogger) {
        rootLogger.setLevel(levelLogger);
    }
}
