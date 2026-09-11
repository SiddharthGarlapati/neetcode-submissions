class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int write = 0;

        while(i < n){
            char curr = chars[i];
            int count = 0 ;

            while(i < n && chars[i] == curr){
                count++;
                i++;
            }

            chars[write] = curr;
            write++;

            if(count > 1){
                String s = "" + count;

                for(int idx = 0 ; idx < s.length(); idx++){
                    chars[write] = s.charAt(idx);
                    write++;
                }
            }

        }

        return write;


        
    }
}