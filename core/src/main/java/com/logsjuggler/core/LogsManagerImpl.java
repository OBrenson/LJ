package com.logsjuggler.core;
import com.logsjuggler.core.logsLoaders.LogsLoader;
import com.logsjuggler.core.logsStorageFormats.LogsStorageFormat;
import com.logsjuggler.core.logsStorageFormats.LogsStorageFormatCode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogsManagerImpl implements LogsManager {
    @Autowired
    private List<LogsStorageFormat> logsStorageFormats;

    @Autowired
    private LogsLoader logsLoader;

    @Override
    public StringBuffer getLogs(LogsStorageFormatCode storageFormatCode, String path) {
        LogsStorageFormat logsStorageFormat = createLogsStorageFormat(storageFormatCode, path);
        StringBuffer logs = logsLoader.load(logsStorageFormat);
        //TODO: need to parse????
        return logs;
    }

    private LogsStorageFormat createLogsStorageFormat(LogsStorageFormatCode storageFormatCode, String path){
        Map<LogsStorageFormatCode, LogsStorageFormat> map = logsStorageFormats.stream()
                .collect(Collectors.toMap(p -> p.getCode(), p -> p));

        LogsStorageFormat storageFormat = map.get(storageFormatCode);
        storageFormat.setLogsPath(path);
        return storageFormat;
    }
}
