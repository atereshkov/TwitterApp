package com.github.handioq.beans;

import com.github.handioq.models.Tweet;
import com.github.handioq.models.TweetLocation;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "tweetBean")
@SessionScoped
public class TweetBean {

    private static final String URL = "jdbc:mysql://hopper.beget.com:3306/j291069d_android?autoReconnect=true&useSSL=true";
    private static final String USERNAME = "j291069d_android";
    private static final String PASSWORD = "286Z24hgf2";

    final String GET_TWEET = "SELECT * FROM all_tweets";
    final String GET_WHERE_HASHTAG = "SELECT * FROM all_tweets WHERE message LIKE ";

    private String hashtag;

    private Connection connection;

    public List<Tweet> getTweets()
    {
        List<Tweet> list = new ArrayList<Tweet>();

        try {
            //Driver driver = new FabricMySQLDriver();
            //DriverManager.registerDriver(driver);

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(GET_TWEET);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next())
            {
                TweetLocation tweetLocation = new TweetLocation(result.getDouble("x"), result.getDouble("y"));
                list.add(new Tweet(tweetLocation, result.getString("message"), result.getDate("datetime")));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("Error");
        }

        return list;
    }

    public List<Tweet> getTweets2() throws ClassNotFoundException, SQLException {

        Connection connect = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection established"+connect);

        } catch (SQLException ex) {
            System.out.println("in exec");
            System.out.println(ex.getMessage());
        }

        List<Tweet> list = new ArrayList<Tweet>();

        PreparedStatement pstmt = connect.prepareStatement(GET_TWEET);
        ResultSet result = pstmt.executeQuery();

        while (result.next())
        {
            TweetLocation tweetLocation = new TweetLocation(result.getDouble("x"), result.getDouble("y"));
            list.add(new Tweet(tweetLocation, result.getString("message"), result.getDate("datetime")));
        }

        result.close();
        pstmt.close();
        connect.close();

        return list;
    }

    public List<Tweet> getTweetsWithHashtag()
    {
        List<Tweet> list = new ArrayList<Tweet>();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(GET_WHERE_HASHTAG + "'%" + hashtag + "%'");
            ResultSet result = preparedStatement.executeQuery();

            while(result.next())
            {
                TweetLocation tweetLocation = new TweetLocation(result.getDouble("x"), result.getDouble("y"));
                list.add(new Tweet(tweetLocation, result.getString("message"), result.getDate("datetime")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }
}
