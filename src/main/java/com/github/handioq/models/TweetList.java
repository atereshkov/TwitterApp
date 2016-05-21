package com.github.handioq.models;

import java.util.ArrayList;
import java.util.List;

/*
 * Класс для хранения список твитов,
 * возможность добавления и вывода на консоль,
 * проверка содержит ли список определенный твит.
 * @author Alexander Tereshkov
 */
public class TweetList {

    public List<Tweet> Tweets = new ArrayList<Tweet>();

    /*
     * Создает список твитов.
     * @param Tweets список твитов List<Tweet>
     */
    public TweetList(List<Tweet> Tweets)
    {
        this.Tweets = Tweets;
    }

    /*
     * Создает пустой список твитов.
     */
    public TweetList()
    {

    }

    /*
     * Добавлеяет указанный твит в список.
     * @param tweet твит для добавления
     */
    public void add(Tweet tweet)
    {
        Tweets.add(tweet);
    }

    /*
     * Выводит все твиты из списка на консоль.
     */
    public void print()
    {
        for(Tweet tweet : Tweets)
        {
            tweet.output();
        }
    }

    /*
     * Возвращает список твитов в формате List<Tweet>
     * @return
     */
    public List<Tweet> getTweets() {
        return Tweets;
    }

    /*
     * Проверяет, находится ли указанный твит в списке.
     * @param tweet твит для проверки
     * @return true если в списке, false если твита нет в списке
     */
    public Boolean contains(Tweet tweet)
    {
        return Tweets.contains(tweet);
    }

}
