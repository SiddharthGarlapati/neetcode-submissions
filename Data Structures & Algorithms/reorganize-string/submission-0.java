class Solution {
    public String reorganizeString(String s) {

        int n = s.length();

        int[] freq = new int[26];

        for(int i = 0 ; i < n ; i++){
            freq[s.charAt(i) - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] > 0 ){
                maxHeap.offer(new int[]{i + 'a',freq[i]});
            }
        }


        StringBuilder sb = new StringBuilder();

        int[] prev = null;


        while(!maxHeap.isEmpty()){
            int[] temp = maxHeap.poll();
            char ch = (char) temp[0];
            int count = temp[1];

            sb.append(ch);
            count--;

            if(prev != null){
                maxHeap.offer(prev);
                prev = null;
            }

            if(count > 0 ){
                prev = new int[]{temp[0],count};
            }

        }

        
        return sb.length() == n ? sb.toString() : "";
        
    }
}