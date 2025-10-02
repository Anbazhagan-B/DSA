package com.DsaProject.LLD.LoggerLLD;

public enum LogLevel {
    INFO, DEBUG, ERROR;

    public boolean isServerAs(LogLevel other) { return this.ordinal() >= other.ordinal() ; }
}
