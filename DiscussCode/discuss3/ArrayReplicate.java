public class ArrayReplicate {
    public static int[] replicate(int[] arr) {
        int total = 0;
        for(int i=0;i<arr.length;i++){
            total += arr[i];
        }
        int [] newarr = new int[total];
        int pos = 0;
        for(int i =0;i< arr.length;i++){
            for(int j =0;j<arr[i];j++){
                newarr[pos] = arr[i];
                pos += 1;
            }
        }
        return newarr;
    }
//
//    public static void main(String[] args){
//       int[] array = new int[]{1,2,3};
//       for(int i =0;i< args.length;i++){
//           System.out.println(array[i]);
//       }
//       int [] newarr = replicate(array);
//        for(int i =0;i< args.length;i++){
//            System.out.println(newarr[i]);
//        }
//
//    }

}
