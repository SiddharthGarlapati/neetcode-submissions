class Solution {
    List<List<Integer>> res;
    int tar;
    List<Integer> curr;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        tar = target;
        curr = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0,0);
        return res;
        
    }

    public void backtrack(int[] candidates, int i,int sum){
        if(sum == tar){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if(sum > tar || i >= candidates.length ) return;

        curr.add(candidates[i]);
        backtrack(candidates, i+1,sum + candidates[i]);
        curr.remove(curr.size() - 1);

        while(i+1 < candidates.length && candidates[i] == candidates[i + 1]){
            i++;
        }

        backtrack(candidates, i+1, sum);

    }
}
