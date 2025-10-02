package com.DsaProject.LLD.LoggerLLD.Formatter;

import com.DsaProject.LLD.LoggerLLD.LogMessage;

public class LogFormatter implements ILogFormatter {
    public String formatLogMessage(LogMessage logMessage)
    {
        return logMessage.getTimeStamp() + ", " + logMessage.getMessage() + ": by  " + logMessage.getThreadName();
    }
}
