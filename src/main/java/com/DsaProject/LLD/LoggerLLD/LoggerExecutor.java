package com.DsaProject.LLD.LoggerLLD;

public class LoggerExecutor {



    public static void main(String[] args)
    {
        Logger logger = LogManager.getLoggerInstance();
        Runnable task =  ()->  logger.log(LogLevel.DEBUG, "Logger Created");
        Thread newThread = new Thread(task, "newThread");
        newThread.start();


        logger.log(LogLevel.DEBUG, "Logger Created");
        logger.log(LogLevel.INFO, "Logger Created 1");
        logger.log(LogLevel.ERROR, "Logger Created 2");
        logger.log(LogLevel.DEBUG, "Logger Created 3");
    }
}
