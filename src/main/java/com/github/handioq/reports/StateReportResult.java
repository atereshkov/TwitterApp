package com.github.handioq.reports;


import com.github.handioq.models.State;

/**
 * The class is a result of StateReport.
 * maxState keeps the state with the highest number of tweets,
 * in a predetermined period of time.
 * @see StateReport
 * @author Alexander Tereshkov
 * @version 1.0
 */
public class StateReportResult {

    State maxState;

    /**
     * Initializes a newly created object of StateReportResult with state.
     * @param maxState state with the highest number of tweets.
     */
    public StateReportResult(State maxState) {
        this.maxState = maxState;
    }

    /**
     * Print the maxState name to Console.
     */
    public void print()
    {
        System.out.println(maxState.getName());
    }

    /**
     * Returns a string with maxState.
     * @return string, thar represent maxState
     */
    @Override
    public String toString() {
        return "StateReportResult{" +
                "maxState=" + maxState +
                '}';
    }
}
