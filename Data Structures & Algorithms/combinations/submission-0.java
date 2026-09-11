class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        dfs(1,k,n,list);

        return res;
    }

    private void dfs(int start,int k , int n , List<Integer> list ){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        if(list.size() > k){
            return;
        }

        for(int i = start ; i <= n ; i++){
            list.add(i);
            dfs(i + 1, k ,n, list);
            list.remove(list.size() - 1);
        }
    }
}