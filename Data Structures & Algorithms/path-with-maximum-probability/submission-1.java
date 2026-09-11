class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] probs = new double[n];
        Arrays.fill(probs,0.0);
        probs[start_node] = 1;

        for(int loops = 0 ; loops < n - 1 ;loops++){
            for(int i = 0 ; i < edges.length ; i++){
                int[] edge = edges[i];
                int u = edge[0];
                int v = edge[1];
                double w = succProb[i];

                double probV = probs[v];

                if(probs[u] * w > probs[v]){
                    probs[v] = probs[u] * w;
                }

                if(probV * w > probs[u]){
                    probs[u] = probV * w;
                }
                
            }
        }

        return probs[end_node];
    }
}