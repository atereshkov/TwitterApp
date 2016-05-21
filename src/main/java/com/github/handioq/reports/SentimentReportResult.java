package com.github.handioq.reports;

/**
 * The class contains the result of the SentimentReport, which consists
 * the value of emotional color words for specific period of time.
 * @see SentimentReport
 * @author Alexander Tereshkov
 * @version 1.0
 */
public class SentimentReportResult {

    Double sentimentReportResult;

    /**
     * Initializes a newly created object of SentimentReportResult with
     * double value.
     * @param sentimentReportResult double value (result of report)
     */
    public SentimentReportResult(Double sentimentReportResult) {
        this.sentimentReportResult = sentimentReportResult;
    }

    /**
     * Initializes a newly created object of SentimentReportResult,
     * with empty data.
     */
    public SentimentReportResult() {
    }

    /**
     * Print the result for console.
     */
    public void print()
    {
        System.out.println(sentimentReportResult);
    }
}
