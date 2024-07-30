package by.btd.ejtb.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectionDatabase {

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseUser;

    @Value("${spring.datasource.password}")
    private String databasePassword;
}
