package com.github.handioq.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Класс для чтения массива строк
 * @author Alexander Tereshkov
 */
public class Reader {

    /*
     * Считывает строки из файла с начальной строки и по конечную,
     * возвращает массив типа String.
     * @param filename имя файла
     * @param begin номер первой строки, откуда начинать считывание
     * @param end номер последней строки, по какую строку считывать
     * @return массив ArrayList<String>
     */
    public static ArrayList<String> fromFile(String filename, int begin, int end)
    {
        int counter = 0;

        String line;
        ArrayList<String> lines = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while((line = reader.readLine()) != null) {
                counter++;
                if(counter > begin-1)
                {
                    lines.add(line);
                }

                if(counter == end)
                {
                    break;
                }
            }

        }
        catch (IOException e) {
            System.out.println("ERROR");
        }

        return lines;
    }

}
