package com.musyan.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/*@Component
@Data
public class GlobalProperties {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
}*/

@Component
@Data
@ConfigurationProperties(prefix = "app")
public class GlobalProperties {

    private List<Server> servers;

}
