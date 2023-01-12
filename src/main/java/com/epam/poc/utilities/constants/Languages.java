package com.epam.poc.utilities.constants;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public enum Languages {
    VIETNAMESE("Tiếng Việt"),
    ENGLISH("English");

    private String language;

    Languages(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public static List<String> getLanguageList() {
        List<String> expectedLanguageList = EnumSet.allOf(Languages.class).stream()
                .map(Languages::getLanguage)
                .collect(Collectors.toList());
        return expectedLanguageList;
    }
}
