class TrieNode{
    Map<Character,TrieNode> children;
    boolean endOfWord; 
    TrieNode(){
        children = new HashMap<>();
        endOfWord = false;
    }
}

class Solution {
    List<String> res;
    int rows;
    int cols;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;
        res = new ArrayList<>();

        visited = new boolean[rows][cols];

        TrieNode root = new TrieNode();

        for(String word : words){
            TrieNode curr = root;
            for(int i = 0 ; i < word.length(); i++){
                char ch = word.charAt(i);
                curr.children.putIfAbsent(ch, new TrieNode());
                curr = curr.children.get(ch);
            }
            curr.endOfWord = true;
        }

        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){
                StringBuilder sb = new StringBuilder();
                dfs(r,c,root,board,sb);
            }
        }

        return res;
    }

    private void dfs(int r, int c, TrieNode curr,char[][] board ,StringBuilder sb){
        if(r < 0 || r > rows - 1 || c < 0 || c > cols - 1 ||
        visited[r][c] == true || !curr.children.containsKey(board[r][c])){
            return;
        }

        char ch = board[r][c];

        sb.append(ch);
        visited[r][c] = true;

        curr = curr.children.get(ch);
        if(curr.endOfWord){
            res.add(sb.toString());
            curr.endOfWord = false;
        }


        dfs(r , c - 1, curr, board, sb);
        dfs(r , c + 1 , curr, board, sb);
        dfs(r - 1 , c , curr, board , sb);
        dfs(r + 1 , c , curr, board, sb);

        sb.deleteCharAt(sb.length() - 1);
        visited[r][c] = false;

        return;
    }
}
