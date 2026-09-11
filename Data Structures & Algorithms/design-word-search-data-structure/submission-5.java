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
        TrieNode curr = root;
        return dfs(0,word, curr);
    }

    private boolean dfs(int i, String word , TrieNode curr){
        if(i == word.length()){
            return curr.endOfWord;
        }

        char ch = word.charAt(i);

        if(ch == '.'){
            for(TrieNode child : curr.children.values()){
                if(dfs(i+1,word, child)){
                    return true;
                }
            }
            return false;
        }

        if(!curr.children.containsKey(ch)){
            return false;
        }

        return dfs(i+1,word,curr.children.get(ch));
    }    
}
