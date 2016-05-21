package com.github.handioq.database;


import com.github.handioq.models.TweetList;
import com.github.handioq.models.TweetSentimentsList;

public class DBWorker {

    final String INSERT_TWEET = "INSERT INTO all_tweets VALUES(?, ?, ?, ?, ?)";
    final String INSERT_SENTIMENT = "INSERT INTO sentiments VALUES(?, ?, ?)";

    final String GET_TWEET = "SELECT * FROM all_tweets";
    final String GET_WHERE_HASHTAG = "SELECT * FROM all_tweets WHERE message LIKE ";

    public DBWorker()
    {

    }

    public void insertTweets(DBConnection dbConnection, TweetList tweetList)
    {
        QueryInsert queryExecution = new QueryInsert(dbConnection.getConnection(), INSERT_TWEET);

        for (int i = 0; i < tweetList.getTweets().size(); i++)
        {
            queryExecution.insertTweet(tweetList.getTweets().get(i), i+1);
        }
    }

    public void insertSentiments(DBConnection dbConnection, TweetSentimentsList tweetSentimentsList)
    {
        QueryInsert queryExecution = new QueryInsert(dbConnection.getConnection(), INSERT_SENTIMENT);

        //for (int i = 0; i < tweetSentimentsList.getTweetSentiments().size(); i++)
        for (int i = 0; i < 10; i++)
        {
            queryExecution.insertSentiment(tweetSentimentsList.getTweetSentiments().get(i), i+1);
        }
    }

    public TweetList getAllTweets(DBConnection dbConnection)
    {
        QueryGet queryGet = new QueryGet(dbConnection.getConnection(), GET_TWEET);

        return queryGet.getAllTweets();
    }

    public TweetList getTweetsWithHashtag(DBConnection dbConnection, String hashtag)
    {
        QueryGet queryGet = new QueryGet(dbConnection.getConnection(), GET_WHERE_HASHTAG + hashtag);

        return queryGet.getAllTweets();
    }

}
