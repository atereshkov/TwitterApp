package com.github.handioq.parsers;


import com.github.handioq.Utils.Converter;
import com.github.handioq.Utils.StringUtils;
import com.github.handioq.models.TweetLocation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Класс содержит набор методов для получения различных данных
 * из строкового вида.
 * TweetLocation, StateLocationLost, Date, TweetMessage, StateName.
 * @author Alexander Tereshkov
 */
public class TweetRegex {

    /*
     * Парсит из строки TweetLocation.
     * @param input входная строка
     * @return TweetLocation
     */
    public static TweetLocation getTweetLocation(String input)
    {
        TweetLocation tweetLocation = new TweetLocation();
        String result = "";

        String regex = RegexPatterns.TWEET_LOCATION_PATTERN;
        Matcher matcher = Pattern.compile(regex).matcher(input);

        while (matcher.find())
        {
            result = matcher.group();
            tweetLocation = StringUtils.getCoordinatesFromString(result);
        }

        return tweetLocation;
    }

    /*
     * Парсит список TweetLocation из строки.
     * @param input входная строка
     * @return List<TweetLocation>
     */
    public static List<TweetLocation> getStateLocationList(String input)
    {
        List<TweetLocation> tweetLocationList = new ArrayList<TweetLocation>();
        TweetLocation tweetLocation = new TweetLocation();
        String result = "";

        String regex = RegexPatterns.TWEET_LOCATION_PATTERN;
        Matcher matcher = Pattern.compile(regex).matcher(input);

        while (matcher.find())
        {
            result = matcher.group();
            tweetLocation = StringUtils.getCoordinatesFromString(result);
            tweetLocationList.add(tweetLocation);
        }

        return tweetLocationList;
    }


    /*
     * Парсит дату из входной строки.
     * @param input строка
     * @return Date
     */
    public static Date getDate(String input)
    {
        Date date = new Date();
        String result = "";

        String regex = RegexPatterns.DATE_PATTERN;
        Matcher matcher = Pattern.compile(regex).matcher(input);

        while (matcher.find())
        {
            result = matcher.group();
            date = Converter.stringToDate(result);
        }

        return date;
    }

    /*
     * Парсит из строки с твитами сообщение
     * @param input входная строка
     * @return String сообщение
     */
    public static String getTweetMessage(String input)
    {
        String result = "";

        String regex = RegexPatterns.TWEET_MESSAGE_PATTERN;
        Matcher matcher = Pattern.compile(regex, Pattern.DOTALL).matcher(input);

        while (matcher.find())
        {
            result = matcher.group();
            result = result.replaceAll("\\d{2}:\\d{2}:\\d{2}\\s", "");
        }

        return result;
    }

    /*
     * Парсит название штата из строки.
     * @param input входная строка
     * @return String название штата.
     */
    public static String getStateName(String input)
    {
        String stateName = "";

        String regex = RegexPatterns.STATE_NAME_PATTERN;
        Matcher matcher = Pattern.compile(regex).matcher(input);

        while (matcher.find())
        {
            stateName = matcher.group();
        }

        return stateName;
    }

}
