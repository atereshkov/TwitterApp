package com.github.handioq.models;

import java.util.ArrayList;
import java.util.List;

/*
 * Класс представляет собой модель данных типа штат,
 * содержит имя штата и список координат, принадлежащих ему.
 * @author Alexander Tereshkov
 */
public class State {

    private String name;
    private List<TweetLocation> coordinates = new ArrayList<TweetLocation>();

    /*
     * Создает штат с именем и списком координат
     * @param name имя штата
     * @param coordinates массив кооридант типа TweetLocation
     */
    public State(String name, List<TweetLocation> coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
    }

    /*
     * Создание пустого штата.
     */
    public State()
    {

    }

    /*
     * Возвращает список координат штата.
     * @return List<TweetLocation> список координат TweetLocation для штата.
     */
    public List<TweetLocation> getCoordinates() {
        return coordinates;
    }

    /*
     * Вывод информации о штате (имя и координаты) на консоль.
     */
    public void output()
    {
        System.out.println("models.State: " + name);
        for(TweetLocation tweetLocation : coordinates)
        {
            System.out.println(tweetLocation.getX() + ", " + tweetLocation.getY());
        }
    }

    /*
     * Возвращает имя штата.
     * @return name имя штата.
     */
    public String getName() {
        return name;
    }
}
