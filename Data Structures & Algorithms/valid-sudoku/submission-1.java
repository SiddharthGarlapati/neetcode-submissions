class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rows = new HashMap<>();
        Map<Integer,Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for(int r = 0 ; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char ch = board[r][c];

                if(ch == '.') continue;


                String boxIndex = (r/3) + "," + (c/3);
                rows.putIfAbsent(r,new HashSet<>());
                cols.putIfAbsent(c,new HashSet<>());
                boxes.putIfAbsent(boxIndex,new HashSet<>());

                if(rows.get(r).contains(ch) ||
                   cols.get(c).contains(ch) ||
                   boxes.get(boxIndex).contains(ch)){
                    return false;
                }

                rows.get(r).add(ch);
                cols.get(c).add(ch);
                boxes.get(boxIndex).add(ch);

            }
        }

        return true;
    }
}
