package ru.otus.azat.quizing.holders;

import org.springframework.stereotype.Component;
import ru.otus.azat.quizing.config.QuizeConfig;

import java.util.Arrays;
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
        int indexOfLocalizationCode =  Arrays.asList(languages).indexOf(localizationCode);
        if (indexOfLocalizationCode <0){
            setLocaleTag("en-US");
            setLocale(Locale.US);
            return;
        }
        if (languages[indexOfLocalizationCode].equals("en-US")){
            setLocale(Locale.US);
        } else {
            setLocale(Locale.forLanguageTag(languages[indexOfLocalizationCode]));
        }
    }
}
