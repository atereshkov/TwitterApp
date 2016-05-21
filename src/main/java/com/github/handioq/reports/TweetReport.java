package com.github.handioq.reports;


import com.github.handioq.Utils.StringUtils;
import com.github.handioq.models.Tweet;
import com.github.handioq.models.TweetList;

/**
 * Class to make the report that returns a TweetReportResult,
 * which keeps a list of tweets with a specific hashtag.
 * @author Alexander Tereshkov
 * @version 1.0
 */
public class TweetReport implements IReport<TweetList> {

    private TweetList tweetList = new TweetList();
    private String hashtag;

    /**
     * Initializes a newly created object of TweetReport for
     * find a hashtag in list of tweets.
     * @param tweetList list of states
     * @param hashtag word for finding
     */
    public TweetReport(TweetList tweetList, String hashtag) {
        this.tweetList = tweetList;
        this.hashtag = hashtag;
    }

    /**
     * Initializes a newly created object of TweetReport with empty date.
     */
    public TweetReport() {
    }

    /**
     * Returns a TweetReportResult, which contains a result of this report.
     * This report find all states with specific hashtag.
     * @param params ReportParams for TweetReport.
     * @return TweetReportResult list of tweets with specific hashtag
     * @see TweetReportResult
     * @see ReportParams
     * @see StringUtils
     */
    @Override
    public TweetReportResult getReport(ReportParams params) {

        TweetList tweetsWithHashtag = new TweetList();

        for (Tweet tweet : params.getTweetList().Tweets)
            {
            for (String in : StringUtils.getWordsFromString(tweet.getMessage()))
            {
                if (in.contains(params.getHashtag()))
                {
                    if (!tweetsWithHashtag.contains(tweet))
                    {
                        tweetsWithHashtag.add(tweet);
                    }
                }
            }
        }

        return new TweetReportResult(tweetsWithHashtag);
    }
}
