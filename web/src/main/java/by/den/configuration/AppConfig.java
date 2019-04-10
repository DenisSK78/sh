package by.den.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value= { "by.den" })
@PropertySource(value = {
        "classpath:database.properties",
        "classpath:files.properties"
})
@Import(value = {
        HibernateConfiguration.class,
        WebConfig.class
})

public class AppConfig {
}


