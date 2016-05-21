package com.github.handioq.reports;


import com.github.handioq.models.StateList;
import com.github.handioq.models.TweetList;
import com.github.handioq.models.TweetSentimentsList;

import java.util.Date;

/**
 * Class keeps the data that serve as input parameters for the
 * reports.
 * @see TweetReport
 * @see SentimentReport
 * @see StateReport
 * @author Alexander Tereshkov
 * @version 1.0
 */
public class ReportParams {

    private TweetList tweetList;
    private StateList stateList;
    private TweetSentimentsList tweetSentimentsList;
    private Date startDate;
    private Date endDate;
    private String hashtag;

    /**
     * Initializes a newly created object of ReportParams with empty values.
     */
    public ReportParams() {
    }

    /**
     * Initializes a newly created object of ReportParams for TweetReport.
     * @param tweetList list of tweets
     * @param hashtag specific word for searching
     */
    public ReportParams(TweetList tweetList, String hashtag) {
        this.tweetList = tweetList;
        this.hashtag = hashtag;
    }

    /**
     * Initializes a newly created object of ReportParams for SentimentReport
     * @param tweetList list of tweets
     * @param tweetSentimentsList list with it sentiments and weights
     * @param startDate start date
     * @param endDate end date
     */
    public ReportParams(TweetList tweetList, TweetSentimentsList tweetSentimentsList, Date startDate, Date endDate) {
        this.tweetList = tweetList;
        this.tweetSentimentsList = tweetSentimentsList;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Initializes a newly created object of ReportParams for StateReport
     * @param stateList list of states
     * @param tweetList list of tweets
     * @param startDate start date
     * @param endDate end date
     */
    public ReportParams(StateList stateList, TweetList tweetList, Date startDate, Date endDate) {
        this.stateList = stateList;
        this.tweetList = tweetList;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Returns a tweetList object thar represent list of tweets.
     * @return TweetList list of tweets
     */
    public TweetList getTweetList() {
        return tweetList;
    }

    /**
     * Returns a stateList object that represent list of states.
     * @return StateList list of states
     */
    public StateList getStateList() {
        return stateList;
    }

    /**
     * Returns a tweetSentimentsList object thar represent list of sentiments.
     * @return TweetSentimentsList
     */
    public TweetSentimentsList getTweetSentimentsList() {
        return tweetSentimentsList;
    }

    /**
     * Returns a start date.
     * @return start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Returns a and date.
     * @return end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Returns a hashtag.
     * @return hashtag
     */
    public String getHashtag() {
        return hashtag;
    }
}
