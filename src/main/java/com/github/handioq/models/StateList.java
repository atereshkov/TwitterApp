package com.github.handioq.models;

import java.util.ArrayList;
import java.util.List;

/*
 * Класс представляет собой список штатов типа State.
 * Добавление штата в список, вывод на консоль, получение штата по имени.
 * @author Alexander Tereshkov
 */
public class StateList {

    private List<State> states = new ArrayList<State>();

    /*
     * Создает список штатов.
     * @param states список штатов.
     */
    public StateList(List<State> states)
    {
        this.states = states;
    }

    /*
     * Пустой список штатов.
     */
    public StateList()
    {

    }

    /*
     * Возвращает список штатов.
     * @return список штатов.
     */
    public List<State> getStates() {
        return states;
    }

    /*
     * Добавляет штат в список штатов.
     * @param state штат
     */
    public void add(State state)
    {
        states.add(state);
    }

    /*
     * Вывод списка штатов на консоль.
     */
    public void print()
    {
        for(State state : states)
        {
            state.output();
        }
    }

    /*
     * Возвращает штат, который соответствует по имени name
     * @param name имя штата
     * @return State
     */
    public State getStateByName(String name)
    {
        for(State state : states)
        {
            if (state.getName().equals(name))
                return state;
        }

        return null;
    }

}
