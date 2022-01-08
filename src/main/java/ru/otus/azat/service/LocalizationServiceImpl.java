package ru.otus.azat.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocalizationServiceImpl implements LocalizationService{
    private final MessageSource msg;
    private String currentLocalization;

    public LocalizationServiceImpl(MessageSource msg) {
        this.msg = msg;
    }

    public String getCurrentLocalization() {
        return currentLocalization;
    }

    public void setCurrentLocalization(String currentLocalization) {
        this.currentLocalization = currentLocalization;
    }

    @Override
    public String getLocalMessage(String messageCode) {
        return msg.getMessage(messageCode,null, Locale.forLanguageTag(currentLocalization));
    }
}
