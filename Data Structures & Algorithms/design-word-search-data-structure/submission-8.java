class TrieNode{
    Map<Character, TrieNode> children;
    boolean endOfWord;
    TrieNode(){
        children = new HashMap<>();
        endOfWord = false;
    }
}

class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }

        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(0,word,root);
    }

    private boolean dfs(int i, String word, TrieNode curr){
        if(i == word.length()){
            return curr.endOfWord;
        }

        char ch = word.charAt(i);
        if(ch == '.'){
            for(char c : curr.children.keySet()){
                if(dfs(i+1,word,curr.children.get(c))){
                    return true;
                }
            }
        }
        else{
            
            if(!curr.children.containsKey(ch)){
                return false;
            }
            curr = curr.children.get(ch);
            return dfs(i + 1, word, curr);
        }

        return false;
    }
}
