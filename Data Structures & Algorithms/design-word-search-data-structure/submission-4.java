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
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch, new TrieNode());
            }
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
            for(char c : curr.children.keySet()){
                if(dfs(i+1, word, curr.children.get(c))){
                    return true;
                }
            }

        }
        else{
            if(!curr.children.containsKey(ch)){
                return false;
            }
            return dfs(i + 1, word,curr = curr.children.get(ch));

        }

        return false;
    }
}
