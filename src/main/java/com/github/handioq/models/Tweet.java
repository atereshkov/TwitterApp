package com.github.handioq.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Класс представляет собой сущность типа твит,
 * который содержит в себе координаты твита, дату и текст твита.
 * @author Alexander Tereshkov
 */
public class Tweet {

    private TweetLocation coordinates;
    private Date dateTime;
    private String message;

    /*
     * Создает твит с указанными параметрами: координаты, сообщение, дата.
     * @param coordinates координаты твита в формате TweetLocation
     * @param message текст твита
     * @param dateTime дата сообщения
     */
    public Tweet(TweetLocation coordinates, String message, Date dateTime)
    {
        this.coordinates = coordinates;
        this.message = message;
        this.dateTime = dateTime;
    }

    /*
     * Возвращает дату твита.
     * @return дата твита
     */
    public Date getDateTime() {
        return dateTime;
    }

    /*
     * Вывод информации о твите (координаты, дата, сообщение) на консоль.
     */
    public void output()
    {
        //DecimalFormat df = new DecimalFormat("#.########");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-mm kk:mm:ss"); // format

        //System.out.println(df.format(coordinates.getX()));

        System.out.println(coordinates.getX() + " | " + coordinates.getY() + " | " + sdf.format(dateTime) + " | " + message);
    }

    /*
     * Возвращает сообщение твита.
     * @return сообщение твита.
     */
    public String getMessage()
    {
        return message;
    }

    /*
     * Возвращает координаты TweetLocation твита.
     * @return
     */
    public TweetLocation getCoordinates() {
        return coordinates;
    }
}
