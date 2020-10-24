/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
import es.datastructur.synthesizer.GuitarString;

/** Tests the GuitarString class.
 *  @author Yuxin Liu
 */
public class GuitarHero {

    private static final Character [] StringBoard = new Character[]{'a','s','d','f','g','h',
    'j','k','l'};
    private static final double[] CONCERT = new double[StringBoard.length];


    public static void main(String[] args) {

        /* creat all guitar strings, store them in allGuitarString*/
        GuitarString[] allGuitarString = new GuitarString[StringBoard.length];
        for(int i=0;i<CONCERT.length;i++){
            CONCERT[i] = 440*Math.pow(2,(i-24)/12);
            allGuitarString[i] = new GuitarString(CONCERT[i]);
        }


        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                for(int i=0;i<StringBoard.length;i++){
                    if(key==StringBoard[i]){
                        allGuitarString[i].pluck();
                    }
                }

            }

            /* compute the superposition of samples */
            double sample =0.0;
            for(int i=0;i< allGuitarString.length;i++){
                    sample += allGuitarString[i].sample();
            }
            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */

            for(int i=0;i<allGuitarString.length;i++){
                allGuitarString[i].tic();
            }
        }
    }
}
