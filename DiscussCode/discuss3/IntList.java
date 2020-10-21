public class IntList {
    public int first;
    public IntList rest;
    public IntList (int f, IntList r) {
        this.first = f;
        this.rest = r;
        }

    public void skippfy() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p.rest;
            for (int i=0;i<n;i++) {
                if (p.rest == null) {
                        break;
                }
                next = next.rest;
            }
            n++;
            p.rest = next;
            p = next;
        }
    }
    /** Non-destructively creates a copy of x that contains no occurences of y.*/
    public static IntList ilsans(IntList x, int y) {
        if (x==null) {
            return null;
            }
        if (x.first ==y) {
            return ilsans(x.rest,y);
        }
        return new IntList(x.first, ilsans(x.rest, y));
        }

    /** Destructively modify and return x to contain no occurences of y,
     without using the keyword "new". */

    public static IntList dilsans(IntList x, int y) {
        if (x==null) {
            return null;
        }
        x.rest = dilsans(x.rest,y);
        if (x.first == y) {
            return x.rest;
        }
        return x;
        }

}
