package com.logsjuggler.core.logsStorageFormats;

import org.springframework.stereotype.Component;

@Component
public class FileLogsStorageFormat implements LogsStorageFormat {

    private String path;
    private static final LogsStorageFormatCode code = LogsStorageFormatCode.FileLogsStorage;

    @Override
    public void setLogsPath(String path) {
        this.path = path;
    }

    @Override
    public String getLogsPath() {
        return path;
    }

    @Override
    public LogsStorageFormatCode getCode() {
        return code;
    }
}
