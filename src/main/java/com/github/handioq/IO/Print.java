package com.github.handioq.IO;

import java.util.ArrayList;

/*
 * Класс для отображения массивов.
 * @author Alexander Tereshkov
 */
public class Print {

    /*
     * Выводит элементы массива ArrayList<String> на консоль
     * @param list список элементов типа String
     */
    public static void toConsole(ArrayList<String> list)
    {
        for(int i = 0;i < list.size();i++) {
            System.out.println(list.get(i));
        }
    }

}
