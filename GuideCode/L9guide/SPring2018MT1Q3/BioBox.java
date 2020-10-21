package SPring2018MT1Q3;

public class BioBox extends StandardBox {
    public void unlock(SkeletonKey sk) {System.out.println("BioBox.usk"); } ;
    public void unlock(Fingerprint f) {System.out.println("BioBox.uf");  } ;

    public static void doStuff(Key k, SkeletonKey sk, Fingerprint f) {
        StandardBox sb = new StandardBox();
        StandardBox sbbb = new BioBox();
        BioBox bb = new BioBox();

        sb.unlock(k);
        sbbb.unlock(k);
        bb.unlock(k);
        System.out.println("---------------");
        sb.unlock(sk);
        sbbb.unlock(sk);
        bb.unlock(sk);
        System.out.println("---------------");
        System.out.println(" SPring2018MT1Q3.Fingerprint无法转换为SPring2018MT1Q3.Key "); /*sb.unlock(f);*/
        System.out.println("SPring2018MT1Q3.Fingerprint无法转换为SPring2018MT1Q3.Key"); /*sbbb.unlock(f);*/
        bb.unlock(f);
        System.out.println("---------------");
        bb  = (BioBox)sbbb;
        ((StandardBox) bb).unlock(sk);
        ((StandardBox) sbbb).unlock(sk);
        System.out.println("SPring2018MT1Q3.StandardBox cannot be cast to SPring2018MT1Q3.BioBox");
//        (BioBox)sb).unlock(sk);
    }
    public static void main(String[] args){
        Key k = new Key();
        SkeletonKey sk = new SkeletonKey();
        Fingerprint f = new Fingerprint();
        doStuff(k,sk,f);
    }

}
