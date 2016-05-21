package com.github.handioq.database;



import com.github.handioq.models.Tweet;
import com.github.handioq.models.TweetList;
import com.github.handioq.models.TweetLocation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryGet {

    Connection connection;
    String query;

    public QueryGet() {
    }

    public QueryGet(Connection connection, String query) {
        this.connection = connection;
        this.query = query;
    }

    public QueryGet(Connection connection) {
        this.connection = connection;
    }

    public TweetList getAllTweets()
    {
        TweetList tweetList = new TweetList();
        PreparedStatement preparedStatement = null;

        try {
            //java.sql.Date sqlDate = new java.sql.Date(tweet.getDateTime().getTime());

            preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next())
            {
                TweetLocation tweetLocation = new TweetLocation(result.getDouble("x"), result.getDouble("y"));
                tweetList.add(new Tweet(tweetLocation, result.getString("message"), result.getDate("datetime")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tweetList;
    }

}
