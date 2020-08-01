import com.logsjuggler.core.LogsManager;
import com.logsjuggler.core.logsStorageFormats.LogsStorageFormatCode;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
public class TestCore {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        LogsManager logsManager = (LogsManager) context.getBean(LogsManager.NAME);
        String path = "/home/boi/Progs/LogsJuggler/core/src/test/resources/testLogs.txt";
        System.out.println(logsManager.getLogs(LogsStorageFormatCode.FileLogsStorage, path));
    }
}
