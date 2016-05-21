package com.github.handioq.Utils;


import com.github.handioq.models.TweetLocation;
import com.github.handioq.models.TweetSentiment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Вспомогательный класс для работы со строками.
 *
 * @author Alexander Tereshkov
 */
public class StringUtils {

    private final static String DATE_FORMAT = "yyyy-dd-mm kk:mm:ss";
    private final static String WORD_SEPARATORS = "(\\?|\\.|\\,|\\!|\\s+)";

    /*
     * Парсит координаты типа TweetLocation со строки.
     * @param input входная строка
     * @return TweetLocation
     */
    public static TweetLocation getCoordinatesFromString(String input)
    {
        TweetLocation tweetLocation = new TweetLocation();

        try
        {
            String[] result = input.split("\\,");

            String first = result[0].replaceAll("\\[", "");
            String second = result[1].replaceAll("\\s","").replaceAll("\\]", "");
            double x = 0;
            double y = 0;

            if (result.length != 0)
            {
                x = Double.parseDouble(first);
                y = Double.parseDouble(second);
            }
            tweetLocation = new TweetLocation(x, y);
        } catch (Exception e)
        {

        }

        return tweetLocation;
    }

    /*
     * Парсит TweetSentiment со строки.
     * @param input входная строка
     * @return TweetSentiment
     */
    public static TweetSentiment getTweetSentimentFromString(String input)
    {
        String[] result = input.split("\\,");
        if (result.length != 2)
            throw new IllegalArgumentException("String not in correct format");

        String word = result[0];
        Double weight = Double.parseDouble(result[1]);

        TweetSentiment tweetSentiment = new TweetSentiment(word, weight);

        return tweetSentiment;
    }

    /*
     * Возвращает все слова строки в массиве String[],
     * которые подходят под правило (\?|\.|\,|\!|\s+)
     * @param input входная строка
     * @return String[] массив слов
     */
    public static String[] getWordsFromString(String input)
    {
        String[] out = null;
        if (input != null)
        {
            out = input.split(WORD_SEPARATORS);
        }

        return out;
    }

    public static Date getDateFromString(String input)
    {
        Date outDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try
        {
            outDate = sdf.parse(input);

        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        return outDate;
    }

}
