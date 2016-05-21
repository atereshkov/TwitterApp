package com.github.handioq.parsers;

/*
 * Параметризованный интерфейс для парсеров.
 *
 * @param <T>
 *
 * @author Alexander Tereshkov
 */

public interface IParser<T> {

    /*
     * Метод для парсинга значений со строки.
     * @param input входная строка для парсинга
     * @param <T> тип возвращаемого значения
     * @return результат работы парсинга
     */
    public <T> T parse(String input);

}
