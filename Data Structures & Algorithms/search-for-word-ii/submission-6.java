class TrieNode{
    Map<Character,TrieNode> children;
    boolean endOfWord;
    TrieNode(){
        children = new HashMap<>();
        endOfWord = false;
    }
}

List<String> res;
boolean[][] visited;
int rows;
int cols;
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        rows = board.length;
        cols = board[0].length;

        visited = new boolean[rows][cols];

        TrieNode root = new TrieNode();

        for(String word : words){
            TrieNode curr = root;
            for(int i = 0 ; i < word.length() ; i++){
                char ch = word.charAt(i);
                curr.children.putIfAbsent(ch,new TrieNode());
                curr = curr.children.get(ch);
            }
            curr.endOfWord = true;
        }

        for(int r = 0 ; r < rows; r++){
            for(int c = 0 ; c < cols ; c++){
                StringBuilder sb = new StringBuilder();
                dfs(r,c,board,sb,root);
            }
        }

        return res;
    }

    private void dfs(int r , int c , char[][] board, StringBuilder sb,TrieNode curr){
        if(r < 0 || r > rows - 1 || c < 0 || c > cols - 1 || visited[r][c] == true || !curr.children.containsKey(board[r][c])){
            return ;
        }

        char ch = board[r][c];

        visited[r][c] = true;
        sb.append(ch);
        curr = curr.children.get(ch);

        if(curr.endOfWord){
            res.add(sb.toString());
            curr.endOfWord = false;
        }

        dfs(r + 1 , c , board, sb, curr);
        dfs(r - 1 , c , board, sb, curr);
        dfs(r, c - 1 , board, sb, curr);
        dfs(r, c + 1, board, sb, curr);

        sb.deleteCharAt(sb.length() - 1);

        visited[r][c] = false;
    }
}
