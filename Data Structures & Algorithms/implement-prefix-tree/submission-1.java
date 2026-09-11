class TrieNode{
    Map<Character,TrieNode> map;
    boolean endOfWord;

    public TrieNode(){
        map = new HashMap<>();
        endOfWord = false;
    }
}

class PrefixTree {

    TrieNode trie ;

    public PrefixTree() {
        trie = new TrieNode();
    }

    public void insert(String word) {

        TrieNode temp = trie;

        for(int i = 0 ;i < word.length(); i++){
            char ch = word.charAt(i);
            if(!temp.map.containsKey(ch)){
                temp.map.put(ch, new TrieNode());
            }
            temp = temp.map.get(ch);
        }
        
        temp.endOfWord = true;
    }

    public boolean search(String word) {

        TrieNode temp = trie;

        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(!temp.map.containsKey(ch)){
                return false;
            }
            temp = temp.map.get(ch);
        }

        return temp.endOfWord;


    }

    public boolean startsWith(String prefix) {
        TrieNode temp = trie;

        for(int i = 0 ; i < prefix.length() ; i++){
            char ch = prefix.charAt(i);
            if(!temp.map.containsKey(ch)){
                return false;
            }
            temp = temp.map.get(ch);
        }

        return true;
    }
}
