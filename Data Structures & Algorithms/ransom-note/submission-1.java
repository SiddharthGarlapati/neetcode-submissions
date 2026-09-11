class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        if(magazine.length() < ransomNote.length()){
            return false;
        }
        int[] count = new int[26];

        for(int i = 0 ; i < magazine.length(); i++){
            char ch = magazine.charAt(i);
            count[ch - 'a']++;
        }

        for(int i = 0 ; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            if(count[ch - 'a'] == 0){
                return false;
            }

            count[ch - 'a']--;
        }

        return true;
        
    }
}