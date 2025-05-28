class Solution {

    public class TrieNode{
        public boolean isWord = false;
        public TrieNode[] child = new TrieNode[26];
        public TrieNode(){

        }
    }

    TrieNode root = new TrieNode();
    boolean[][] flag;
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        flag = new boolean[board.length][board[0].length];


        addToTrie(words);

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.child[board[i][j] - 'a'] != null){
                    search(board, i , j, root, "", result);
                }
            }
        }

        return new LinkedList<>(result);
    }


    private void addToTrie(String[] words){
        for(String word : words){
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(node.child[ch - 'a'] == null){
                    node.child[ch - 'a'] = new TrieNode();
                }
                node = node.child[ch - 'a'];
            }
            node.isWord = true;

        }
        
    }

    private void search(char[][] board, int row , int col , TrieNode node, String word, Set<String> result){
        if( row < 0  || row >= board.length || col < 0 || col >= board[row].length || flag[row][col] || node.child[board[row][col] - 'a'] == null){
            return;
        }

        flag[row][col] = true;
        node = node.child[board[row][col] - 'a'];
        if(node.isWord){
            result.add(word + board[row][col]);
        }

        search(board, row+1, col, node, word + board[row][col], result);
        search(board, row, col+1, node, word + board[row][col], result);
        search(board, row-1, col, node, word + board[row][col], result);
        search(board, row, col-1, node, word + board[row][col], result);
        flag[row][col] = false;
    }
}