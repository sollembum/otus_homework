package ru.otus.azat.holders;

import org.springframework.stereotype.Component;
import ru.otus.azat.config.QuizeConfig;

import java.util.Locale;

@Component
public class LocaleHolderImpl implements LocaleHolder {
    private final String[] languages;
    private Locale locale;
    private String localeTag;

    public LocaleHolderImpl(QuizeConfig config) {
        this.languages = config.getLanguages();
    }
    @Override
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    @Override
    public String getLocaleTag() {
        return localeTag;
    }

    public void setLocaleTag(String localeTag) {
        this.localeTag = localeTag;
    }

    @Override
    public void changeLocalization(String localizationCode) {
        setLocaleTag(localizationCode);
        if (localizationCode.equals(languages[0])){
            setLocale(Locale.forLanguageTag(languages[0]));
        }
        if (localizationCode.equals(languages[1])){
            setLocale(Locale.US);
        }
    }
}
