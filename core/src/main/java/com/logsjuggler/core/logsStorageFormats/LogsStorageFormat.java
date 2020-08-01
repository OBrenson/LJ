package com.logsjuggler.core.logsStorageFormats;

public interface LogsStorageFormat {
    void setLogsPath(String path);
    String getLogsPath();

    LogsStorageFormatCode getCode();
}
