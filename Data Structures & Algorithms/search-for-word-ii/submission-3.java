class Solution {
    class TrieNode{
        Map<Character, TrieNode> children;
        boolean endOfWord;
        TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    public void addWord(TrieNode root, String word){
        TrieNode curr = root;

        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch)){
                curr.children.put(word.charAt(i),new TrieNode());
            }    
            curr = curr.children.get(word.charAt(i));
        }
        
        curr.endOfWord = true;
    }

    List<String> res;
    int rows;
    int cols;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();

        rows = board.length;
        cols = board[0].length;
        TrieNode root = new TrieNode();
        visited = new boolean[rows][cols];

        for(String s : words){
            addWord(root,s);
        }

        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){
                StringBuilder sb = new StringBuilder();
                dfs(r,c,root,board,sb);
            }
        }

        return res;
    }


    private void dfs(int r , int c , TrieNode root, char[][] board, StringBuilder sb){
        if(r < 0 || r > rows - 1 || c < 0 || c > cols - 1 || visited[r][c] == true ||
        !root.children.containsKey(board[r][c])){
            return;
        }

        visited[r][c] = true;
        sb.append(board[r][c]);


        TrieNode node = root.children.get(board[r][c]);
        if(node.endOfWord == true){
            res.add(sb.toString());
            node.endOfWord = false;
        }

        dfs(r + 1, c, node, board,sb);
        dfs(r - 1, c, node, board,sb);
        dfs(r , c + 1, node, board,sb);
        dfs(r , c - 1, node, board,sb);

        sb.deleteCharAt(sb.length() - 1);
        visited[r][c] = false;

    }
}
