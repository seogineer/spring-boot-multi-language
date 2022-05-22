package com.seogineer.springbootmultilanguage.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Languages, Integer> {
    Languages findByMessageKeyAndLocale(String messageKey, String locale);
}
