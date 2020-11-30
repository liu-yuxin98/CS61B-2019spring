public class RabinKarpAlgorithm {


    /**
     * This algorithm returns the starting index of the matching substring.
     * This method will return -1 if no matching substring is found, or if the input is invalid.
     */
    public static int rabinKarp(String input, String pattern) {
        if(pattern.length()>input.length()){
            return -1;
        } else{
            int i = 0;
            while(i+pattern.length()<=input.length()){
                StringBuilder strb = new StringBuilder();
                for(int j=i;j<i+pattern.length();j++){
                    char c = input.charAt(j);
                    strb.append(c);
                }
                String temp = strb.toString();
                RollingString tinput = new RollingString(temp,temp.length());
                RollingString rpatten = new RollingString(pattern,pattern.length());
                if(rpatten.equals(tinput)){
                    return 1;
                }else{
                    i += 1;
                }
            }
            return -1;
        }

    }

}
