package com.DsaProject.LLD.LoggerLLD.Appender;

import com.DsaProject.LLD.LoggerLLD.Formatter.LogFormatter;
import com.DsaProject.LLD.LoggerLLD.LogMessage;

public class ConsoleAppender implements LogAppender {
    String logMessage;
    LogFormatter logFormatter;
    public ConsoleAppender(LogFormatter logFormatter)
    {
        this.logFormatter = logFormatter;
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logFormatter.formatLogMessage(logMessage));
    }
}
