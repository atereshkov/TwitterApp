package com.github.handioq;


import com.github.handioq.IO.Reader;
import com.github.handioq.Utils.FileUtils;
import com.github.handioq.Utils.StringUtils;
import com.github.handioq.database.DBConnection;
import com.github.handioq.database.DBWorker;
import com.github.handioq.models.*;
import com.github.handioq.parsers.IParser;
import com.github.handioq.parsers.SentimentsParser;
import com.github.handioq.parsers.StateParser;
import com.github.handioq.parsers.TweetsParser;
import com.github.handioq.reports.*;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        /*String filename = args[0];
        int begin = Integer.parseInt(args[1]);
        int end = Integer.parseInt(args[2]);
        int report = Integer.parseInt(args[3]);*/

        long startTime = System.currentTimeMillis();

        String tweetsFilename = "E:\\Универ\\4SEMESTR\\Java\\trends\\data\\all_tweets.txt";
        String sentimentsFilename = "E:\\Универ\\4SEMESTR\\Java\\trends\\data\\sentiments.csv";
        String statesFilename = "E:\\Универ\\4SEMESTR\\Java\\trends\\data\\states.json";
        int begin = 0;
        int end = 1000;
        int report = 0;

        //ArrayList<String> list = Reader.fromFile(tweetsFilename, begin, end);

        FileReaderThread myThread = new FileReaderThread(tweetsFilename, begin, end);

        Thread t = new Thread(myThread);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<String> list = myThread.getValue();


        TweetsParser tweetsParser = new TweetsParser(list);
        /*TweetList tweetList = new TweetList();
        for (int i = 0; i < list.size(); i++)
        {
            tweetList.add(tweetsParser.parse(list.get(i)));
        }*/
        //tweetList.print();

        TweetParserThread tweetParserThread = new TweetParserThread(list, tweetsParser);

        Thread t3 = new Thread(tweetParserThread);
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TweetList tweetList = tweetParserThread.getValue();

        //ArrayList<String> stringSentimentsList = Reader.fromFile(sentimentsFilename, 1, FileUtils.getNumberOfLines(sentimentsFilename));

        FileReaderThread myThread2 = new FileReaderThread(sentimentsFilename, 1, FileUtils.getNumberOfLines(sentimentsFilename));

        Thread t2 = new Thread(myThread2);
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<String> stringSentimentsList = myThread2.getValue();

        SentimentParserThread sentimentParserThread = new SentimentParserThread(stringSentimentsList);

        Thread t4 = new Thread(sentimentParserThread);
        t4.start();
        try {
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TweetSentimentsList tweetSentimentsList = sentimentParserThread.getValue();

        //ArrayList<String> stringStatesList = Reader.fromFile(statesFilename, 1, FileUtils.getNumberOfLines(statesFilename));

        FileReaderThread statesThreadReader = new FileReaderThread(statesFilename, 1, FileUtils.getNumberOfLines(statesFilename));

        Thread t5 = new Thread(statesThreadReader);
        t5.start();
        try {
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<String> stringStatesList = statesThreadReader.getValue();

        StateParserThread stateParserThread = new StateParserThread(stringStatesList);

        Thread t6 = new Thread(stateParserThread);
        t6.start();
        try {
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        StateList stateList = stateParserThread.getValue();

        //stateList.print();

        // reports:

        IReport<TweetList> tweetReport = new TweetReport(); // report params
        TweetReportResult tweetsWithHashtag = tweetReport.getReport(new ReportParams(tweetList, "lol"));
        tweetsWithHashtag.print();

        Date startDate = StringUtils.getDateFromString("2011-04-13 19:02:50");
        Date endDate = StringUtils.getDateFromString("2011-09-04 14:06:46");

        IReport<Double> sentimentReport = new SentimentReport();
        SentimentReportResult sentimentReportResult = sentimentReport.getReport(new ReportParams(tweetList, tweetSentimentsList, startDate, endDate));
        sentimentReportResult.print();

        IReport<State> stateReport = new StateReport();
        StateReportResult stateReportResult = stateReport.getReport(new ReportParams(stateList, tweetList, startDate, endDate));
        System.out.println(stateReportResult);

        long endTime  = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime); // without threads: ~ 1400-1500 ms

        //AppFrame testWindow = new AppFrame(stateList);


        DBConnection dbConnection = new DBConnection();

        dbConnection.isConnected();

        DBWorker dbWorker = new DBWorker();
        //dbWorker.insertTweets(dbConnection, tweetList);
        //dbWorker.insertSentiments(dbConnection, tweetSentimentsList);

        TweetList tweetsFromDB = dbWorker.getAllTweets(dbConnection);
        TweetList withHashtag = dbWorker.getTweetsWithHashtag(dbConnection, "'%me%'");

        dbConnection.closeConnection();

    }

    private static class FileReaderThread implements Runnable {

        ArrayList<String> list = new ArrayList<String>();
        private String filename;
        private int begin;
        private int end;

        private FileReaderThread(String filename, int begin, int end) {
            this.filename = filename;
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            list = Reader.fromFile(filename, begin, end);
        }

        public ArrayList<String> getValue() {
            return list;
        }
    }

    private static class TweetParserThread implements Runnable {

        TweetList tweetList = new TweetList();
        ArrayList<String> list = new ArrayList<String>();
        TweetsParser tweetsParser;

        public TweetParserThread(ArrayList<String> list, TweetsParser tweetsParser) {
            this.list = list;
            this.tweetsParser = tweetsParser;
        }

        @Override
        public void run() {

            TweetsParser tweetsParser = new TweetsParser(list);

            for (int i = 0; i < list.size(); i++)
            {
                tweetList.add(tweetsParser.parse(list.get(i)));
            }
        }

        public TweetList getValue() {
            return tweetList;
        }
    }

    private static class SentimentParserThread implements Runnable {

        ArrayList<String> stringSentimentsList = new ArrayList<String>();
        TweetSentimentsList tweetSentimentsList = new TweetSentimentsList();

        public SentimentParserThread(ArrayList<String> stringSentimentsList) {
            this.stringSentimentsList = stringSentimentsList;
        }

        @Override
        public void run() {
            IParser<TweetSentiment> sentimentsParser = new SentimentsParser(stringSentimentsList);

            for (int i = 0; i < stringSentimentsList.size(); i++)
            {
                tweetSentimentsList.add(sentimentsParser.parse(stringSentimentsList.get(i)));
            }
        }

        public TweetSentimentsList getValue() {
            return tweetSentimentsList;
        }
    }

    private static class StateParserThread implements Runnable {

        ArrayList<String> stringStatesList = new ArrayList<String>();
        StateList stateList = new StateList();

        public StateParserThread(ArrayList<String> stringStatesList) {
            this.stringStatesList = stringStatesList;
        }

        @Override
        public void run() {
            IParser<State> stateParser = new StateParser(stringStatesList);
            stateList = stateParser.parse(stringStatesList.get(0));
        }

        public StateList getValue() {
            return stateList;
        }
    }

}

// E:\Универ\4SEMESTR\Java\trends\data\
// D:\4SEMESTR\trends\data\
