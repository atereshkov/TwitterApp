package com.github.handioq.reports;


import com.github.handioq.models.IntegerPoint;
import com.github.handioq.models.State;
import com.github.handioq.models.Tweet;
import com.github.handioq.models.TweetLocation;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to get the result of the first report,
 * which returns the state with the highest number of tweets,
 * in a specific period of time.
 * @author Alexander Tereshkov
 * @version 1.0
 */
public class StateReport implements IReport<State> {

    /**
     * The variable-multiplier to convert coordinates from double to Integer
     */
    final Integer MULTY = 1000000;

    /**
     * Initializes a newly created object of StateReport for make a report.
     */
    public StateReport() {
    }

    /**
     * Returns the state with the highest number of tweets at a given period of time.
     * @param params ReportParams for StateReport
     * @return StateReportResult, witch contains the result of this report
     * @see ReportParams
     * @see StateReportResult
     */
    @Override
    public StateReportResult getReport(ReportParams params)
    {
        Integer allTweetsCount = 0;
        Map<String, Integer> statesCounter = new HashMap<String, Integer>();

        for (State state : params.getStateList().getStates()) // State state : stateList.getStates()
        {
            Integer tweetsInState = 0;
            for(Tweet tweet : params.getTweetList().getTweets()) // Tweet tweet : tweetList.getTweets()
            {
                if(tweet.getDateTime().after(params.getStartDate()) && tweet.getDateTime().before(params.getEndDate()))
                {
                    Polygon polygon = new Polygon();

                    if (contains(state, toIntegerPoints(tweet.getCoordinates()), polygon))
                    {
                        tweetsInState++;
                        allTweetsCount++;
                    }

                }
            }
            statesCounter.put(state.getName(), tweetsInState);
        }

        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String,Integer> entry : statesCounter.entrySet())
        {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue())
            {
                maxEntry = entry;
            }
        }

        return new StateReportResult(params.getStateList().getStateByName(maxEntry.getKey()));
    }

    /**
     * Transfer the coordinates from the double to Integer
     * @param doublePoints  coordinates in double
     * @return IntegerPoint
     * @see TweetLocation
     */
    private IntegerPoint toIntegerPoints(TweetLocation doublePoints)
    {
        return (new IntegerPoint((int)(doublePoints.getX())*MULTY, (int) (doublePoints.getY()*MULTY)));
    }

    /**
     * Returns a list of coordinates in integer format.
     * @param input list of coordinates of type TweetLocation
     * @return list of IntegerPoint
     * @see IntegerPoint
     * @see TweetLocation
     */
    private List<IntegerPoint> getIntegerPoints(List<TweetLocation> input)
    {
        List<IntegerPoint> out = new ArrayList<IntegerPoint>();

        for(TweetLocation doubleCoord : input)
        {
            out.add(new IntegerPoint((int) doubleCoord.getX()*MULTY, (int) doubleCoord.getY()*MULTY));
        }

        return out;
    }

    /**
     * Checks if the point is in the polygon.
     * @param state state for test
     * @param test coordinates of type IntegerPoint
     * @param polygon polygon
     * @return true, if the point inside, false otherwise
     */
    public boolean contains(State state, IntegerPoint test, Polygon polygon) {

        for (IntegerPoint intPoint: getIntegerPoints(state.getCoordinates()))
        {
            polygon.addPoint(intPoint.getX(), intPoint.getY());
        }

        if (polygon.contains(test.getY(), test.getX()))
            return true;


        return false;
    }

}
