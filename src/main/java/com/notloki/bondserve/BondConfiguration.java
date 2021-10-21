package com.notloki.bondserve;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
public class BondConfiguration {

    public static final String appName = "${com.notloki.bondserve.";
    private static final Logger log = LoggerFactory.getLogger(BondConfiguration.class);

    @Value(appName + "test}")
    public String test;

    @Value(appName + "environment}")
    public String environment;

    @Value(appName + "username}")
    public String username;

    @Value(appName + "password}")
    public String password;

    BondConfiguration() {}

    public String getTest() {
        return test;
    }

    public void setTest(String test) { this.test = test;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
