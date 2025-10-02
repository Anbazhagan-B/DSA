package com.DsaProject.LLD.LoggerLLD;

import com.DsaProject.LLD.LoggerLLD.Appender.ConsoleAppender;
import com.DsaProject.LLD.LoggerLLD.Appender.LogAppender;
import com.DsaProject.LLD.LoggerLLD.Formatter.LogFormatter;

import java.util.*;

public class LogManager {
    static volatile Logger logger;

    public static Logger getLoggerInstance()
    {
        if(logger == null)
        {
            synchronized (LogManager.class)
            {
                if(logger == null)
                {
                    logger = new LogBuilder().setMinLevel(LogLevel.DEBUG).setAppenders(new ConsoleAppender(new LogFormatter())).build();
                }
            }
        }

        return logger;
    }

    static class LogBuilder
    {
        LogLevel minLevel;
        List<LogAppender> logAppender = new ArrayList<>();

        public LogBuilder setMinLevel(LogLevel logLevel)
        {
            this.minLevel = logLevel;
            return this;
        }

        public LogBuilder setAppenders(LogAppender logAppender)
        {
            this.logAppender.add(logAppender);
            return this;
        }

        public Logger build()
        {
            return new Logger(minLevel, logAppender);
        }
    }
}
