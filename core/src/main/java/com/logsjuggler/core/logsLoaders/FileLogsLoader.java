package com.logsjuggler.core.logsLoaders;

import com.logsjuggler.core.logsStorageFormats.LogsStorageFormat;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

@Component
public class FileLogsLoader implements LogsLoader {

    private static int BUFFER_SIZE = 8126;

    @Override
    public StringBuffer load(LogsStorageFormat logsStorageFormat) {
        StringBuffer result = new StringBuffer();
        try(FileReader fileReader = new FileReader(logsStorageFormat.getLogsPath())) {
            CharBuffer buffer = CharBuffer.allocate(BUFFER_SIZE);
            while (fileReader.read(buffer) > 0) {
                buffer.flip();
                result.append(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
