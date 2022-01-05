package ru.otus.azat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "path")
@Component
public class FileConfig {
    private String engFile;

    public String getRuFile() {
        return ruFile;
    }

    public void setRuFile(String ruFile) {
        this.ruFile = ruFile;
    }

    private String ruFile;

    public String getEngFile() {
        return engFile;
    }

    public void setEngFile(String engFile) {
        this.engFile = engFile;
    }
}
