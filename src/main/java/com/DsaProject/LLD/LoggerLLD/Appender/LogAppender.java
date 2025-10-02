package com.DsaProject.LLD.LoggerLLD.Appender;

import com.DsaProject.LLD.LoggerLLD.LogMessage;

public interface LogAppender {

    void append(LogMessage logMessage);
}
