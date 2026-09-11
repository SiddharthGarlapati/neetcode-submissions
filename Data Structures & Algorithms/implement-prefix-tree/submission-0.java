class PrefixTree {

    private class TrieNode{
        Map<Character,TrieNode> children = new HashMap<>();
        boolean endOfWord = false;

    }

    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
         
    }


    public void insert(String word) {
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

        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr = curr.children.get(c);
        }

        return curr.endOfWord ;

    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr = curr.children.get(c);
        }

        return true;

    }
}
