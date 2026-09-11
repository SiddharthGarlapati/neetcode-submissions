class Solution {
    int[] parent;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        Map<String,Integer> E2I = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++){
                String email = account.get(j);
                if(E2I.containsKey(email)){
                    int rootU = find(E2I.get(email));
                    int rootV = find(i);
                    parent[rootV] = rootU;
                }
                else{
                    E2I.put(email,i);
                }
            }
        }

        Map<Integer,List<String>> I2E = new HashMap<>();


        for(String email : E2I.keySet()){
            int index = E2I.get(email);
            int root = find(index);
            I2E.putIfAbsent(root,new ArrayList<>());
            I2E.get(root).add(email);

        }

        List<List<String>> res = new ArrayList<>();

        for(int curr : I2E.keySet()){
            List<String> emails = I2E.get(curr);
            Collections.sort(emails);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(curr).get(0));
            temp.addAll(emails);
            res.add(temp);
        }

        return res;

    }

    private int find(int n){
        if(parent[n] != n){
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }
}