package com.github.handioq.models;

/*
 * Класс для хранения точки с координатами x и y.
 * @author Alexander Tereshkov
 */
public class TweetLocation {

    private double x;
    private double y;

    /*
     * Создает точку TweetLocation с заданными координатами x и y.
     * @param x первая координата в формате double
     * @param y вторая координата в формате double
     */
    public TweetLocation(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /*
     * Создает пустую точку TweetLocation.
     */
    public TweetLocation()
    {

    }

    /*
     * Возвращает координату X.
     * @return координата X в формате double
     */
    public double getX()
    {
        return x;
    }

    /*
     * Возвращает координату Y
     * @return координата Y в формате double
     */
    public double getY()
    {
        return y;
    }

}
