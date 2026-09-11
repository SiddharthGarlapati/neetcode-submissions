class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(0,s,list);

        return res;
    }

    private void dfs(int start,String s, List<String> list){
        if(start == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int end = start; end < s.length() ; end++){
            String str = s.substring(start,end + 1);
            if(isPalindrome(s,start,end)){
                list.add(str);
                dfs(end + 1 , s, list);
                list.remove(list.size() - 1);
            }
        }
    }


    private boolean isPalindrome(String str,int left, int right){

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;

    }
}
