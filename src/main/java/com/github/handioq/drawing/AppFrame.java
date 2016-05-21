package com.github.handioq.drawing;


import com.github.handioq.models.IntegerPoint;
import com.github.handioq.models.State;
import com.github.handioq.models.StateList;
import com.github.handioq.models.TweetLocation;

import javax.swing.*;
import java.awt.*;

/*
 * Класс для отображения окна и рисования штатов на нем.
 * MULTY - делитель для перевода из Integer в double координаты.
 * @author Alexander Tereshkov
 */
public class AppFrame extends JFrame {

    static final String appTitle = "Frame-Application";
    final Integer MULTY = 1000000;

    StateList stateList = new StateList();

    public static void main(String[] args) {
        new AppFrame(null);
    }

    /*
     * Создает окно JFrame для рисования штатов.
     * @param stateList список штатов
     */
    public AppFrame(StateList stateList)
    {
        super(appTitle);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        this.stateList = stateList;
    }

    /*
     * Рисует на окне штаты со случайными цветами.
     * @param g
     */
    public void paint(Graphics g) {
        super.paint(g);

        Dimension size = this.getSize();

        for (State state : stateList.getStates())
        {
            if (!state.getName().equals("AK")) {
                Polygon polygon = new Polygon();
                for (TweetLocation tweetLocation : state.getCoordinates()) {
                    IntegerPoint integerPoint = toIntegerPoints(tweetLocation);
                    polygon.addPoint((integerPoint.getX() / 100000) + 1500, -1 * (integerPoint.getY() / 100000) + 700);
                }

                g.setColor(new Color((int) (Math.random() * 0x1000000)));
                //g.setColor(Color.red);
                g.fillPolygon(polygon);
            }
        }

    }

    /*
     * Возвращает целые координаты из double
     * @param doublePoints координаты в формате double
     * @return IntegerPoint
     */
    private IntegerPoint toIntegerPoints(TweetLocation doublePoints)
    {
        return (new IntegerPoint((int)(doublePoints.getX())*MULTY, (int) (doublePoints.getY()*MULTY)));
    }

    /*
    private java.util.List<IntegerPoint> getIntegerPoints(java.util.List<TweetLocation> input)
    {
        java.util.List<IntegerPoint> out = new ArrayList<IntegerPoint>();

        for(TweetLocation doubleCoord : input)
        {
            out.add(new IntegerPoint((int) doubleCoord.getX()*MULTY, (int) doubleCoord.getY()*MULTY));
        }

        return out;
    }
    */

}
