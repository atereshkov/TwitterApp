package com.github.handioq.models;

/*
 * Класс представляет собой слово с его эмоциональным весом.
 * @author Alexander Tereshkov
 */
public class TweetSentiment {

    private String word;
    private Double weight;

    /*
     * Создать слово с эмоциональным весом.
     * @param word слово
     * @param weight вес
     */
    public TweetSentiment(String word, Double weight)
    {
        this.word = word;
        this.weight = weight;
    }

    /*
     * Создает пустое слово с эмоциональным весом.
     */
    public TweetSentiment()
    {

    }

    /*
     * Возвращает строку со словом и эмоциональным весом.
     * @return String строка в формате word + weight
     */
    @Override
    public String toString() {
        return "models.TweetSentiment{" +
                "word='" + word + '\'' +
                ", weight=" + weight +
                '}';
    }

    /*
     * Возвращает эмоциональный вес слова.
     * @return вес weight в формате Double
     */
    public Double getWeight() {
        return weight;
    }

    public String getWord() {
        return word;
    }
}
