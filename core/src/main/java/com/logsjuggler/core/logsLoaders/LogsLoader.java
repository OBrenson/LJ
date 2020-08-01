package com.logsjuggler.core.logsLoaders;

import com.logsjuggler.core.logsStorageFormats.LogsStorageFormat;

public interface LogsLoader {
    StringBuffer load(LogsStorageFormat logsStorageFormat);
}
