package com.github.handioq.database;



import com.github.handioq.models.Tweet;
import com.github.handioq.models.TweetSentiment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryInsert {

    Connection connection;
    String query;

    //private final String INSERT_TWEET = "INSERT INTO all_tweets VALUES(?, ?, ?, ?, ?)";

    public QueryInsert()
    {

    }

    public QueryInsert(Connection connection)
    {
        this.connection = connection;
    }

    public QueryInsert(Connection connection, String query)
    {
        this.connection = connection;
        this.query = query;
    }

    public void insertTweet(Tweet tweet, int id)
    {
        PreparedStatement preparedStatement = null;

        try {
            java.sql.Date sqlDate = new java.sql.Date(tweet.getDateTime().getTime());

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setDouble(2, tweet.getCoordinates().getX());
            preparedStatement.setDouble(3, tweet.getCoordinates().getY());
            preparedStatement.setDate(4, sqlDate);
            preparedStatement.setString(5, tweet.getMessage());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSentiment(TweetSentiment tweetSentiment, int id)
    {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, tweetSentiment.getWord());
            preparedStatement.setDouble(3, tweetSentiment.getWeight());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

// https://www.youtube.com/watch?v=o5OdDWfSAWQ