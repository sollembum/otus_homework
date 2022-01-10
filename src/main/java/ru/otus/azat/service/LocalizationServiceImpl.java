package ru.otus.azat.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.azat.holders.LocaleHolder;

import java.util.Locale;

@Service
public class LocalizationServiceImpl implements LocalizationService{
    private final MessageSource msg;
    private final LocaleHolder localeHolder;

    public LocalizationServiceImpl(MessageSource msg, LocaleHolder localeHolder) {
        this.msg = msg;
        this.localeHolder = localeHolder;
    }

    @Override
    public String getLocalMessage(String messageCode) {
        return msg.getMessage(messageCode,null, localeHolder.getLocale());
    }
}
