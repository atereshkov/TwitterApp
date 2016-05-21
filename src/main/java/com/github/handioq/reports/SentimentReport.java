package com.github.handioq.reports;


import com.github.handioq.Utils.StringUtils;
import com.github.handioq.models.Tweet;
import com.github.handioq.models.TweetList;
import com.github.handioq.models.TweetSentiment;
import com.github.handioq.models.TweetSentimentsList;

import java.util.Date;

/**
 * Class to make a report for the emotional
 * coloring of tweets at a given period of time.
 *
 * @version 1.0
 * @author Alexander Tereshkov
 */
public class SentimentReport implements IReport<Double> {

    private TweetList tweetList = new TweetList();
    private TweetSentimentsList tweetSentimentsList = new TweetSentimentsList();
    private Date startDate;
    private Date endDate;

    /**
     * Initializes a newly created object of SentimentReport for make a report.
     * @param tweetList list of tweets
     * @param tweetSentimentsList list of sentiments with its words and weights
     * @param startDate start date
     * @param endDate end date
     */
    public SentimentReport(TweetList tweetList, TweetSentimentsList tweetSentimentsList, Date startDate, Date endDate) {
        this.tweetList = tweetList;
        this.tweetSentimentsList = tweetSentimentsList;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Initializes a newly created object of SentimentReport with empty date.
     */
    public SentimentReport() {
    }

    /**
     * Returns a report SentimentReportResult,
     * which contains the value of emotional color of tweets
     * in a specific period of time.
     * @param params input parameters of type ReportParams
     * @return SentimentReportResult
     * @see SentimentReportResult
     * @see ReportParams
     */
    @Override
    public SentimentReportResult getReport(ReportParams params)
    {
        Double summaryWeight = 0.0;

        for (Tweet tweet : params.getTweetList().getTweets())
        {
            if(tweet.getDateTime().after(params.getStartDate()) && tweet.getDateTime().before(params.getEndDate()))
            {
                summaryWeight += getEmotionalWeightOfTweet(tweet, params);
            }
        }

        return new SentimentReportResult(summaryWeight);
    }

    /**
     * Specifies the emotional weight of the tweet with the rules.
     * @param tweet an object of type tweet
     * @param params report parameters with type of ReportParams
     * @return double value of emotion coloring for tweet
     * @see ReportParams
     * @see StringUtils
     */
    public Double getEmotionalWeightOfTweet(Tweet tweet, ReportParams params)
    {
        Double weight = 0.0;

        String[] words = StringUtils.getWordsFromString(tweet.getMessage());

        for (TweetSentiment tweetSentiment : params.getTweetSentimentsList().getTweetSentiments())
        {
            for (String word : words)
            {
                if (tweetSentiment.getWord().equals(word)) // reverse
                {
                    weight += tweetSentiment.getWeight();
                }
            }
        }

        return weight;
    }

}