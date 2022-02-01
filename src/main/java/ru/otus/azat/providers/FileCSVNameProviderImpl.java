package ru.otus.azat.providers;

import org.springframework.stereotype.Component;
import ru.otus.azat.holders.LocaleHolder;

@Component
public class FileCSVNameProviderImpl implements FileNameProvider{
    private final LocaleHolder localeHolder;

    public FileCSVNameProviderImpl(LocaleHolder localeHolder) {
        this.localeHolder = localeHolder;
    }

    @Override
    public String getFileName() {
        return "quize-" + localeHolder.getLocaleTag() + ".csv";
    }
}
