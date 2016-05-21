package com.github.handioq.Utils;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

/*
 * Вспомогательный класс для работы с файлами.
 *
 * @author Alexander Tereshkov
 */
public class FileUtils {

    /*
     * Определяет количество строк в файле.
     * @param filename имя файла
     * @return Integer число строк в файле
     */
    public static Integer getNumberOfLines(String filename)
    {
        Integer count = 0;
        try
        {
            LineNumberReader lnr = new LineNumberReader(new FileReader(new File(filename)));
            lnr.skip(Long.MAX_VALUE);
            count = lnr.getLineNumber() + 1;
            lnr.close();
        }
        catch (Exception e) { }

        return count;

    }

}
