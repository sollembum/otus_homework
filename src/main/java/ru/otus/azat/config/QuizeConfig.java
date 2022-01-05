package ru.otus.azat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "quize")
@Component
public class QuizeConfig {
    private int acceptableLvl;

    public int getAcceptableLvl() {
        return acceptableLvl;
    }

    public void setAcceptableLvl(int acceptableLvl) {
        this.acceptableLvl = acceptableLvl;
    }
}
