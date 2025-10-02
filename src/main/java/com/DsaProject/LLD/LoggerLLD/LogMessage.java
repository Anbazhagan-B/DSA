package com.DsaProject.LLD.LoggerLLD;

import java.time.LocalDate;
import java.util.Date;

public class LogMessage {
    LogLevel logLevel;
    String message;
    String timeStamp;
    String threadName;

    public LogMessage(LogLevel logLevel, String message){
        this.message = message;
        this.logLevel = logLevel;
        this.threadName = Thread.currentThread().getName();
    }

    @Override
    public String toString()
    {
        return "[" + this.logLevel+ "] " + timeStamp + " - " + message + ", executed by :- " + this.threadName;
    }

    public String getMessage(){return this.message ;}
    public String getTimeStamp(){return LocalDate.now().toString();}
    public String getThreadName(){return this.threadName ;}
}
