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

        int i = 0;
        int n = str.length();
        List<String> res = new ArrayList<>();

        while(i < n){
            int len = 0;
            while(str.charAt(i) != '#'){
                len = len * 10 + str.charAt(i) - '0';
                i++;
            }
            i++;
            
            res.add(str.substring(i, i + len));
            i = i + len;
        }

        return res;
    }
}
