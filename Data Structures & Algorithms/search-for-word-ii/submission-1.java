class Solution {
    private class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    private class PrefixTree{
        
        TrieNode root;
        PrefixTree(){
            root = new TrieNode();
        }

        private void addWord(String word){
            TrieNode curr = root;

            for( int i = 0 ; i < word.length(); i++){
                char c = word.charAt(i);
                 curr.children.putIfAbsent(c, new TrieNode());
                 curr = curr.children.get(c);
            }

            curr.isWord = true;
        }

    }

    List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        
        PrefixTree p = new PrefixTree();
        for(String word: words){
            p.addWord(word);
        }
        TrieNode root = p.root;
        
        result = new ArrayList<>();

        for(int r = 0 ; r < board.length; r++){
            for( int c = 0 ; c < board[0].length; c++){
                StringBuilder sb = new StringBuilder();
                dfs(board, r,c,root, sb);
            }
        }

        return result;


    }


    private void dfs(char[][] board, int r, int c ,TrieNode node,  StringBuilder sb){
        if(r < 0 || c < 0 || r >= board.length 
        || c >= board[0].length || !node.children.containsKey(board[r][c]) ){
            return ;
        }
        
        char ch = board[r][c];
        board[r][c] = '#';
        sb.append(ch);
        node = node.children.get(ch);
        if(node.isWord){
           result.add(sb.toString());
           node.isWord = false;
        }

        dfs(board, r + 1, c, node, sb);
        dfs(board, r - 1, c, node, sb);
        dfs(board, r, c + 1, node, sb);
        dfs(board, r, c - 1, node, sb);


        sb.deleteCharAt(sb.length() - 1);
        board[r][c] = ch;


    }
}
