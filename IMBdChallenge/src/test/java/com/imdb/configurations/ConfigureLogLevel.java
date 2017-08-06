package com.imdb.configurations;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

/**
 * Author: Dhruv Vinayak
 *
 * This class is used to enable/set log level for desired web driver
 * 
 */

public class ConfigureLogLevel {

    public static LoggingPreferences setLoggingPreferences(Level level) {
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.DRIVER, level);
        return loggingPreferences;
    }

}
