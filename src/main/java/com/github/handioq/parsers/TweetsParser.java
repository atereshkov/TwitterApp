package com.github.handioq.parsers;


import com.github.handioq.models.Tweet;
import com.github.handioq.models.TweetList;
import com.github.handioq.models.TweetLocation;

import java.util.ArrayList;
import java.util.Date;

/*
 * Класс отвечающий за парсинг твитов.
 * @author Alexander Tereshkov
 */
public class TweetsParser implements IParser<Tweet> {

    private ArrayList<String> strings;
    private TweetList tweets = new TweetList();

    /*
     * Создание парсера твитов со списком входных строк для
     * парсинга.
     * @param strings
     */
    public TweetsParser(ArrayList<String> strings)
    {
        this.strings = strings;
    }

    public TweetList getList()
    {
        return tweets;
    }

    /*
     * Возвращает объект типа Tweet из входной строки.
     * @param input входная строка
     * @return Tweet
     */
    @Override
    public Tweet parse(String input)
    {
        TweetLocation tweetLocation = TweetRegex.getTweetLocation(input);
        Date date = TweetRegex.getDate(input);
        String message = TweetRegex.getTweetMessage(input);

        return (new Tweet(tweetLocation, message, date));
    }



}
