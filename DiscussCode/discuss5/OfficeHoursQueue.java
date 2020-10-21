import java.util.Iterator;

public class OfficeHoursQueue implements Iterable<OHRequest>{
    public OHRequest fOHR;
    /* 为OfficeHoursQueue写一个iterator*/
    @Override
    public OHIterator iterator(){
        return new OHIterator(fOHR);
    }

    public OfficeHoursQueue (OHRequest queue) {
        this.fOHR = queue;
    }

    public static void main(String [] args) {
        OHRequest s1 = new OHRequest("Failing my test for get in arrayDeque, NPE", "Pam", null);
        OHRequest s2 = new OHRequest("conceptual: what is dynamic method selection", "Michael", s1);
        OHRequest s3 = new OHRequest("git: what does checkout do.", "Jim", s2);
        OHRequest s4 = new OHRequest("help", "Dwight", s3);
        OHRequest s5 = new OHRequest("debugging get(i)", "Creed", s4);

        OfficeHoursQueue OFH = new OfficeHoursQueue(s5);

        /* ugly iteration*/
        Iterator<OHRequest> seer = OFH.iterator();
        while(seer.hasNext()){
            System.out.println(seer.next().name);
        }
        /* beautiful iteration, only need to add  implements Iterable<OHRequest> in the end of th
        OfficeHOursQueue class
         */
        for (OHRequest s: OFH) {
            System.out.println(s.name);
        }
    }
}
