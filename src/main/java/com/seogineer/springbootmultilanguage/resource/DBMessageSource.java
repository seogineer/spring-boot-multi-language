package com.seogineer.springbootmultilanguage.resource;

import com.seogineer.springbootmultilanguage.domain.LanguageRepository;
import com.seogineer.springbootmultilanguage.domain.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {
    @Autowired
    private LanguageRepository languageRepository;

    private static final String DEFAULT_LOCALE_CODE = "en";

    @Override
    protected MessageFormat resolveCode(String key, Locale locale) {
        Languages message = languageRepository.findByMessageKeyAndLocale(key, locale.getLanguage());
        if (message == null) {
            message = languageRepository.findByMessageKeyAndLocale(key, DEFAULT_LOCALE_CODE);
        }
        return new MessageFormat(message.getMessageContent(), locale);
    }
}
