package com.github.handioq.reports;

/**
 * Interface for classes witch return the reports with it results.
 * @author Alexander Tereshkov
 * @see ReportParams
 * @see SentimentReport
 * @see StateReport
 * @see TweetReport
 * @param <T>
 */
public interface IReport<T> {

    /**
     * Returns generic T report.
     * @param params input parameters for the report
     * @param <T> type
     * @return generic result
     */
    public <T> T getReport(ReportParams params);

}
