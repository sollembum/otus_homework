package ru.otus.azat.holders;

import java.util.Locale;

public interface LocaleHolder {
    void changeLocalization(String localizationCode);
    Locale getLocale();
    String getLocaleTag();
}
