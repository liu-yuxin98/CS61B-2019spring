import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/* code source
https://www.junhaow.com/studynotes/cs61b/cs61b%20clab8%20flight.html/
 */

/**
 * Solver for the Flight problem (#9) from CS 61B Spring 2018 Midterm 2.
 * Assumes valid input, i.e. all Flight start times are >= end times.
 * If a flight starts at the same time as a flight's end time, they are
 * considered to be in the air at the same time.
 */
public class FlightSolver {
    private PriorityQueue<Flight> minStartPQ;
    private PriorityQueue<Flight> minEndPQ;


    Comparator<Flight> minStartComp = (o1, o2) -> (o1.startTime() - o2.startTime());
    /* returns o1.startTime()-o2.startTime()*/
    Comparator<Flight> minEndComp = (o1, o2) -> (o1.endTime() - o2.endTime());
    /* returns o1.endTime()-o2.endTime()*/

    public FlightSolver(ArrayList<Flight> flights) {
        minStartPQ = new PriorityQueue<>(flights.size(), minStartComp);
        minEndPQ = new PriorityQueue<>(flights.size(), minEndComp);
        for (Flight f : flights) { // Pointing to the same copy. That's fine.
            minStartPQ.add(f);
            minEndPQ.add(f);
        }
    }


    public int solve(){
        int tally = 0;
        int maxvalue = 0;
        while(minStartPQ.size()>0 && minEndPQ.size()>0){
            /* 此时最早的开始时间*/
            int minStart = minStartPQ.peek().startTime;
            /* 此时最早的结束时间*/
            int minEnd = minEndPQ.peek().endTime;

            /* 最早开始时间<最早结束时间： 有overlap*/
            if(minStart<= minEnd){
                Flight f = minStartPQ.remove();
                tally += f.passengers;
            } else{
                /* 最早开始时间 > 最早结束时间：最早结束时间后移*/
                Flight f = minEndPQ.remove();
                tally -= f.passengers;
            }
            if(tally>=maxvalue){
                maxvalue = tally;
            }

        }
        return maxvalue;
    }

//    public int solve() {
//        int maxVal = 0;
//        int tally = 0;
//        while (minStartPQ.size() > 0 && minEndPQ.size() > 0) {
//            /* peek out thr min start time at this moment*/
//            int startTime = minStartPQ.peek().startTime;
//            /* peek out the min end time at the moment*/
//            int endTime = minEndPQ.peek().endTime();
//
//            if (startTime <= endTime) { // Start-End Overlap: Option 2
//                Flight f = minStartPQ.remove();
//                tally += f.passengers();
//            } else {
//                Flight f = minEndPQ.remove();
//                tally -= f.passengers();
//            }
//            maxVal = (tally > maxVal) ? tally : maxVal;
//        }
//        return maxVal;
//    }


    public static void main(String[] args){
        ArrayList<Flight> flights = new ArrayList<Flight>();
        Flight f1 = new Flight(0,10,100);
        Flight f2 = new Flight(2,6,50);
        Flight f3 = new Flight(7,18,90);
        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        FlightSolver fs = new FlightSolver(flights);
        char c = 'c';
        int nc = (int)c;
        System.out.println(nc);

    }

}
