package ru.otus.azat.service;

public interface LocalizationService {
    String getCurrentLocalization();
    void setCurrentLocalization(String currentLocalization);
    String getLocalMessage(String messageCode);
}
