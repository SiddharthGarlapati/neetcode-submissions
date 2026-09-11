class Solution {

    public String encode(List<String> strs) {
        
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);

        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> list = new ArrayList<>();
        int i = 0;

        while( i < str.length()){
            int word_length = 0;
            int j = i;
            while(str.charAt(j) != '#'){
                word_length = word_length * 10 + (str.charAt(j) - '0');
                j++;
            }
            int start = j + 1;
            int end = j + 1 + word_length;
            String s = str.substring(start, end);
            list.add(s);
            i = end;
            
        }

        return list;

        

    }
}
