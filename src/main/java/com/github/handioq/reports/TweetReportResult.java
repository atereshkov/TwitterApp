package com.github.handioq.reports;


import com.github.handioq.models.Tweet;
import com.github.handioq.models.TweetList;

/**
 * Class is a result of the Tweet Report,
 * keeps a list of tweets with a specific hashtag.
 * @author Alexander Tereshkov
 * @version 1.0
 * @see TweetList
 */
public class TweetReportResult {

    TweetList tweetsWithHashtag;

    /**
     * Initializes a newly created object of TweetReportResult with tweetList.
     * @see TweetList
     * @param tweetsWithHashtag list of tweets with specific hashtag
     */
    public TweetReportResult(TweetList tweetsWithHashtag) {
        this.tweetsWithHashtag = tweetsWithHashtag;
    }

    /**
     * Initializes a newly created object of TweetReportResult with empty data.
     */
    public TweetReportResult() {
    }

    /**
     * Print list of tweets to Console, that contains a specific hashtag.
     */
    public void print()
    {
        for(Tweet tweet : tweetsWithHashtag.getTweets())
        {
            tweet.output();
        }
    }
}
