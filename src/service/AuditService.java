package service;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class AuditService {
    private static AuditService instance;

    private URL urlLogFile = getClass().getClassLoader().getResource("log.csv");
    private Path PATH_LOG_FILE = null;

    public static AuditService getInstance(){
        if(instance == null){
            instance = new AuditService();
            try {
                instance.PATH_LOG_FILE = Paths.get(instance.urlLogFile.toURI());

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return instance;
    }
    private AuditService(){

    }

    public void logMessage(String... mesaje){
        System.out.println("Logging message");
        String result = String.join(",", mesaje);
        result += "\n";
        try {
            Files.write(PATH_LOG_FILE, result.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
