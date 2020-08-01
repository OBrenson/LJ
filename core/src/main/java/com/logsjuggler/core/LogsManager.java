package com.logsjuggler.core;

import com.logsjuggler.core.logsStorageFormats.LogsStorageFormatCode;

public interface LogsManager {
    public final static  String NAME = "logsManager";
    StringBuffer getLogs(LogsStorageFormatCode storageFormatCode, String path);
}
