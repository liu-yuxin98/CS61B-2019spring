import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.util.*;

/**
 * Created by hug.
 */
public class Experiments {





    public static void experiment1() {

        BST<Integer> b1 = new BST<>();
        List<Integer> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();
        /* different outcomes*/
       for(int i=1000;i<5000;i+=50) {
           b1 = ExperimentHelper.getRandomBST(i);
           double avgDepth = b1.AverageDepth();
           xValues.add(i);
           yValues.add(avgDepth);
       }
       /* draw*/
        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("Size of Tree").yAxisTitle("Avg Depth").build();
        chart.addSeries("x + random(0, 10)", xValues, yValues);
        new SwingWrapper(chart).displayChart();
    }

    public static void experiment2() {
        /*Initialize a tree by randomly inserting N items.
        Record the average depth observed as the ‘starting depth’.
        * */
        int N = 3000;
        BST<Integer> b1 = new BST<>();
        b1 = ExperimentHelper.getRandomBST(N);
        double avgdepth = b1.AverageDepth();
        int M = 300000;

        List<Integer> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();

        for(int i=0;i<M;i++){
            /* Randomly delete an item using asymmetric Hibbard deletion.*/
           int deletekey = b1.getRandomKey();
            b1.deleteTakingSuccessor(deletekey);
            /*Randomly insert a new item (odds number).*/
            ExperimentHelper.InsertRandomItem(b1);
            xValues.add(i);
            yValues.add(b1.AverageDepth()); /*Record the average depth of the tree.*/
        }
        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("Size of Tree").yAxisTitle("Avg Depth").build();
        chart.addSeries("x + random(0, 10)", xValues, yValues);
        new SwingWrapper(chart).displayChart();


    }

    public static void experiment3() {
        /*Initialize a tree by randomly inserting N items.
        Record the average depth observed as the ‘starting depth’.
        * */
        int N = 1000;
        BST<Integer> b1 = new BST<>();
        b1 = ExperimentHelper.getRandomBST(N);
        double avgdepth = b1.AverageDepth();
        int M = 1000000;

        List<Integer> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();

        for(int i=0;i<M;i++){
            /* Randomly delete an item using asymmetric Hibbard deletion.*/
            int deletekey = b1.getRandomKey();
            b1.deleteTakingRandom(deletekey);

            /*Randomly insert a new item (odds number).*/
            ExperimentHelper.InsertRandomItem(b1);
            xValues.add(i);
            yValues.add(b1.AverageDepth()); /*Record the average depth of the tree.*/
        }
        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("Size of Tree").yAxisTitle("Avg Depth").build();
        chart.addSeries("x + random(0, 10)", xValues, yValues);
        new SwingWrapper(chart).displayChart();
    }

    public static void main(String[] args) {
        experiment3();
    }



}
