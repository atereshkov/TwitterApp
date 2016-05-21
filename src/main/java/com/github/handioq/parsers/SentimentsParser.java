package com.github.handioq.parsers;


import com.github.handioq.Utils.StringUtils;
import com.github.handioq.models.TweetSentiment;
import com.github.handioq.models.TweetSentimentsList;

import java.util.ArrayList;

/*
 * Класс для парсинга значений эмоциональной окраски.
 *
 * @author Alexander Tereshkov
 */
public class SentimentsParser implements IParser<TweetSentiment> {

    private ArrayList<String> strings;
    private TweetSentimentsList tweetSentimentsList = new TweetSentimentsList();

    /*
     * Конструктор для создания парсера эмоциональной окраски
     * слово + вес.
     * @param strings список строк ArrayList
     */
    public SentimentsParser(ArrayList<String> strings)
    {
        this.strings = strings;
    }

    /*
     * Возвращает список, который содержит в себе объекты типа TweetSentiment
     * эмоциональная окраска: слово и вес.
     * @return список TweetSentiment
     */
    public TweetSentimentsList getList()
    {
        return tweetSentimentsList;
    }

    @Deprecated
    public void parse()
    {
        for (int i = 0; i < strings.size(); i++)
        {
            TweetSentiment tweetSentiment = StringUtils.getTweetSentimentFromString(strings.get(i));

            tweetSentimentsList.add(tweetSentiment);
        }
    }

    /*
     * Парсит TweetSentiment со строки.
     * @param input входная строка
     * @return TweetSentiment
     */
    @Override
    public TweetSentiment parse(String input) {
        TweetSentiment tweetSentiment = StringUtils.getTweetSentimentFromString(input);

        return tweetSentiment;
    }
}
