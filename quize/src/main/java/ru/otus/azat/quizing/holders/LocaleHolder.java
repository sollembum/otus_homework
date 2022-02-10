package ru.otus.azat.quizing.holders;

import java.util.Locale;

public interface LocaleHolder {
    void changeLocalization(String localizationCode);
    Locale getLocale();
    String getLocaleTag();
}
