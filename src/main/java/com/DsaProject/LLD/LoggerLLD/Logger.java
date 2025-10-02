package com.DsaProject.LLD.LoggerLLD;

import com.DsaProject.LLD.LoggerLLD.Appender.LogAppender;

import java.util.*;
import java.util.concurrent.ExecutorService;

public class Logger {
    LogLevel minLevel;
    List<LogAppender> logAppender;
    ExecutorService executorService;

    public Logger(LogLevel logLevel, List<LogAppender> appenders)
    {
        this.minLevel = logLevel;
        this.logAppender = appenders;
    }

    public void setMinLevel(LogLevel logLevel) {
        this.minLevel = logLevel;
    }

    public void shutdown()
    {
        this.executorService.shutdown();
    }

    public void log(LogLevel logLevel, String msg)
    {
        if(!this.minLevel.isServerAs(logLevel)) return;
        LogMessage logMessage = new LogMessage(logLevel, msg);
        logAppender.forEach(logAppender1 -> logAppender1.append(logMessage));
    }

    public void debug(String msg)
    {
        log(LogLevel.DEBUG, msg);
    }

    public void error(String msg)
    {
        log(LogLevel.ERROR, msg);
    }

    public void info(String msg)
    {
        log(LogLevel.INFO, msg);
    }
}
