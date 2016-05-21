package com.github.handioq.models;

/*
 * Класс для хранения точки в целочисленных координатах.
 * @author Alexander Tereshkov11
 */
public class IntegerPoint {

    private Integer x;
    private Integer y;

    /*
     * Создает точку с целочисленными координатами.
     * @param x первая координата
     * @param y вторая координата
     */
    public IntegerPoint(Integer x, Integer y)
    {
        this.x = x;
        this.y = y;
    }

    /*
     * Создание пустой точки.
     */
    public IntegerPoint()
    {

    }

    /*
     * Возвращает координату x
     * @return Integer точка X
     */
    public Integer getX()
    {
        return x;
    }

    /*
     * Возвращает координату y
     * @return Integer точка Y
     */
    public Integer getY()
    {
        return y;
    }

}
