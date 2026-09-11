class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0,0,candidates,target, list);

        return res;
        
    }

    private void dfs(int idx, int currSum , int[] candidates, int target,List<Integer> list){
        if(currSum == target){
            res.add(new ArrayList<>(list));
            return;
        }

        if(currSum > target){
            return;
        }

        Set<Integer> used = new HashSet<>();

        for(int i = idx ; i < candidates.length ; i++){

            if(used.contains(candidates[i])){
                continue;
            }
            if(currSum + candidates[i] > target){
                break;
            }

            used.add(candidates[i]);
            list.add(candidates[i]);
            dfs(i + 1,currSum + candidates[i],candidates,target, list);
            list.remove(list.size() - 1);
        }
    }
}
