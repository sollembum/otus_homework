package ru.otus.azat.quizing.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "quize")
@Component
public class QuizeConfig {
    private int acceptableLvl;

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    private String[] languages;

    public int getAcceptableLvl() {
        return acceptableLvl;
    }

    public void setAcceptableLvl(int acceptableLvl) {
        this.acceptableLvl = acceptableLvl;
    }
}