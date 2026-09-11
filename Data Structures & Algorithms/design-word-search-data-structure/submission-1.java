class WordDictionary {

    private class TrieNode{
        Map<Character,TrieNode> children = new HashMap<>();
        boolean endOfWord = false;
    }

    
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();

    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }

        curr.endOfWord = true;

    }


    public boolean search(String word) {
        TrieNode curr = root;
        return searchdfs(0,word,curr);

    }

    private boolean searchdfs(int index, String word,TrieNode curr){
        if(index == word.length()){
            return curr.endOfWord;
        }

        char c = word.charAt(index);
        if(c == '.'){
            for(TrieNode temp : curr.children.values()){
                if(searchdfs(index + 1, word, temp)){
                    return true;
                };
            }

            return false;

        }
        else{
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr = curr.children.get(c);
            return searchdfs(index + 1, word,curr);
        }


    }
}
