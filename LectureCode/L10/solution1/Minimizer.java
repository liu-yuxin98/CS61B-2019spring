package solution1;
public class Minimizer {
    public static Comparable getMin(Comparable[] items){
        Comparable minitem = items[0];
        for(Comparable item:items){
            int flag = item.compareTo(minitem);
            if(flag<0){
                minitem = item;
            }
        }
        return minitem;
    }
}
