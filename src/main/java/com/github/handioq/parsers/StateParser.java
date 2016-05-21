package com.github.handioq.parsers;

import com.github.handioq.models.State;
import com.github.handioq.models.StateList;
import com.github.handioq.models.TweetLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Класс для парсинга штатов.
 * @author Alexander Tereshkov
 */
public class StateParser implements IParser<State> {

    private ArrayList<String> strings;
    private ArrayList<State> states = new ArrayList<State>();

    /*
     * Создает объект типа StateParser для парсинга штатов.
     * @param strings массив строк для парсинга
     */
    public StateParser(ArrayList<String> strings)
    {
        this.strings = strings;
    }

    /*
     * Парсит список штатов из входной строки.
     * @param input строка для парсинга
     * @return StateList
     */
    @Override
    public StateList parse(String input)
    {
        StateList stateList = new StateList();

        String result = "";

        String regex = RegexPatterns.STATE_PARSE_PATTERN;
        Matcher matcher = Pattern.compile(regex).matcher(input);
        List<TweetLocation> tweetLocations = new ArrayList<TweetLocation>();

        while (matcher.find())
        {
            result = matcher.group();
            stateList.add(new State(TweetRegex.getStateName(result), TweetRegex.getStateLocationList(result)));
        }

        return stateList;
    }
}
