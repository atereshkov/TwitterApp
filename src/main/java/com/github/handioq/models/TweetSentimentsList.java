package com.github.handioq.models;

import java.util.ArrayList;
import java.util.List;

/*
 * Список слов с эмоциональым весом.
 * Добавление, вывод на консоль.
 * @author Alexander Tereshkov
 */
public class TweetSentimentsList {

    public List<TweetSentiment> TweetSentiments = new ArrayList<TweetSentiment>();

    /*
     * Создает пустой список слов с эмоциональным весом.
     */
    public TweetSentimentsList()
    {

    }

    /*
     * Создает список слов с эмоциональным весом по заданному списку List<TweetSentiment>
     * @param TweetSentiments
     */
    public TweetSentimentsList(List<TweetSentiment> TweetSentiments)
    {
        this.TweetSentiments = TweetSentiments;
    }

    /*
     * Выводит все значения из списка на консоль.
     */
    public void print()
    {
        for(TweetSentiment tw : TweetSentiments)
        {
            System.out.println(tw);
        }
    }

    /*
     * Добавить слово в список.
     * @param tweetSentiment
     */
    public void add(TweetSentiment tweetSentiment)
    {
        TweetSentiments.add(tweetSentiment);
    }

    /*
     * Возвращает список List<TweetSentiment>
     * @return
     */
    public List<TweetSentiment> getTweetSentiments() {
        return TweetSentiments;
    }
}
