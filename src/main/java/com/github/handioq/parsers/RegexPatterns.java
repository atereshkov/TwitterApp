package com.github.handioq.parsers;

/*
 * Класс хранит константные значения шаблонов регулярных выражений,
 * которые используются для парсинга.
 * @author Alexander Tereshkov
 */
public class RegexPatterns {

    public final static String STATE_PARSE_PATTERN = "\"[A-Z]{2}\":[0-9\\.\\[\\],\\s\\-]*";
    public final static String TWEET_LOCATION_PATTERN = "\\[(.*?)\\,(.*?)\\]";
    public final static String DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}?";
    public final static String TWEET_MESSAGE_PATTERN = "(?m)\\d{2}:\\d{2}:\\d{2}\\s(.*?)$";
    public final static String STATE_NAME_PATTERN = "[A-Z]{2}";

}
