package com.github.handioq.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Вспомогательный класс для конвертирования величин и данных.
 *
 * @author Alexander Tereshkov
 */
public class Converter {

    /*
     * Переводит входную строку в формате yyyy-dd-mm kk:mm:ss
     * в объект типа Date
     * @param input строка
     * @return Date
     */
    public static Date stringToDate(String input)
    {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-mm kk:mm:ss"); // format
        try
        {
            date = sdf.parse(input);
        }
        catch (Exception e)
        {

        }

        return date;
    }

}
